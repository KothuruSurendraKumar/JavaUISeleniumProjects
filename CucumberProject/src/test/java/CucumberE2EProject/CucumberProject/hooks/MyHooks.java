package CucumberE2EProject.CucumberProject.hooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import CucumberE2EProject.CucumberProject.driverFactory.DriverFactory;
import CucumberE2EProject.CucumberProject.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

	public WebDriver driver;
	

	@Before
	public void setup() throws IOException {
		
		Properties prop = new ConfigReader().intilizeProperties();
		driver = DriverFactory.intilizeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		String scenarioName = scenario.getName().replaceAll(" ", "_");

		if (scenario.isFailed()) {
			// String screenShotPath = DriverFactory.getScreenshot(scenarioName);
			byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screen, "image/png", scenarioName);
		}
		//DriverFactory.quitDriver();

	}

	public String getScrrenshot(String scenarioName) {
		String screenshotDirectory = "target/screenshots/";
		File screenshotDir = new File(screenshotDirectory);
		if (!screenshotDir.exists()) {
			screenshotDir.mkdirs(); // Create directory if it doesn't exist
		}

		String screenshotPath = screenshotDirectory + scenarioName + "_" + System.currentTimeMillis() + ".png";

		// Capture the screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			// Use FileUtils to copy the screenshot to the target directory
			FileUtils.copyFile(screenshot, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return screenshotPath;
	}
	
//	@AfterClass
//    public static void tearDown() {
//		DriverFactory.quitDriver();
//    }

}
