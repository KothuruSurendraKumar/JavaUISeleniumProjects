package TestCases;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersDemo implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test got Failed"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test got Suucceded" +result.getName());
	}
	

}
