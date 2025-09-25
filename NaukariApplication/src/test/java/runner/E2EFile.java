package test.java.runner;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2EFile {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();

		// Create a map for preferences
		Map<String, Object> prefs = new HashMap<>();
		// Disable image loading (including CSS background images)
		prefs.put("profile.managed_default_content_settings.images", 2);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		options.addArguments("--headless");
		options.addArguments(
				"user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

		// Optional: Run the browser in non-headless mode (visible UI)
		//((Object) options).setHeadless(false);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		//WebDriver driver  = new SafariDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		driver.get("https://www.naukri.com/");

		driver.findElement(By.id("login_Layer")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Username')]")).sendKeys("kothurusurendra98@gmail.com");
		driver.findElement(By.xpath("//input[contains(@placeholder,'password')]")).sendKeys("Surendra@1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(15000);
		//WebElement ele = driver.findElement(By.xpath("//img[@alt='Naukri Logo']"));
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@alt='Naukri Logo']"))));
		//driver.findElement(By.partialLinkText("View")).click();
		driver.findElement(By.xpath("//img[@class='nI-gNb-icon-img']")).click();
		driver.findElement(By.xpath("//*[@class='nI-gNb-info__sub-link']")).click();
		//driver.findElement(By.xpath("//*[@class='chatbot_Nav']/div")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[contains(@class,'quickLink')]//span[contains(text(),'Career')]")).click();
		driver.findElement(By.xpath("//*[@id='lazyDesiredProfile']//span[contains(.,'editOneTheme')]")).click();
		driver.findElement(By.id("locationSugg")).click();
		WebElement loc = driver.findElement(By.xpath("//*[text()='Chennai']"));
		if(loc.isSelected()) {
			loc.click();
		}else {
			loc.click();
		}
		String msg = driver.findElement(By.xpath("//div[@class='mod-date']/span[contains(.,'Today')]")).getText();
		System.out.println("is updated "+msg);

		// driver.findElement(By.id("saveDesiredProfile")).click();

	}

}
