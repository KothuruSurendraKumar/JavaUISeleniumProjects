package UIAutomationProject.UIProject.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UIAutomationProject.UIProject.base.BasePage;
import UIAutomationProject.UIProject.factory.Constant;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement register;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginBtn;
	
	public void goTo() {
		this.driver.get(Constant.BASE_URL);
		this.driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
	}
	
	public Register goToRegisterPage() {
		click(myAccount);
		click(register);
		return new Register(driver);
	}
	
	public Login navigateToLoginPage() {
		click(myAccount);
		click(loginBtn);
		return new Login(driver);
	}

}
