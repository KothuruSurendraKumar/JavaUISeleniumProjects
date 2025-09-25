package SeleniumJavaFramework.tests;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SeleniumJavaFramework.pageObject.CartPage;
import SeleniumJavaFramework.pageObject.ProductsCatalog;
import SeleniumJavaFramework.testComponents.BaseTests;

public class ErrorHandilingTests extends BaseTests {

	@Test(groups = { "errorHandling" }, retryAnalyzer = SeleniumJavaFramework.testComponents.Retry.class)
	public void loginPageValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		landingPage.loginApplication("kuma@don.com", "Kumar123");
		String error = landingPage.getErrorMsg();
		System.out.println("error" + error);
		Assert.assertEquals("Incorrect email or Password.", error);

	}

	@Test
	public void productCatalogValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String productName = "IPHONE 13 PRO";
		ProductsCatalog productCatalog = landingPage.loginApplication("kumar@king.com", "King@123");

		List<WebElement> items = productCatalog.getListItems();
		productCatalog.addProdToCart(productName);
		CartPage cartPage = productCatalog.goToCart();
		List<WebElement> cartItems = cartPage.getCartItems();
		Boolean match = cartPage.prodMatches("IPHONE 14 PRO");
		Assert.assertFalse(match);

	}

}
