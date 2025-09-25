package CucumberE2EProject.CucumberProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CucumberE2EProject.CucumberProject.utils.CommonUtils;
import CucumberE2EProject.CucumberProject.utils.ElementUtils;

public class SearchPage {
	WebDriver driver;
	private ElementUtils utils;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		utils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement messageText;
	
	public boolean displayStatusOfValidProduct() {
		
		return utils.displayStatusOfElement(validProduct,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getMessageText() {
		
		return utils.getTextFromElement(messageText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}

}
