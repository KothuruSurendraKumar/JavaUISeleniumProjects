package SeleniumJavaFramework.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumJavaFramework.pageObject.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productName = "qwerty";
		
		//usually we set the chrome driver path and we will use.with webdriver manager it became simple without downloading any drivers
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("kumar@don.com");
		driver.findElement(By.id("userPassword")).sendKeys("Kumar@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
//	    WebElement product = items.stream().filter(item -> item.findElement(By.cssSelector("b")).getText().equals(productName))
//				.findFirst().orElse(null);
//	   
//			product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//			
			
		//with xpath
		
//		List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class,'col-lg-4')]"));
//		items.stream().map(s -> s.findElement(By.xpath("//b"))).map(s -> s.getText()).forEach(System.out::println);
//		WebElement product = items.stream().filter(item -> item.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equals("ADIDAS ORIGINAL"))
//				.findFirst().orElse(null);	
//		product.findElement(By.xpath(".//div[@class='card-body']/button[2]")).click();
		
		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class, 'mb-3')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

	    WebElement prod = products.stream().filter(product->

	product.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);

	prod.findElement(By.xpath(".//div[@class='card-body']/button[2]")).click();
		
		//after product is added wait until "product is added" text is displayed and wait until load is completed
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating - locator for loading icon
		//it taking too much time
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		//so use this
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//cssselector
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
		
		List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
		
		Boolean isMatch = cartItems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(isMatch);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'list-group')]")));
		driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys(Keys.DOWN);
		
		driver.findElement(By.xpath("//button[contains(@class,'active')]")).click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		
		String msg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(msg);
		
		Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText().trim(),  "THANKYOU FOR THE ORDER." );
		
		String orderId = driver.findElement(By.xpath("//*[@class='em-spacer-1']//label[@class='ng-star-inserted']")).getText();
		String[] orderArr = orderId.split("\\|");
		String result = orderArr[1].trim();
		System.out.println(result);

	}

}
