package UIAutomationProject.UIProject.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UIAutomationProject.UIProject.utils.WaitUtils;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	public String getTitle(WebDriver driver) {
        return driver.getTitle();
    }
	public void click(WebElement element) {
		//some elements are hidden for this we use this
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", element);
		WaitUtils.waitForClickable(driver, element).click();
		
	}
	
	public void clear(WebElement element) {
		WaitUtils.waitForClickable(driver, element).clear();
	}
	
	public void enterText(WebElement element,String text) {
		clear(element);
		element.sendKeys(text);
	}

}
