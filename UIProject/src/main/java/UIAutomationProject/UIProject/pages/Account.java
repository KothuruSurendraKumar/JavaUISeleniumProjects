package UIAutomationProject.UIProject.pages;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import UIAutomationProject.UIProject.base.BasePage;
import UIAutomationProject.UIProject.reporting.TestLog;
import UIAutomationProject.UIProject.utils.WaitUtils;

public class Account extends BasePage {

	public Account(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Edit your account information')]")
	private WebElement editInfo;
	
	@FindBy(xpath="//a[contains(text(),'Change your password')]")
	private WebElement chngPaswd;
	
	@FindBy(xpath="//a[contains(text(),'Modify your address book entries')]")
	private WebElement modifyBookEntry;
	
	@FindBy(xpath="//a[contains(text(),'Modify your wish list')]")
	private WebElement modifyWishlist;
	
	@FindBy(xpath="//a[contains(text(),'View your order history')]")
	private WebElement viewOrder;
	
	@FindBy(xpath="//a[contains(text(),'Your Reward Points')]")
	private WebElement rewardPoints;
	
	@FindBy(xpath="//a[contains(text(),'View your return requests')]")
	private WebElement returnRequests;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logout;
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccount;
	
	public static class Logout extends Account{

		public Logout(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//div[@id='content']/h1")
		private WebElement accountLogout;
		
		@FindBy(xpath="//div[@id='content']/p")
		private WebElement logOffMsg;
		
		@FindBy(xpath="//p[text()='Your shopping cart has been saved, the items inside it will be restored whenever you log back into your account.']")
		private WebElement logOutfMsg;
		
		@FindBy(xpath="//a[contains(text(),'Continue')]")
		private WebElement continueBtn;
		
		public boolean isAccountLogoffMesgIsDisplayed() {
			return WaitUtils.waitFor(ExpectedConditions.visibilityOf(accountLogout), driver, 5).isDisplayed();
		}
		
		public boolean isLogoffMsgIsDisplayed() {
			return WaitUtils.waitFor(ExpectedConditions.visibilityOf(logOffMsg), driver, 5).isDisplayed();
		}
		
		public boolean isLogoutMsgIsDisplayed() {
			return WaitUtils.waitFor(ExpectedConditions.visibilityOf(logOutfMsg), driver, 5).isDisplayed();
		}
		
		public boolean isContinueButtonIsEnabled() {
			return WaitUtils.waitFor(ExpectedConditions.elementToBeClickable(continueBtn), driver, 5).isEnabled();
		}
		
		public HomePage navigateToHomepage() {
			click(continueBtn);
			return new HomePage(driver);
		}
		
	}

	public static class Success extends Account {

		public Success(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
		private WebElement accountCreation;

		@FindBy(xpath = "//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]")
		private WebElement congratulationMsg;

		@FindBy(xpath = "//p[contains(text(), 'If you have ANY questions about the operation of this online shop, please e-mail the store owner.')]")
		private WebElement queryMsg;

		@FindBy(xpath = "//a[contains(@href, 'account/account') and contains(text(), 'Continue')]")
		private WebElement continueBtn;
		
		
		
		
		
		
		private void verifyElementOrEnabled(WebElement element,String eleName) {
			if(element.isDisplayed() || element.isEnabled()) {
				TestLog.stepInfo(eleName+" is displayed or enabled");
			}else {
				throw new AssertionError(eleName+" is not displayed or enabled");
			}
		}
		
		public void verifyAccountSuccessPageElements() {
			verifyElementOrEnabled(accountCreation,"Account Creation Heading");
			verifyElementOrEnabled(congratulationMsg,"Congratulations Message");
			verifyElementOrEnabled(queryMsg,"Query Message");
			verifyElementOrEnabled(continueBtn,"Continue Button");
			
		}
		
		public Account navigateToAccountPage() {
			WaitUtils.waitForClickable(driver, continueBtn).click();
			return new Account(driver);
		}

	}
	
	public void verifyAccountPageElements() {
		verifyElementIsDisplayed(editInfo,"Edit account info");
		verifyElementIsDisplayed(chngPaswd,"Change Password");
		verifyElementIsDisplayed(modifyBookEntry,"Modify the Book ENtry");
		verifyElementIsDisplayed(modifyWishlist,"Modify the Wish List");
		verifyElementIsDisplayed(viewOrder,"View Order History");
		verifyElementIsDisplayed(rewardPoints,"Your Reward Point");
		verifyElementIsDisplayed(returnRequests,"View Return Requests");
		
		
	}

	private void verifyElementIsDisplayed(WebElement element, String eleInfo) {
		// TODO Auto-generated method stub
		Optional.ofNullable(element).filter(e -> e.isDisplayed() && e.isEnabled()).ifPresentOrElse(
				e -> TestLog.stepInfo(eleInfo +" is enabled or displayed"), () ->{
					throw new AssertionError(eleInfo + " is not visible or enabled.");
				});
		
	}
	
	public Logout logout() {
		click(myAccount);
		click(logout);
		return new Logout(driver);
	}
	
	

}
