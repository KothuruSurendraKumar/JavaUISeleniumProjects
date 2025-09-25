package UIAutomationProject.UIProject.tests.account;

import org.testng.Assert;
import org.testng.annotations.Test;

import UIAutomationProject.UIProject.base.BaseTest;
import UIAutomationProject.UIProject.exceptions.PageLoadException;
import UIAutomationProject.UIProject.factory.Constant;
import UIAutomationProject.UIProject.pages.Account;
import UIAutomationProject.UIProject.pages.HomePage;
import UIAutomationProject.UIProject.pages.Login;
import UIAutomationProject.UIProject.pages.Register;
import UIAutomationProject.UIProject.reporting.TestLog;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.SneakyThrows;

public class RegisterFlowTest extends BaseTest{
	
	HomePage homePage;
	
	//@Test
	//Indicated crital functionality
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify if new regestration is happening or not")
	public void registeruser() throws PageLoadException {
		Register register = goToRegisterUserPage();
		Account.Success myAccountSucces = register.registerUser("JhonWick", "AbrahamSam", "jhonawick@abraham.com","4415923452579", "Jhonwick@1235", "Jhonwick@1235");
		assertPageTitle(myAccountSucces.getTitle(getDriver()),Constant.ACCOUNT_PAGE_SUCCESS_TITLE,"Account Succes Page");
		myAccountSucces.verifyAccountSuccessPageElements();
		TestLog.stepInfo("User is Successfully Registered for Account");
		Account account = myAccountSucces.navigateToAccountPage();
		account.verifyAccountPageElements();
		TestLog.stepInfo("My Account Page Elements Are Displayed and Enabled.");
		Account.Logout logoutPage = account.logout();
		verifyLogoutPageElements(logoutPage);
		TestLog.stepInfo("User Succesfully Logged out");
		homePage = logoutPage.navigateToHomepage();
		assertPageTitle(homePage.getTitle(getDriver()),Constant.HOME_PAGE_TITLE,"Home Page");
		TestLog.stepInfo("User Succesfully Logged out and now on Home Page");
	}
	@SneakyThrows
	//@Test
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify if new regestration is happening or not")
	public void loginWithExcistingUser() throws PageLoadException {
		Register register = goToRegisterUserPage();
		register.registerUser("JhonWick", "AbrahamSam", "jhonawick@abraham.com","4415923452579", "Jhonwick@1235", "Jhonwick@1235");
		Assert.assertTrue(register.isWarningMessageIsDisplayed(),"Warning Message is Not Displayed");
		Login login = homePage.navigateToLoginPage();
		assertPageTitle(login.getTitle(getDriver()),Constant.LOGIN_PAGE_TITLE,"Login Page");
		TestLog.stepInfo("User at Login Page");
		Account account = login.loginAsExsistingUser("jhonawick@abraham.com", "Jhonwick@1235");
		assertPageTitle(login.getTitle(getDriver()), Constant.ACCOUNT_PAGE_TITLE, "Account Page");
        TestLog.stepInfo("Create Registration For Existing User Test Case Passed");
		
	}
	@Test
	@SneakyThrows
	@Description("Register the user with user already registered")
	public void registerUserWithAlreadyRegisteredUser() throws PageLoadException {
		Register register = goToRegisterUserPage();
		register.registerUser("", "j", "jhonawick@abraham.com", "","","");
		Assert.assertTrue(register.isEmailRegWarningMsgIsPresent(), "Warning: E-Mail Address is already registered!");
		assertPageTitle(register.getTitle(getDriver()),Constant.REGISTER_PAGE_TITLE,"Register Page");
	}

}
