package SeleniumJavaFramework.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumJavaFramework.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("ind");
	@FindBy(xpath = "//*[@placeholder='Select Country']")
	WebElement countryDropdown;
	
	//driver.findElement(By.xpath("//button[contains(@class,'active')]")).click();
	@FindBy(xpath="//button[contains(@class,'active')]")
	WebElement selectCountry;
	
	//driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css=".action__submit")
	WebElement orderButton;
	
	By listGroup = By.xpath("//*[contains(@class,'list-group')]");
	
	
	//driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("ind");
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'list-group')]")));
//	driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys(Keys.DOWN);
//	driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys(Keys.DOWN);
	public void selectCountryByName(String countryName) {
		countryDropdown.sendKeys(countryName);
		waitUntiLocate(listGroup);
		countryDropdown.sendKeys(Keys.DOWN);
		countryDropdown.sendKeys(Keys.DOWN);
		selectCountry.click();
		
	}
	
	public FinalPage placeOrder() {
		orderButton.click();
		return new FinalPage(driver);
	}
	
	
	

}
