package DemoSeleniumFramework.PracticeProject.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DemoSeleniumFramework.PracticeProject.pageObjects.CartPage;
import DemoSeleniumFramework.PracticeProject.pageObjects.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
	@FindBy(xpath="//button[contains(@routerlink,'cart')]")
	WebElement cart;
	
	@FindBy(xpath="//button[contains(@routerlink,'myorders')]")
	WebElement orders;
	
	public void waitUntilLocate(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitUntiLocateWebElement(WebElement byLocator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(byLocator));
	}
	
	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	public void waitUntilInvisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public CartPage goToCart() {
		cart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrdersPage goToOrders() {
		orders.click();
		OrdersPage orderPage = new OrdersPage(driver);
		return orderPage;
	}
	
	

}
