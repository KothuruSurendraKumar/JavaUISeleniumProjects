package SeleniumJavaFramework.stepImplementations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SeleniumJavaFramework.pageObject.CartPage;
import SeleniumJavaFramework.pageObject.FinalPage;
import SeleniumJavaFramework.pageObject.LandingPage;
import SeleniumJavaFramework.pageObject.OrderPage;
import SeleniumJavaFramework.pageObject.ProductsCatalog;
import SeleniumJavaFramework.testComponents.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefenition extends BaseTests{
	
	public LandingPage landingPage;
	public ProductsCatalog productCatalog;
	public FinalPage finalPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		//code
		landingPage = launchApplication();
	}
	
	//as we are passing input values as dynamically we use regex
	@Given("^Login with user (.+) and password (.+)$")
	public void Login_with_username_and_password(String username,String password) {
		productCatalog = landingPage.loginApplication(username,password);
	}
	
	@When("^I add product (.+) to cart$")
	public void Add_product_to_cart(String productName) throws InterruptedException {
		List<WebElement> items = productCatalog.getListItems();
		productCatalog.addProdToCart(productName);
	}
	//Here we can use @And or @When
	@When("^checkout (.+) and submit the order$")
	public void Submit_the_order(String productName) {
		CartPage cartPage = productCatalog.goToCart();
		List<WebElement> cartItems = cartPage.getCartItems();
		Boolean match = cartPage.prodMatches(productName);
		Assert.assertTrue(match);

		OrderPage orderPage = cartPage.goToCheckout();
		orderPage.selectCountryByName("india");
		finalPage = orderPage.placeOrder();
	}
	
	@Then("{string} message is displayed in Confirmation Page")
	public void validateMessage(String actual) {
		String msg = finalPage.assertSuccessMsg();
		Assert.assertEquals(msg, actual);
		finalPage.getOrderId();
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void validateErrorMessage(String actual) {
		String error = landingPage.getErrorMsg();
		System.out.println("error" + error);
		Assert.assertEquals(actual, error);
		driver.close();
	}

}
