package DemoSeleniumFramework.PracticeProject.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import DemoSeleniumFramework.PracticeProject.baseTests.BaseTest;
import DemoSeleniumFramework.PracticeProject.pageObjects.CartPage;
import DemoSeleniumFramework.PracticeProject.pageObjects.ProductCatalog;

public class ErrorValidation extends BaseTest{
	
	@Test(groups={"error"})
	public void loginPageValidation() {
		landingPage.submitForm("Kumar@don.com", "Kumar123");
		String error = landingPage.getErrorMsg();
		System.out.println("error" + error);
		Assert.assertEquals("Incorrect email or Password.", error);
	}
	
	@Test(groups={"error"})
	public void productCatlogValidation() {
		String productName = "IPHONE 13 PRO";
		ProductCatalog productCatalog = landingPage.submitForm("kumar@king.com", "King@123");
		List<WebElement> productItems = productCatalog.getItems();
		productCatalog.addProdToCart(productName);
		CartPage cartPage = productCatalog.goToCart();
		List<WebElement> cartProducts = cartPage.getCartItems();
		Boolean isMatch = cartPage.checkProductMatchs("IPHONE 14 PRO");
		Assert.assertFalse(isMatch);
		
	}
}
