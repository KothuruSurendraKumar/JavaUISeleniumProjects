package SeleniumJavaFramework.testComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	int count =0;
	int retryCount = 1;

	//untill this method gets false this will re run the cases 
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count < retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
