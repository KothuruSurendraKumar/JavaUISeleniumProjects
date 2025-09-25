package Features.ChromeDevtoolsProtocol;

/*
 * we requirement that in evry country we dont have same internent speed some places we have 5G some places we have $G,3G,2G 
 * and some places there is no internet
 * some places we have wifi connection
 * some places we have wire connection known as Ethernet
 * we can network the test in different N/w speeds
 */

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.network.model.ConnectionType;

public class NetworkSpeedScenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools tools = driver.getDevTools();
		
		tools.createSession();
		
		tools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		//Run the test in Ethernet
		//tools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET), Optional.empty(), Optional.empty(), Optional.empty()));
		//Run the test in Offline
		tools.send(Network.emulateNetworkConditions(true, 3000, 20000, 100000, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		//Run the test in 2G
		//tools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.WIFI), Optional.empty(), Optional.empty(), Optional.empty()));
		//Run the test in wifi
		//tools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.WIFI), Optional.empty(), Optional.empty(), Optional.empty()));
		//Run the test in bluetooth
		//tools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.BLUETOOTH), Optional.empty(), Optional.empty(), Optional.empty()));
		
		//if loading failed we need to get why it's failed which time time it's failed we can get
		tools.addListener(Network.loadingFailed(), loadingFailed ->{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
		});
		
		long start = System.currentTimeMillis();
//		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.RETURN);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();

		String title = driver.findElement(By.cssSelector("h1[class*='default-ltr-cache-jmnae']")).getText();

		System.out.println(title);
		long end = System.currentTimeMillis();
		//17760
		
		System.out.println(end - start);
		driver.close();
	}

}
