package UIAutomationProject.UIProject.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import UIAutomationProject.UIProject.reporting.TestLog;

public class ScreenshotUtils {
	
	public static void captureScreenshot(WebDriver driver,String testname) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/src/test/resources/screenshots/"+testname+"_"+System.currentTimeMillis()+".png";
		try {
			FileHandler.copy(file, new File(path));
			TestLog.stepInfo("Screenshot captured and saved in path :"+path);
		}catch(Exception e) {
			TestLog.stepInfo("Screenshot capture failed"+e.getMessage());
		}
	}

}
