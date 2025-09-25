package SeleniumJavaFramework.testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleniumJavaFramework.resources.ExtentReportNG;

public class TestNGListeners extends BaseTests implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();//To get thread safe

	@Override
	public void onTestStart(ITestResult result) {
		// need to get testcase name before starting every test based on method name
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//sets the unique thread id
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// if test case got succedded print log message success message
		extentTest.get().log(Status.PASS, "Test got succeeded");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// If test case got failed we need error message why it's failed
		extentTest.get().fail(result.getThrowable());
		//if test fails add the screen shot for the the test case 1.take the screen shot and add to the report
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		String path = null;
		try {
			path = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
