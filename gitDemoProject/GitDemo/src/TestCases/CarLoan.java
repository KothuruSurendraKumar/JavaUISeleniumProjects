package TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CarLoan {
	
	@Parameters({"URL"})
	@Test
	public void webLoginCar(String urlName) {
		System.out.println("Web login Car");
		System.out.println("URL "+urlName);
	}
	
	@Test(groups= {"smoke"})
	public void MobileLoginCar() {
		System.out.println("Mobile login Car");
	}
	@Test
	public void APILoginCar() {
		System.out.println("API login Car");
	}
	

}
