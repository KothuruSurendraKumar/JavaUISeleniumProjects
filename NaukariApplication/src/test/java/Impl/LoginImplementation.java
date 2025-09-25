package test.java.Impl;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.java.factory.Base;
import test.java.pageObjs.LoginPageObj;

public class LoginImplementation {
	
	WebDriver driver;
	LoginPageObj loginPage;
	
	//land on naukari page
	@Given("land on naukari page")
	public void land_on_naukari_page() {
		loginPage = new LoginPageObj(Base.getDriver());
		loginPage.clickLogin();
	}
	
	//I enter username "xxxxgmail.com" and password "abcderty"
	//@When("^I enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	@When("^I enter username (.+) and password (.+)")
	public void I_enter_username_and_password(String username,String password) {
		loginPage.enterCredentials(username, password);
	}
	
	//click the login button
	@And("click the login button")
	public void click_the_login_button() {
		loginPage.clickSubmit();
	}
	
	//@Then("^verify \"([^\"]*)\" message based on credentials entered$")
	@Then("^verify (.+) message based on credentials entered")
	public void verify_message_based_on_credentials_entered(String actual) {
		String expected = loginPage.verifyAlertMessage();
		Assert.assertEquals(expected, actual);
	}
	
	//user should land on homepage
	@Then("user should land on homepage")
	public void user_should_land_on_page() {
		boolean res = loginPage.loadLogo();
		Assert.assertTrue(res);
	}

}
