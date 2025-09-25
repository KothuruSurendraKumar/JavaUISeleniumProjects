package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderDemo {
	
	@Test(dataProvider="testData")
	public void collectData(String uname,String pass) {
		System.out.println("Collection Data....");
		System.out.println(uname);
		System.out.println(pass);
	}
	
	@DataProvider(name="testData")
	public Object[][] getData() {
		//intilize multi dimensional array .Here Rows represends - no of data sets
		//columns represents - no of values
		//I need 3 data sets with 2 values
		Object[][] data = new Object[3][2];
		
		//1st data set
		data[0][0] = "FirstUsername";
		data[0][1] = "FirstPassword";
		
		//2nd data set
		data[1][0] = "SecondUsername";
		data[1][1] = "SecondPassword";
		
		//3rd data set
		data[2][0] = "ThirdUsername";
		data[2][1] = "ThirdPassword";
		
		return data;
				
	}

}
