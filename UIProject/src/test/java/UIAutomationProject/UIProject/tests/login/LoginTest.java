package UIAutomationProject.UIProject.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import UIAutomationProject.UIProject.base.BaseTest;
import UIAutomationProject.UIProject.exceptions.PageLoadException;
import UIAutomationProject.UIProject.factory.Constant;
import UIAutomationProject.UIProject.pages.Account;
import UIAutomationProject.UIProject.pages.HomePage;
import UIAutomationProject.UIProject.pages.Login;
import UIAutomationProject.UIProject.reporting.TestLog;
import io.opentelemetry.api.logs.Logger;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import lombok.SneakyThrows;
import static io.qameta.allure.SeverityLevel.BLOCKER;

public class LoginTest extends BaseTest{
	
	private Login loginPage;
	private Account accountPage;
	
	@Test
	@SneakyThrows
	@Severity(BLOCKER)
	@Description("Verify UI page is Running")
	public void openHomePage() throws PageLoadException {
		HomePage homePage = launchHomePage();
		assertPageTitle(homePage.getTitle(getDriver()),Constant.HOME_PAGE_TITLE,"Home Page");
		TestLog.testPass("Verify UI Page is Running Test Case Passed");
	}
	
	@Test
	@SneakyThrows
	@Severity(BLOCKER)
	@Description("Verify User is Successfully Logged in")
	public void verifyLoginWithExcistingUser() throws PageLoadException {
		HomePage homePage = launchHomePage();
		loginPage = homePage.navigateToLoginPage();
		assertPageTitle(loginPage.getTitle(getDriver()),Constant.LOGIN_PAGE_TITLE,"Login Page");
		accountPage = loginPage.loginAsExsistingUser(Constant.EMAIL_ADDRESS, Constant.PASSWORD);
		TestLog.stepInfo("Title of account page is "+accountPage.getTitle(getDriver()));
		TestLog.testPass("Verified Login User.Test Passed");
	}
	
	@Test
	@SneakyThrows
	@Severity(BLOCKER)
	@Description("Verify User is with invalid username and password")
	public void verifyLoginWithInvalidUser() throws PageLoadException {
		HomePage homePage = launchHomePage();
		loginPage = homePage.navigateToLoginPage();
		assertPageTitle(loginPage.getTitle(getDriver()),Constant.LOGIN_PAGE_TITLE,"Login Page");
		accountPage = loginPage.loginAsExsistingUser("test123","test123");
		Assert.assertEquals(loginPage.invalidUser(), "Warning: No match for E-Mail Address and/or Password.");
		TestLog.stepInfo("Invalid Login is verified");
		TestLog.testPass("Invalid Login is verified, Test Pass");
	}
	
	

}
