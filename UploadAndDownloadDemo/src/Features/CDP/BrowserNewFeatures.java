package Features.CDP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BrowserNewFeatures {

	@Test(dataProvider="dbDataProvider")
	public void executeTest(String username,String password){
		// TODO Auto-generated method stub
		
		System.out.println("User :"+username +" Password :"+password);
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		//driver.close();

	}
	
	@DataProvider(name = "dbDataProvider")
	public Object[][] dbDataProvider() throws SQLException{
		return DBUtils.getDataFromDB();
	}
	
	
	

}
