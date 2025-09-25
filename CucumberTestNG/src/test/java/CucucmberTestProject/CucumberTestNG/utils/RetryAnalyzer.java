package CucucmberTestProject.CucumberTestNG.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	private int intialCount = 0;
	private static final int maxRetryCount = 2;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Retrying test: " + result.getName() + ", attempt: " + maxRetryCount);
		if(intialCount < maxRetryCount) {
			intialCount++;
			return true;
		}
		return false;
	}

}
