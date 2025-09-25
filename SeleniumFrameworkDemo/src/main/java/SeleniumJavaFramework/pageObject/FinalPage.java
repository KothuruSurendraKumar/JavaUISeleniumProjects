package SeleniumJavaFramework.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SeleniumJavaFramework.AbstractComponents.AbstractComponent;

public class FinalPage extends AbstractComponent {

	WebDriver driver;

	public FinalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement successMsg;
	
	@FindBy(xpath="//*[@class='em-spacer-1']//label[@class='ng-star-inserted']")
	WebElement orderText;
	
//	String msg = driver.findElement(By.cssSelector(".hero-primary")).getText();
//	System.out.println(msg);
//	
//	Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText().trim(),  "THANKYOU FOR THE ORDER." );
	
//	String orderId = driver.findElement(By.xpath("//*[@class='em-spacer-1']//label[@class='ng-star-inserted']")).getText();
//	String[] orderArr = orderId.split("\\|");
//	String result = orderArr[1].trim();
//	System.out.println(result);

	
	public String assertSuccessMsg() {
		String msg = successMsg.getText();
		System.out.println(msg);
		return msg;
		
		
	}
	
	public void getOrderId() {
		String orderMsg = orderText.getText();
		String[] orderArr = orderMsg.split("\\|");
		String result = orderArr[1].trim();
		System.out.println(result);
	}
	
	
}
