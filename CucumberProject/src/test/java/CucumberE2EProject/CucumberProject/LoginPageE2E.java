package CucumberE2EProject.CucumberProject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageE2E {
	
	//@Test
	public void register() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//*[text()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("King");
		driver.findElement(By.id("input-lastname")).sendKeys("Kohili");
		driver.findElement(By.id("input-email")).sendKeys("king.kohil@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("12345677");
		driver.findElement(By.id("input-password")).sendKeys("King@123");
		driver.findElement(By.id("input-confirm")).sendKeys("King@123");
		driver.findElement(By.xpath("//*[@type='checkbox']")).click();
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		
	}
	@Test
	public void login() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/");
		WebElement ele = driver.findElement(By.xpath("//a[@title='My Account']"));
		String ff = ele.getCssValue("font-family");
		String fs = ele.getCssValue("font-size");
		String co = ele.getCssValue("color");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		System.out.println(ff + " "+fs + " "+co );
//		driver.findElement(By.xpath("//a[@title='My Account']")).click();
//		
//		
//		driver.findElement(By.xpath("//*[text()='Login']")).click();
//		driver.findElement(By.id("input-email")).sendKeys("king.kohil@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("King@123");
//		driver.findElement(By.xpath("//*[@value='Login']")).click();
		
	}

}
