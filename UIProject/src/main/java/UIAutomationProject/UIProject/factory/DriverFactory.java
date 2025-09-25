package UIAutomationProject.UIProject.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver getDriver(String browser) {
		WebDriver driver;
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
			chromeOptions.addArguments("--disable-extensions"); // Disable extensions
			chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
			chromeOptions.addArguments("--disable-dev-shm-usage");
			//to get chrome brower logs
			ChromeDriverService service = new ChromeDriverService.Builder().withLogOutput(System.out).build();
			driver = new ChromeDriver(service,chromeOptions);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default :
			throw new RuntimeException("Driver Not Supported " + browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		return driver;
	}

}
