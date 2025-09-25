package TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class HomeLoan {
	
	@Parameters({"URL","username"})
	@Test
	public void webLoginHome(String URL,String username) {
		System.out.println("Web login Home");
		System.out.println("user name "+username);
		System.out.println("URL Link "+URL);
	}
	
	//if you need to skip any test method you can use this enabled= false
	@Test(enabled=false)
	public void MobileLoginHome() {
		System.out.println("Mobile login Home");
		System.out.println("Mobile login test");
	}
	
	/*
	 * 1.if we need to specific tests we need to group and intilize in xml file and run only particular testcases
	 * 2.if you need to run the particular case 1st need to use dependsOnMethods tag
	 * 
	 */
	
	@Test(groups= {"smoke"},dependsOnMethods= {"webLoginHome"})
	public void APILoginHome() {
		System.out.println("API login Home");
		System.out.println("Using REST API login");
		Assert.assertTrue(false);
	}
	
	

}
