package UIAutomationProject.UIProject.utils;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	private static final int DEFAULT_TIMEOUT= 50;
	
	
	public static WebElement waitForClickable(WebDriver driver,WebElement element) {
		return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static <T> T waitFor(ExpectedCondition<T> condition,WebDriver driver,int duration) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		return wait.until(condition);
	}
	
	public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }

}
