package com.selenium.assignment;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncronizationAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String[] itemsNeeded = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		// driver.findElement(By.id("usertype")).click();
		driver.findElement(By.xpath("(//label[@class='customradio']/span[@class='radiotextsty'])[2]")).click();

		// System.out.println(driver.switchTo().alert().getText());
		// driver.switchTo().alert().accept();
		// Thread.sleep(5000);
		w.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement element = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropdown = new Select(element);

		dropdown.selectByVisibleText("Consultant");

		driver.findElement(By.id("terms")).click();

		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("app-card")));

		addItems(driver, itemsNeeded);
		//driver.findElement(By.xpath("//div[@class='navbar-collapse collapse show']/ul[@class='navbar-nav ml-auto']/li[@class='nav-item active']")).click();
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

	}

	private static void addItems(WebDriver driver, String[] itemsNeeded) {
		// TODO Auto-generated method stub
		List<WebElement> items = driver.findElements(By.tagName("app-card"));
		int j = 0;
		for (WebElement e : items) {
			System.out.println(e.getText());
		}

		for (int i = 0; i < items.size(); i++) {
			String product = items.get(i).getText();
			String[] splitedProduct = product.split("\n");
			String finalProduct = splitedProduct[0].trim();

			System.out.println("final " + finalProduct);
			List productsList = Arrays.asList(itemsNeeded);

			if (productsList.contains(finalProduct)) {
				j++;
				driver.findElements(By.xpath("//button[contains(text(),'Add')]")).get(i).click();
			}
			if (j == itemsNeeded.length + 1) {
				break;
			}

		}

	}
}
