package UIAutomationProject.UIProject.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.util.concurrent.Uninterruptibles;

import UIAutomationProject.UIProject.exceptions.PageLoadException;
import UIAutomationProject.UIProject.factory.Constant;
import UIAutomationProject.UIProject.factory.DriverFactory;
import UIAutomationProject.UIProject.pages.Account;
import UIAutomationProject.UIProject.pages.HomePage;
import UIAutomationProject.UIProject.pages.Register;
import UIAutomationProject.UIProject.reporting.TestLog;
import UIAutomationProject.UIProject.utils.ScreenshotUtils;

public class BaseTest {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@BeforeMethod
	public void setUpDriver() {
		driver.set(DriverFactory.getDriver("chrome"));
		TestLog.stepInfo("Chrome Driver Set Up Completed");
	}

	@AfterMethod
	public void quitDriver(ITestResult result) {
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtils.captureScreenshot(getDriver(), result.getName());
		}
		getDriver().quit();
		driver.remove();  
		TestLog.stepInfo("Driver quited");
	}
	
	protected WebDriver getDriver() {
		return driver.get();
	}
	
	protected void assertPageTitle(String actualTitle,String expectedTitle,String pageName) {
		// TODO Auto-generated method stub
		Assert.assertEquals(actualTitle, expectedTitle,pageName+"Title Miasmatch");
		TestLog.stepInfo("Title of the " + pageName + " is: " + actualTitle);
		
	}

	public HomePage launchHomePage() throws PageLoadException {
		try {
			HomePage homePage = new HomePage(getDriver());
			homePage.goTo();
			TestLog.stepInfo("Home Page Opened Successfully");
			return homePage;
		} catch (Exception e) {
			String errorMsg = "Failed to load Home Page: " + e.getMessage();
			TestLog.stepInfo(errorMsg);
			throw new PageLoadException(errorMsg, e);
		}
	}
	
	public HomePage goToHomepage() throws PageLoadException {
		HomePage homePage = launchHomePage();
		assertPageTitle(homePage.getTitle(getDriver()),Constant.HOME_PAGE_TITLE,"Home Page");
		TestLog.stepInfo("User Is Logged In Successfully And on HomePage");
		return homePage;
	}

	
	
	public Register goToRegisterUserPage() throws PageLoadException {
		HomePage homePage = goToHomepage();
		Register registerPage = homePage.goToRegisterPage();
		assertPageTitle(registerPage.getTitle(getDriver()),Constant.REGISTER_PAGE_TITLE,"register page");
		TestLog.stepInfo("Registration Page Opened");
        return new Register(getDriver());
	}

	public void verifyLogoutPageElements(Account.Logout logout) {
		Assert.assertTrue(logout.isAccountLogoffMesgIsDisplayed(),"Account Log Out Field is not Displayed");
		Assert.assertTrue(logout.isLogoffMsgIsDisplayed(),"Log Off message is not displayed");
		Assert.assertTrue(logout.isLogoutMsgIsDisplayed(),"Logout message is not displayed");
		Assert.assertTrue(logout.isContinueButtonIsEnabled(),"Continue Button is not Enabled to click");
		assertPageTitle(logout.getTitle(getDriver()),Constant.LOGOUT_PAGE_TITLE,"Logout Page");
	}
}
