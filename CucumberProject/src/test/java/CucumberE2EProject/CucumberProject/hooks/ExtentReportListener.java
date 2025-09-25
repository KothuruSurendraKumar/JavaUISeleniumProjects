package CucumberE2EProject.CucumberProject.hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import CucumberE2EProject.CucumberProject.driverFactory.DriverFactory;



public class ExtentReportListener extends DriverFactory implements ITestListener {
	
	private static ExtentReports extent;
	private static ExtentTest test;

	// Initialize ExtentReports with the location of the report
	static {
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.pass("Test Passed");
		test.log(Status.PASS, "Test Succeded");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		test.fail(result.getThrowable());
		//WebDriver driver = DriverFactory.getDriver();
		if (driver != null) {
            String screenshotPath = "";
            try {
                screenshotPath = getScreenShot(result.getMethod().getMethodName(),driver);
                System.out.println("path:"+screenshotPath);
                //String relativeScreenshotPath = "reports/" + result.getMethod().getMethodName() + ".png"; 
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
                test.fail("Failed to capture screenshot due to IOException.");
            }
        } else {
            test.fail("WebDriver is null, unable to capture screenshot.");
        }
//		try {
//			driver = (ThreadLocal<WebDriver>) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		
//		
//		String path = null;
//		try {
//			path = getScreenShot(result.getMethod().getMethodName(),driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		test.addScreenCaptureFromPath(path,result.getMethod().getMethodName());
		
	}

	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}

	

	

}
