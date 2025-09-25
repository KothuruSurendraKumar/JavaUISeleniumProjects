package test.java.pageObjs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObj {
	String msg;
	public WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	
	public LoginPageObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="login_Layer")
	WebElement loginButton;
	
	@FindBy(xpath="//input[contains(@placeholder,'Username')]")
	WebElement usernameField;
	
	@FindBy(xpath="//input[contains(@placeholder,'password')]")
	WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//img[@alt='Naukri Logo']")
	WebElement logo;
	
	@FindBy(xpath="//div[contains(@class,'server-err')]")
	WebElement	alert_msg;
	
	By logoLocator = By.xpath("//img[@alt='Naukri Logo']");
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void enterCredentials(String username,String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
	}
	
	public void clickSubmit() {
		
		submitButton.click();
	}
	
	public String verifyAlertMessage()
	{
		boolean res=alert_msg.isDisplayed();
		if(res)
		{
			msg=alert_msg.getText();
		}
		return msg;
	}
	
	public boolean loadLogo() {
		//boolean res = logo.isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(logo));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(logoLocator));
		return logo.isDisplayed();
	}
	
	

}
