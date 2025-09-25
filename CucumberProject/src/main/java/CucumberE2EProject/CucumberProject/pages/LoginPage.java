package CucumberE2EProject.CucumberProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CucumberE2EProject.CucumberProject.utils.CommonUtils;
import CucumberE2EProject.CucumberProject.utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	//driver.findElement(By.id("input-email")).sendKeys("king.kohil@gmail.com");
	
	@FindBy(id="input-email")
	private WebElement emailFiled;
	
	//driver.findElement(By.id("input-password")).sendKeys("King@123");
	//driver.findElement(By.xpath("//*[@value='Login']")).click();
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//*[@value='Login']")
	private WebElement clickLogin;
	
	//driver.findElement(By.xpath("//*[contains(@class,'alert-dismissible')]").click();
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMsg;
	
	public void enterEmail(String email) {
		elementUtils.typeTestInField(emailFiled,email , CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String password) {
		elementUtils.typeTestInField(passwordField,password , CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountPage clickLogin() {
		elementUtils.clickOnElement(clickLogin, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	
	public String getWarningMessage() {
		return elementUtils.getTextFromElement(warningMsg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	
	
	

}
