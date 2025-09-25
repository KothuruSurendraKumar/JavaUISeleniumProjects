package DemoSeleniumFramework.PracticeProject.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StandAloneTest {
	
	@Test
	public void runTheApplication() {
		String productName = "ADIDAS ORIGINAL";
		
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		
		driver.findElement(By.id("userEmail")).sendKeys("kumar@don.com");
		driver.findElement(By.id("userPassword")).sendKeys("Kumar@123");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'mb-3')]")));
		List<WebElement> prodItems = driver.findElements(By.xpath("//*[contains(@class,'mb-3')]"));
		
		WebElement prod = prodItems.stream().filter(s -> s.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		prod.findElement(By.xpath(".//div[@class='card-body']//button[2]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
		
		List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
		Boolean isMatch = cartItems.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		
		//System.out.println("cat product : "+prodName);
		Assert.assertTrue(isMatch);
		
		driver.findElement(By.xpath("//li[@class='totalRow']//button")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		//list-group
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'list-group')]")));
		
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//button[contains(@class,'active')]")).click();
		
		driver.findElement(By.xpath("//*[contains(@class,'action__submit')]")).click();
		
		String msg = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		System.out.println(msg);
		AssertJUnit.assertEquals(msg, "THANKYOU FOR THE ORDER.");
		
		String[] orderArr = driver.findElement(By.xpath("//*[@class='em-spacer-1']//label[@class='ng-star-inserted']")).getText().split("\\|");
		String orderId = orderArr[1].trim();
		System.out.println("orderId :"+orderId);
	}
	

}
