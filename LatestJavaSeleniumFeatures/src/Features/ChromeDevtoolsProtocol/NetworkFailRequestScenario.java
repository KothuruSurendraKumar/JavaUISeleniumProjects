package Features.ChromeDevtoolsProtocol;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.fetch.Fetch;
import org.openqa.selenium.devtools.v131.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v131.network.model.ErrorReason;

/*
 *We need to fail the request when we request is timedout ,access denied,wrong url etc..
 */

public class NetworkFailRequestScenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools tools = driver.getDevTools();
		tools.createSession();
		
		Optional<List<RequestPattern>> pattren = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));
		tools.send(Fetch.enable(pattren, Optional.empty()));
		
		tools.addListener(Fetch.requestPaused(), request ->{
			System.out.println(request.getRequest().getUrl());
			tools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

	}

}
