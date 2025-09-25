package SeleniumJavaFramework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumJavaFramework.pageObject.CartPage;
import SeleniumJavaFramework.pageObject.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	////driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
	@FindBy(xpath="//button[contains(@routerlink,'cart')]")
	WebElement clickCart;
	
	@FindBy(xpath="//button[contains(@routerlink,'myorders')]")
	WebElement clickOrders;


	public void waitUntiLocate(By byLocator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	public void waitUntiLocateWebElement(WebElement byLocator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(byLocator));
	}
	
	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	
	public void waitUntilElementInvisible(WebElement element) throws InterruptedException {
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public CartPage goToCart() {
		clickCart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
		
	}
	
	public OrdersPage goToOrders() {
		clickOrders.click();
		OrdersPage orderPage = new OrdersPage(driver);
		return orderPage;
		
	}

}
