package test.java.factory;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static Properties props;
	public static WebDriver driver;

	public static Properties intilizeProperties() {
		props = new Properties();
		File profile = new File(System.getProperty("user.dir") + "//src//test//resources//config.properties");
		try {
			FileInputStream fis = new FileInputStream(profile);
			props.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}

	public static WebDriver IntilizeDriver() throws MalformedURLException {
		// TODO Auto-generated method stub

		props = intilizeProperties();
		String browser = props.getProperty("browser").toLowerCase();
		System.out.println("browser "+browser);
		String env = props.getProperty("execution_env").toLowerCase();
		System.out.println("env"+env);
		String platform = props.getProperty("os").toLowerCase();
		System.out.println("platform "+platform);

		if (env.equalsIgnoreCase("remote")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			switch (platform) {
			case "windows":
				caps.setPlatform(Platform.WINDOWS);
				break;
			case "mac":
				caps.setPlatform(Platform.MAC);
				break;
			case "linux":
				caps.setPlatform(Platform.LINUX);
				break;
			default:
				System.out.println("No matching OS");
				return null;
			}

			switch (browser) {
			case "chrome":
				ChromeOptions op = new ChromeOptions();
				op.addArguments("--no-sandbox");
				op.addArguments("--disable-dev-shm-usage");
				caps.setBrowserName("chrome");
				break;
			case "edge":
				caps.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				caps.setBrowserName("sirefox");
				break;
			default:
				System.out.println("No matching browser");
				return null;
			}

			driver = new RemoteWebDriver(new URL("http://192.168.43.49:4444"), caps);

		} else if (env.equalsIgnoreCase("local")) {
			switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();

				driver = new EdgeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("No matching browser");
				driver = null;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
