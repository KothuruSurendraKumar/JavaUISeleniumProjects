package DemoSeleniumFramework.PracticeProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoSeleniumFramework.PracticeProject.abstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
	@FindBy(xpath="//h1[@class='hero-primary']")
	WebElement successMsg;
	
	//driver.findElement(By.xpath("//*[@class='em-spacer-1']//label[@class='ng-star-inserted']"))
	@FindBy(xpath="//*[@class='em-spacer-1']//label[@class='ng-star-inserted']")
	WebElement orderText;
	
	public String getSuccesMsg() {
		String msg = successMsg.getText();
		return msg;
	}
	
	public String getOrderId() {
		String orderMsg = orderText.getText();
		String[] orderArr = orderMsg.split("\\|");
		String result = orderArr[1].trim();
		return result;
	}

}
