package SeleniumJavaFramework.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumJavaFramework.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//driver.findElement(By.id("userEmail"));
	//instead of writng this way we have another way using pageFactory annotations
	
	////driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//driver.findElement(By.id("userPassword"))
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	//driver.findElement(By.id("login"))
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMsg;
	
	public String getErrorMsg() {
		waitUntiLocateWebElement(errorMsg);
		return errorMsg.getText();
	}
	
	public ProductsCatalog loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductsCatalog productCatalog = new ProductsCatalog(driver);
		return productCatalog;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	

}
