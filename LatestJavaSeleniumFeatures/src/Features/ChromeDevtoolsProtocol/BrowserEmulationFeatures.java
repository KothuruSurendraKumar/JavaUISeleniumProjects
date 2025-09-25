package Features.ChromeDevtoolsProtocol;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.WebDriver;

/*
 * Chrome and edge driver are implemented from chromium driver
 * So we can use Chrome Devtools which implements chromium driver implemented browsers
 * 
 * 
 * In this particular test we used to test the case in different devices like phone,Tablet,Laptop etc..
 */

public class BrowserEmulationFeatures {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--window-position=600,1000");
		option.addArguments("--window-size=1200,800"); 
		ChromeDriver driver = new ChromeDriver(option);
//		DevTools devTools = driver.getDevTools();
//		devTools.createSession();
//		
//		devTools.send(Emulation.setDeviceMetricsOverride(1920, 1080, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[class='navbar-toggler']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
		
//		ChromeOptions options = new ChromeOptions();
//		WebDriver driver = new ChromeDriver(options);
//		
//		DevTools devTools  = ((ChromeDriver)driver).getDevTools();
//		devTools.createSession();
//		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
//		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//		driver.findElement(By.cssSelector(".navbar-toggler")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("a[contains(@routerlink,'library')]")).click();
		
		

	}

}
