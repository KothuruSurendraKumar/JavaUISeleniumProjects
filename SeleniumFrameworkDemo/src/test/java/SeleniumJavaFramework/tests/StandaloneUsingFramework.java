package SeleniumJavaFramework.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import org.testng.Assert;

import SeleniumJavaFramework.pageObject.CartPage;
import SeleniumJavaFramework.pageObject.FinalPage;

import SeleniumJavaFramework.pageObject.OrderPage;
import SeleniumJavaFramework.pageObject.OrdersPage;
import SeleniumJavaFramework.pageObject.ProductsCatalog;
import SeleniumJavaFramework.testComponents.BaseTests;

public class StandaloneUsingFramework extends BaseTests {
	// String productName = "IPHONE 13 PRO";
	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String productName = input.get("product");
		ProductsCatalog productCatalog = landingPage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> items = productCatalog.getListItems();
		productCatalog.addProdToCart(productName);
		CartPage cartPage = productCatalog.goToCart();
		List<WebElement> cartItems = cartPage.getCartItems();
		Boolean match = cartPage.prodMatches(productName);
		Assert.assertTrue(match);

		OrderPage orderPage = cartPage.goToCheckout();
		orderPage.selectCountryByName("india");
		FinalPage finalPage = orderPage.placeOrder();

		String msg = finalPage.assertSuccessMsg();
		Assert.assertEquals(msg, "THANKYOU FOR THE ORDER.");
		finalPage.getOrderId();

	}

	@Test(dependsOnMethods = { "submitOrder" }, dataProvider = "getData", groups = { "Purchase" })
	public void OrderHistoryTest(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		ProductsCatalog productCatalog = landingPage.loginApplication(input.get("email"), input.get("password"));
		OrdersPage orderPage = productCatalog.goToOrders();
		Boolean matches = orderPage.prodMatches(input.get("product"));
		Assert.assertTrue(matches);

	}

	// 3rd way

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//SeleniumJavaFramework//data//PurcahseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

	// 2nd way to send data sets
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

	// 1st way to send data sets
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"kumar@don.com", "Kumar@123","IPHONE 13 PRO"},{"kumar@king.com", "King@123","ADIDAS ORIGINAL"}};
//	}

}
