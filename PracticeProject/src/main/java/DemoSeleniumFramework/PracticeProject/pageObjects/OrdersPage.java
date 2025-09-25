package DemoSeleniumFramework.PracticeProject.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoSeleniumFramework.PracticeProject.abstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent{
	
	WebDriver driver;
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	////tbody//tr[@class='ng-star-inserted']//td[2]
	@FindBy(xpath="//tbody//tr[@class='ng-star-inserted']//td[2]")
	List<WebElement> orderList;
	
	public List<WebElement> getOrderItems() {
		return orderList;
	}
	
	public Boolean prodMatches(String prodName) {
		Boolean isMatch = orderList.stream().anyMatch(s -> s.getText().equalsIgnoreCase(prodName));
		return isMatch;
	}

}
