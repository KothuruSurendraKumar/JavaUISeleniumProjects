package DemoSeleniumFramework.PracticeProject.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import DemoSeleniumFramework.PracticeProject.baseTests.BaseTest;
import DemoSeleniumFramework.PracticeProject.pageObjects.CartPage;
import DemoSeleniumFramework.PracticeProject.pageObjects.ConfirmationPage;
import DemoSeleniumFramework.PracticeProject.pageObjects.OrdersPage;
import DemoSeleniumFramework.PracticeProject.pageObjects.PaymentPage;
import DemoSeleniumFramework.PracticeProject.pageObjects.ProductCatalog;

public class StandAloneWebUsingFramework extends BaseTest{

	@Test(dataProvider="getData", groups={"Purchase"})
	public void startApplication(HashMap<String,String> input){
		String productName = input.get("product");
		ProductCatalog productCatalog = landingPage.submitForm(input.get("email"),input.get("password"));
		List<WebElement> productItems = productCatalog.getItems();
		productCatalog.addProdToCart(productName);

		CartPage cartPage = productCatalog.goToCart();
		List<WebElement> cartProducts = cartPage.getCartItems();
		Boolean isMatch = cartPage.checkProductMatchs(productName);
		Assert.assertTrue(isMatch);

		PaymentPage paymentPage = cartPage.goToCheckout();
		paymentPage.selectCountryByName("india");

		ConfirmationPage confirmation = paymentPage.goToConfirmation();
		String msg = confirmation.getSuccesMsg();
		AssertJUnit.assertEquals(msg, "THANKYOU FOR THE ORDER.");

		String orderId = confirmation.getOrderId();
		System.out.println("orderId :" + orderId);
	}
	
	@Test(dependsOnMethods= {"startApplication"},dataProvider="getData")
	public void checkOrderPage(HashMap<String,String> input) {
		//String productName = "ADIDAS ORIGINAL";
		ProductCatalog productCatalog = landingPage.submitForm(input.get("email"),input.get("password"));
		OrdersPage orderPage = productCatalog.goToOrders();
		Boolean matches = orderPage.prodMatches(input.get("product"));
		Assert.assertTrue(matches);
		
	}
	
	
	//3rd way get input from json file
	@DataProvider
	public Object[][] getData() throws IOException{
		List<HashMap<String,String>> map = getJsonData(System.getProperty("user.dir")+"//src//test//java//DemoSeleniumFramework//PracticeProject//data//InputData.json");
		return new Object[][] {{map.get(0)},{map.get(1)}};
	}
	
//2nd way
	
//	@DataProvider
//	public Object[][] getData() {
//
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "kumar@don.com");
//		map.put("password", "Kumar@123");
//		map.put("product", "IPHONE 13 PRO");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "kumar@king.com");
//		map1.put("password", "King@123");
//		map1.put("product", "ADIDAS ORIGINAL");
//
//		// instead of sending data sets use hashmap so we didnt intilize every parameter
//		// individually
//		// return new Object[][] {{"kumar@don.com", "Kumar@123","IPHONE 13
//		// PRO"},{"kumar@king.com", "King@123","ADIDAS ORIGINAL"}};
//		return new Object[][] { { map }, { map1 } };
//
//	}
//	
	
	
	//get input 1st way
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"kumar@don.com", "Kumar@123","IPHONE 13 PRO"},{"kumar@king.com", "King@123","ADIDAS ORIGINAL"}};
//	}

}
