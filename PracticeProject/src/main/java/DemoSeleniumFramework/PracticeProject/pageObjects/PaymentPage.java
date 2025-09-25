package DemoSeleniumFramework.PracticeProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import DemoSeleniumFramework.PracticeProject.abstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent {

	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement enterCountry;
	
	//driver.findElement(By.xpath("//button[contains(@class,'active')]")).click();
	@FindBy(xpath="//button[contains(@class,'active')]")
	WebElement selectCountry;
	
	//driver.findElement(By.xpath("//*[contains(@class,'action__submit')]")).click();
	@FindBy(xpath="//*[contains(@class,'action__submit')]")
	WebElement placeOrder;
	
	By countryList = By.xpath("//section[contains(@class,'list-group')]");
	
	public void selectCountryByName(String countryName) {
		enterCountry.sendKeys(countryName);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'list-group')]")));
		waitUntilLocate(countryList);
		enterCountry.sendKeys(Keys.DOWN);
		enterCountry.sendKeys(Keys.DOWN);
		selectCountry.click();
	}
	
	public ConfirmationPage goToConfirmation() {
		placeOrder.click();
		ConfirmationPage confirmation = new ConfirmationPage(driver);
		return confirmation;
	}

}
