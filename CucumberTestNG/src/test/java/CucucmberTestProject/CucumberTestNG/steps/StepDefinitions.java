package CucucmberTestProject.CucumberTestNG.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import CucucmberTestProject.CucumberTestNG.utils.DataFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitions {
	
	WebDriver driver = DataFactory.getDriver();
	
	@Given("Get the title of page")
	public void get_the_title_of_page() {
		driver.get("https://www.gmail.com/");
		System.out.println("Page Title "+driver.getTitle());
		
	}
	
	@Given("Get the title of page google")
	public void get_the_title_of_page_google() {
		driver.get("https://www.google.com/");
		System.out.println("Page Title "+driver.getTitle());
		
	}
	
	@Then("verify the title {string}")
	public void verify_the_title(String expectedTtitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTtitle);
	}
	
	

}
