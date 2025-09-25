package CucumberE2EProject.CucumberProject.stepImpl;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import CucumberE2EProject.CucumberProject.driverFactory.DriverFactory;
import CucumberE2EProject.CucumberProject.pages.AccountSuccesPage;
import CucumberE2EProject.CucumberProject.pages.HomePage;
import CucumberE2EProject.CucumberProject.pages.RegisterPage;
import CucumberE2EProject.CucumberProject.utils.CommonUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {

	WebDriver driver;
	RegisterPage registerPage = new RegisterPage(driver);
	AccountSuccesPage succesPage = new AccountSuccesPage(driver);

	// user navigates to register account page
	@Given("user navigates to register account page")
	public void user_navigates_to_register_account_page() {
		driver = DriverFactory.getDriver();
		HomePage home = new HomePage(driver);
		home.clickOnMyAccount();
		registerPage = home.clickOnRegister();
	}

	// user enters all mandetory fields
	@When("user enters all mandetory fields")
	public void user_enters_all_mandetory_fields(DataTable data) {
		Map<String, String> dataMap = data.asMap(String.class, String.class);

		registerPage.enterFirstName(dataMap.get("firstname"));
		registerPage.enterLastName(dataMap.get("lastname"));
		CommonUtils com = new CommonUtils();
		registerPage.enterEmailAddress(com.getEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
	}

	// user clicks newsstaller checkbox

	@And("user clicks newsstaller checkbox")
	public void user_clicks_newsstaller_checkbox() {
		registerPage.selectYesNewsletterOption();
	}

	// user click privacy policy
	@And("user click privacy policy")
	public void user_click_privacy_policy() {
		registerPage.selectPrivacyPolicy();
	}

	// user clicks continue button
	@And("user clicks continue button")
	public void user_click_continoue_button() {
		succesPage = registerPage.clickOnContinoue();
	}

	// user registers succesfully
	@Then("user registers succesfully")
	public void user_registers_succesfully() {
		String actual = succesPage.getSuccessMessage();
		Assert.assertEquals("Your Account Has Been Created!", actual);
	}

	// user need to get respective warning message
	@Then("user need to get respective warning message")
	public void user_need_to_get_respective_warning_message() {
		String actual = registerPage.getWarningMessageText();
		Assert.assertEquals("Warning: E-Mail Address is already registered!", actual);
	}

	// user enters all mandetory fields with duplicate email
	@When("user enters all mandetory fields with duplicate email")
	public void user_enters_all_mandetory_fields_with_duplicate_email(DataTable data) {
		Map<String, String> dataMap = data.asMap(String.class, String.class);

		registerPage.enterFirstName(dataMap.get("firstname"));
		registerPage.enterLastName(dataMap.get("lastname"));
		registerPage.enterEmailAddress(dataMap.get("email"));
		registerPage.enterTelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
	}

	// user donot enter any field
	@When("user donot enter any field")
	public void user_donot_enter_any_fieldd() {
		registerPage.enterFirstName("");
		registerPage.enterLastName("");
		registerPage.enterEmailAddress("");
		registerPage.enterTelephoneNumber("");
		registerPage.enterPassword("");
		registerPage.enterConfirmPassword("");
	}

	// user need to get respective warning messages for every field
	@Then("user need to get respective warning messages for every field")
	public void user_need_to_get_respective_warning_message_for_every_field() {
		Assert.assertTrue(
				registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 character", registerPage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarning());

	}

}
