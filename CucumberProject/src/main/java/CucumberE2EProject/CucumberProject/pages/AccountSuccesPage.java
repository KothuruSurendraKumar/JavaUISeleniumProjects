package CucumberE2EProject.CucumberProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CucumberE2EProject.CucumberProject.utils.CommonUtils;
import CucumberE2EProject.CucumberProject.utils.ElementUtils;

public class AccountSuccesPage {
	
	WebDriver driver;
	private ElementUtils utils;
	
	public AccountSuccesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver,this);
		utils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//*[@id='content']//h1")
	WebElement succes_msg;
	
	public String getSuccessMessage() {
		return utils.getTextFromElement(succes_msg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
