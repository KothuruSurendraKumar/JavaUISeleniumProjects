package com.selenium.cart;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class FluentWaitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");	
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='start'] button")));
		
		//using webdriver explicit wait
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='finish'] h4")));
		System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());
		driver.navigate().back();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Example 1: Element on page that is hidden")));
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='start'] button")));
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		
		//using fluent explicit wait
		//in fluent wait we dont have any methods so we created some custome methods to achive
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		WebElement ele = wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("div[id='finish'] h4"));
				}else {
					return null;
				}
			}
		});
        System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());
				
	}

}
