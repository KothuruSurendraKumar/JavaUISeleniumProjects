package com;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.*;

public class GridDemoClass {
	
	@Test
	public void HomePageCheck() throws MalformedURLException, URISyntaxException {
		//Normally we create driver obj as
		//WebDriver driver = new ChromeDriver();
		
		DesiredCapabilities caps = new DesiredCapabilities();
		//set which browser we need
		caps.setBrowserName("chrome");
		//set platform which platform we need to run Mac.windows,linux
		//caps.setPlatform(Platform.WINDOWS);
		//we can set more capabalities
		//like this also we can browser
//		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
		//to execute in grid
		WebDriver driver = new RemoteWebDriver(new URI("http://192.168.43.49:4444").toURL(),caps);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("something we need");
		System.out.println("title"+driver.getTitle());
		driver.close();
		
	}

}
