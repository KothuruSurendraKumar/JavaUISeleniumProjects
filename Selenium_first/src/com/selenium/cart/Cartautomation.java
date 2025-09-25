package com.selenium.cart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Cartautomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//adding implicit timedout
		//implicit wait with 5 seconds
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//explicit wait with 5 seconds
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		// if we need to add more products in cart we can't write more for loops
		// For this create array and add all the products and iterate the array with
		// products list and add the all elements in cart
		// create array
		String[] productsNeeded = { "Cucumber", "Potato", "Banana" };
		addItems(driver, productsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!");
		
	}

	public static void addItems(WebDriver driver, String[] productsNeeded) {
		int j = 0;

		// first get specific product that need to add in cart
		// for that get all products in list and loop over the list find the product you
		// need

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		// this loop will get all the products in the page
//		for (WebElement e : products) {
//			System.out.println(e.getText());
//		}

		// now get the specific product you need

		for (int i = 0; i < products.size(); i++) {
			String product = products.get(i).getText();
			System.out.println("prod "+product);

			// here we get text as Water Melon - 1 Kg like this with 1kg we need get only
			// product name

			String[] splitedProduct = product.split("-");
			// after spliting we get Water Melon in 0th index 1 Kg in 1st index
			String formattedProduct = splitedProduct[0].trim();
			//System.out.println("formatted " + formattedProduct);

			// iterate the array best way is convert into list and iterate the list
			// why list means in list we have built in methods contain it is easy to iterate
			List productsNeededList = Arrays.asList(productsNeeded);

			if (productsNeededList.contains(formattedProduct)) {
				// get specific product and click add to cart button
				j++;
				// Here we are using text.Here text is dynamic it's changes it will select wrong
				// products
				// so don't depends on texts
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == productsNeeded.length + 1) {
					break;
				}
			}
		}

	}

}
