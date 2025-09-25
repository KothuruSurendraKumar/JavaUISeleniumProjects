package UIAutomationProject.UIProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UIAutomationProject.UIProject.base.BasePage;
import UIAutomationProject.UIProject.utils.WaitUtils;

public class Login extends BasePage{
	
	
	
	public Login(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement usernameAndPassWrng;
	
	
	public Account loginAsExsistingUser(String email,String password) {
		enterText(emailField,email);
		enterText(passwordField,password);
		click(submitBtn);
		return new Account(driver);
		
	}
	
	public String invalidUser() {
		return WaitUtils.waitForVisibility(driver,usernameAndPassWrng).getText();
	}

}
