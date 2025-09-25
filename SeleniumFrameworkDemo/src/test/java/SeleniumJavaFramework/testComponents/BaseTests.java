package SeleniumJavaFramework.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumJavaFramework.pageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {

	public WebDriver driver;
	public LandingPage landingPage;

	// get the details from property file in which browser we need to run

	public WebDriver invokeBrowser() throws IOException {

		Properties props = new Properties();
		FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//SeleniumJavaFramework//resources//GlobalData.properties");
		props.load(inputStream);

		// get the browser name from mvn command
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: props.getProperty("browser");

		// String browserName = props.getProperty("browser");
		if (browserName.contains("chrome")) {
			// usually we set the chrome driver path and we will use.with webdriver manager
			// it became simple without downloading any drivers
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromiumdriver().setup();
			// run the cases in headless mode
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			// run the browser in full screen mode
			driver.manage().window().setSize(new Dimension(1440, 900));

		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		return driver;
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// convert json into string -use file utils
		String jsonDataString = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// convert string into map - use jakson data bind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonDataString,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		// above list contains 2 hash maps which we added in json data
		return data;
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = invokeBrowser();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}
}
