package UIAutomationProject.UIProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import UIAutomationProject.UIProject.base.BasePage;
import UIAutomationProject.UIProject.pages.Account.Logout;
import UIAutomationProject.UIProject.utils.WaitUtils;

public class Register extends BasePage{

	public Register(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement telephone;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement confirmPass;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement clickCheckBox;
	
	@FindBy(xpath="//input[contains(@value,'Continue')]")
	WebElement clickContinue;
	
	@FindBy(xpath = "//div[contains(text(), 'Warning')]")
    private WebElement warningMsg;
	
	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement accountBtn;
	
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement loginWrng;
	
	
	
	
	public Account.Success registerUser(String fName,String lName,String mail,String mobile,String pass,String cpass) {
		enterText(firstName,fName);
		enterText(lastName,lName);
		enterText(email,mail);
		enterText(telephone,mobile);
		enterText(password,pass);
		enterText(confirmPass,cpass);
		click(clickCheckBox);
		click(clickContinue);
		 return new Account.Success(driver);
		
	}
	
	public boolean isWarningMessageIsDisplayed() {
		return WaitUtils.waitForVisibility(driver, warningMsg).isDisplayed();
	}
	
	public boolean isEmailRegWarningMsgIsPresent() {
		return WaitUtils.waitForVisibility(driver, loginWrng).isDisplayed();
	}
	
	
	
	
	

}
