package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo1 {
	
	@Test
	public void Demo(){
		System.out.println("Hello");
		
	}
	@Test(groups= {"smoke"})
	public void DemoTwo(){
		System.out.println("Hello,world");
		
	}
	
	
	//For every test before it will execute.
	//we can write any place
	@BeforeTest
	public void prerequstites() {
		System.out.println("Fitst Executed");
	}
	
	@AfterTest
	public void postrequsties() {
		System.out.println("Last executed");
	}
	
	@BeforeSuite
	public void preSuite() {
		System.out.println("1st case will execute");
	}
	
	@AfterSuite
	public void postSuite() {
		System.out.println("Last case will execute");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Execute Before Every Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Execute After Method");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Will execute before all class methods");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Will execute after all class methods");
	}
	

}
