package CucumberE2EProject.CucumberProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CucumberE2EProject.CucumberProject.utils.CommonUtils;
import CucumberE2EProject.CucumberProject.utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	//driver.findElement(By.xpath("//a[@title='My Account']")).click();
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccount;
	
	//driver.findElement(By.xpath("//*[text()='Login']")).click();
	@FindBy(xpath="//*[text()='Login']")
	private WebElement loginOption;
	
	@FindBy(xpath="//*[text()='Register']")
	private WebElement registerOption;
	
	
	
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccount, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public RegisterPage clickOnRegister() {
		elementUtils.clickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	
	public LoginPage clickOnLogin() {
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	
	
	
	

}
