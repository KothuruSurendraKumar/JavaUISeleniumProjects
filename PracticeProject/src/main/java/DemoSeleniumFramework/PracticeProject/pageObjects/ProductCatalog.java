package DemoSeleniumFramework.PracticeProject.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import DemoSeleniumFramework.PracticeProject.abstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent{
	
	WebDriver driver;
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//driver.findElements(By.xpath("//*[contains(@class,'mb-3')]"))
	@FindBy(xpath="//*[contains(@class,'mb-3')]")
	List<WebElement> productItems;
	
	//driver.findElement(By.cssSelector(".ng-animating"))
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By listLocator = By.xpath("//*[contains(@class,'mb-3')]");
	By toster = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getItems() {
		waitUntilLocate(listLocator);
		return productItems;
	}
	
	public WebElement getProductUsingName(String prodName) {
		WebElement prod = productItems.stream().filter(s -> s.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equalsIgnoreCase(prodName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProdToCart(String prodName) {
		WebElement product = getProductUsingName(prodName);
		product.findElement(By.xpath(".//div[@class='card-body']//button[2]")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		waitUntilLocate(toster);
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		waitUntilInvisible(spinner);
		
	}
}
