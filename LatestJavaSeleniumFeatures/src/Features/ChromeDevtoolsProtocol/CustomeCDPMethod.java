package Features.ChromeDevtoolsProtocol;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

//if we dont have custome method we can create Custome CDP method and run

public class CustomeCDPMethod {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map map = new HashMap();
		map.put("width", 600);
		map.put("height", 1000);
		map.put("deviceScaleFactor", 50);
		map.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", map);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[class='navbar-toggler']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();

	}

}
