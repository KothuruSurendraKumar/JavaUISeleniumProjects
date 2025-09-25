package DemoSeleniumFramework.PracticeProject.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoSeleniumFramework.PracticeProject.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.id("userEmail")).sendKeys("kumar@don.com");
	@FindBy(id="userEmail")
	WebElement userEmail;
	//driver.findElement(By.id("userPassword")).sendKeys("Kumar@123");
	@FindBy(id="userPassword")
	WebElement userPassword;
	//driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMsg;
	
	public String getErrorMsg() {
		waitUntiLocateWebElement(errorMsg);
		return errorMsg.getText();
	}
	
	public ProductCatalog submitForm(String email,String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

}
