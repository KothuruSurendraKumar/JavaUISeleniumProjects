package CucumberE2EProject.CucumberProject.stepImpl;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import CucumberE2EProject.CucumberProject.driverFactory.DriverFactory;
import CucumberE2EProject.CucumberProject.pages.AccountPage;
import CucumberE2EProject.CucumberProject.pages.HomePage;
import CucumberE2EProject.CucumberProject.pages.LoginPage;
import CucumberE2EProject.CucumberProject.utils.CommonUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private AccountPage accountPage;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.clickOnLogin();
	}
	
	@When("^User enters valid email address (.+) into email field")
    public void user_enters_valid_email_address_into_email_field(String username) {
		loginPage.enterEmail(username);
		
	}
	
	@When("^User enters valid password (.+) into password field")
	public void user_enters_valid_password_into_password_field(String password) {
		loginPage.enterPassword(password);
	}
	
	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		accountPage = loginPage.clickLogin();
	}
	
	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}
	
	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		CommonUtils c = new CommonUtils();
		loginPage.enterEmail(c.getEmailWithTimeStamp());
	}
	
	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String password) {
		loginPage.enterPassword(password);
	}
	
	
	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));;
	}
	@Then("User should get a proper warning message about credentials invalid")
	public void user_should_get_a_proper_warning_message_about_credentials_invalid() {
		Assert.assertTrue(loginPage.getWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));;
	}
	
	@When("User do not enter valid email address into email field")
	public void user_do_not_enter_valid_email_address_into_email_field() {
		loginPage.enterEmail("");
	}
	
	@When("User do not enters valid password into password field")
	public void user_do_not_enters_valid_password_into_email_field() {
		loginPage.enterPassword("");
	}
	
	@When("user enter the email {string}")
	public void user_enter_the_email(String email) {
		loginPage.enterEmail(email);
	}
	
	@When("user enters the password {string}")
	public void user_enters_the_password(String password) {
		loginPage.enterPassword(password);
	}
}

