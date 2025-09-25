package CucumberE2EProject.CucumberProject.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
	}

	private WebElement waitForElement(WebElement element, long durationInSeconds) {
		// TODO Auto-generated method stub
		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return webElement;
	}

	public void typeTestInField(WebElement element, String stringToEnter, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		element.clear();
		element.click();
		element.sendKeys(stringToEnter);
	}

	public String getTextFromElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		return element.getText();

	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}

	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {

		try {
			WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
			return webElement.isDisplayed();
		} catch (Throwable e) {
			return false;
		}

	}

}
