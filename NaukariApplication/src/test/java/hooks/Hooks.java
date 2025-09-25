package test.java.hooks;

import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import test.java.factory.Base;

public class Hooks {
	
	public WebDriver driver;
	
	@Before
	public void setUp() throws MalformedURLException {
		Properties props = Base.intilizeProperties();
		driver = Base.IntilizeDriver();
		driver.get(props.getProperty("appURL"));
		
	}
	@After
	public void tearDown(Scenario scenario) {
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed()) {
			byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screen, "image/png", scenarioName);
		}
		
		driver.quit();
	}

	

}
