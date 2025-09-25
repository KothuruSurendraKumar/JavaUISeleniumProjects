package DemoSeleniumFramework.PracticeProject.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import DemoSeleniumFramework.PracticeProject.abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
	@FindBy(xpath = "//div[@class='cartSection']//h3")
	List<WebElement> cartItems;
	
	//driver.findElement(By.xpath("//li[@class='totalRow']//button")).click();
	@FindBy(xpath="//li[@class='totalRow']//button")
	WebElement checkout;

	public List<WebElement> getCartItems() {
		return cartItems;
	}

	public Boolean checkProductMatchs(String productName) {
		Boolean isMatch = cartItems.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));

		// System.out.println("cat product : "+prodName);
		return isMatch;
	}
	
	public PaymentPage goToCheckout() {
		checkout.click();
		PaymentPage paymentPage = new PaymentPage(driver);
		return paymentPage;
	}
	
	

}
