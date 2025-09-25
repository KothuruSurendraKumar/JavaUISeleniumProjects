package CucucmberTestProject.CucumberTestNG.utils;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DataFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void intilizeDriver() {
		try {
			String browser = System.getProperty("browser", "chrome").toLowerCase(); // defult browser
			DesiredCapabilities cap = new DesiredCapabilities();
			switch(browser) {
				case "chrome":
					cap.setPlatform(org.openqa.selenium.Platform.MAC);
					cap.setBrowserName("chrome");
					break;
				case "safari":
					cap.setPlatform(org.openqa.selenium.Platform.MAC);
					cap.setBrowserName("safari");
					break;
				case "firefox":
					cap.setPlatform(org.openqa.selenium.Platform.MAC);
					cap.setBrowserName("firefox");
					break;
				default:
	                throw new IllegalArgumentException("Unsupported browser: " + browser);
			}
			
			//WebDriver remote = new RemoteWebDriver(new URI("http://192.168.20.50:4444").toURL(), cap);
			driver.set(new RemoteWebDriver(new URL("http://192.168.43.49:4444/wd/hub"), cap));
			//driver.set(remote);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
        return driver.get();
    }

	public static void quitDriver() {
		driver.get().quit();
		driver.remove();
	}

}
