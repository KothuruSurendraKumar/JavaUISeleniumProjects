package SeleniumJavaFramework.pageObject;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SeleniumJavaFramework.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
	@FindBy(xpath = "//div[@class='cartSection']//h3")
	List<WebElement> cartItems;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css = ".totalRow button")
	WebElement dropButton;
	
	
	
	public List<WebElement> getCartItems() {
		return cartItems;
	}
	
//	Boolean isMatch = cartItems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(productName));
//	Assert.assertTrue(isMatch);	
	public Boolean prodMatches(String prodName) {
		Boolean isMatch = cartItems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(prodName));
		return isMatch;
		
	}
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();

	public OrderPage goToCheckout() {
		dropButton.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	
	

}
