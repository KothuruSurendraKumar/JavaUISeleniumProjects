package CucumberE2EProject.CucumberProject.driverFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	//public static WebDriver driver;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver intilizeBrowser(String browserName) {
		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			//options.addArguments("--headless");
			//driver = new ChromeDriver(options);
			driver.set(new ChromeDriver(options));
		} else if (browserName.contains("safari")) {
			driver.set(new SafariDriver());
		} else if (browserName.contains("edge")) {
			driver.set(new EdgeDriver());
		}
		driver.get().manage().deleteAllCookies();
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver.get();

	}

	public static WebDriver getDriver() {

		return driver.get();

	}
	
	public String getScreenShot(String testCaseName, ThreadLocal<WebDriver> driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	
	public static void quitDriver() {
		WebDriver driverInstance = driver.get();
        if (driverInstance != null) {
            driverInstance.quit();
            driver.remove();  // Clean up the driver after usage
        }
    }

}
