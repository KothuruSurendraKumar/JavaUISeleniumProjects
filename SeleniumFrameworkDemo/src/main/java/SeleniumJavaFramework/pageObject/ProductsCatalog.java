package SeleniumJavaFramework.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumJavaFramework.AbstractComponents.AbstractComponent;

public class ProductsCatalog extends AbstractComponent{
	
	WebDriver driver;

	public ProductsCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//	
//	List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(xpath = "//div[contains(@class, 'mb-3')]")
	List<WebElement> items;
	
	//driver.findElement(By.cssSelector(".ng-animating")
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By tostMsg = By.cssSelector("#toast-container");
	
	
	By waitBy = By.xpath("//div[contains(@class, 'mb-3')]");
	
	public List<WebElement> getListItems() {
		waitUntiLocate(waitBy);
		return items;
	}
	
	//WebElement product = items.stream().filter(item -> item.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("qwerty"))
	//.findFirst().orElse(null);
	
	public WebElement getProductByName(String prodName) {
		waitUntiLocate(waitBy);
		WebElement product = getListItems().stream().filter(item -> item.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equals(prodName))
				.findFirst().orElse(null);
		System.out.println(product.getText());
		return product;
	}

	//product.findElement(By.xpath("//div[@class='card-body']//button[2]")).click();
	
	public void addProdToCart(String prodName) throws InterruptedException {
		WebElement prod = getProductByName(prodName);
		Thread.sleep(1000);
		prod.findElement(By.xpath(".//div[@class='card-body']/button[2]")).click();
		waitUntiLocate(tostMsg);
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		waitUntilElementInvisible(spinner);
	}
	
	
	
}
