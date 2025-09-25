package CucumberE2EProject.CucumberProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CucumberE2EProject.CucumberProject.utils.CommonUtils;
import CucumberE2EProject.CucumberProject.utils.ElementUtils;

public class AccountPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformationOption;

	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement searchButton;

	@FindBy(name = "search")
	private WebElement searchBoxField;

	public boolean displayStatusOfEditYourAccountInformationOption() {

		return elementUtils.displayStatusOfElement(editYourAccountInformationOption,
				CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickIntoSearchBox() {

		elementUtils.clickOnElement(searchBoxField, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterProductIntoSearchBox(String productText) {

		elementUtils.typeTestInField(searchBoxField, productText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public SearchPage clickSearchButton() {
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchPage(driver);
	}

}
