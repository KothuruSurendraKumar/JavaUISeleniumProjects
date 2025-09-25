package Features.ChromeDevtoolsProtocol;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.network.model.Response;

//import com.google.common.collect.Maps;

import org.openqa.selenium.devtools.v131.network.model.Request;

public class NetworkLogActivity {
	private static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		
		
		//Enable the network
		devTools.send(Network.enable(Optional.empty(),Optional.empty(), Optional.empty()));
		
		//After fired get the urls responecodes,headers etc...Get the details before sending the rquest in UI
		devTools.addListener(Network.requestWillBeSent(), request -> {
			Request req = request.getRequest();
			//System.out.println(req.getUrl());
			map.put(req.getUrl(), null);
		});
		//get deatils after sending request
		devTools.addListener(Network.responseReceived(), response ->{
			Response res = response.getResponse();
			//System.out.println(res.getStatus());
			String url = res.getUrl();
			map.put(url, res.getStatus());
			//instead of seeing all urls pring only failed urls
			if(res.getStatus() >= 400) {
				System.out.println(res.getUrl() + "Is failing with the status code "+res.getStatus());
			}else {
				System.out.println(res.getUrl() + " working and giving status code as  "+res.getStatus());
			}
		});
		
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		try {
            // A simple sleep to ensure requests are captured
            Thread.sleep(5000); // Adjust the wait time based on network activity
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		//printTheResponseAndRequestCalls();
		driver.quit();
		
		

	}

	private static void printTheResponseAndRequestCalls() {
		// TODO Auto-generated method stub
		for(Map.Entry<String, Integer> m : map.entrySet()) {
			String url = m.getKey();
			int status = m.getValue();
			System.out.println(url + " "+status);
		}
		
	}

	

}
