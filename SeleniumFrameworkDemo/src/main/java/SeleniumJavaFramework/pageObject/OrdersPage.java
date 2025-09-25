package SeleniumJavaFramework.pageObject;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SeleniumJavaFramework.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent{
	WebDriver driver;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
	@FindBy(xpath = "//tr//td[2]")
	List<WebElement> orderItems;
	
	
	
	public List<WebElement> getOrderItems() {
		return orderItems;
	}
	
	public Boolean prodMatches(String prodName) {
		Boolean isMatch = orderItems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(prodName));
		return isMatch;
		
	}
	
	
	
	

}
