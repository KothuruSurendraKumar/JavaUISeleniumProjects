package CucumberE2EProject.CucumberProject.stepImpl;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import CucumberE2EProject.CucumberProject.driverFactory.DriverFactory;
import CucumberE2EProject.CucumberProject.pages.AccountPage;
import CucumberE2EProject.CucumberProject.pages.HomePage;
import CucumberE2EProject.CucumberProject.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
	
	WebDriver driver;
	AccountPage account;
	SearchPage searchPage;
	
	@Given("User opens the Application")
	public void user_opens_the_application() {
		driver = DriverFactory.getDriver();
		account = new AccountPage(driver);
		searchPage = new SearchPage(driver);
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_index(String productName) {
		account.clickIntoSearchBox();
		account.enterProductIntoSearchBox(productName);
		
	}
	
	@And("User clicks on Search button")
	public void user_clicks_on_search_button() {
		searchPage = account.clickSearchButton();
	}
	
	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertTrue(searchPage.displayStatusOfValidProduct());
	}
}
