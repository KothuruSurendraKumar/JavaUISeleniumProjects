package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyPasteExampleUsingSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");	
		driver.findElement(By.id("name")).sendKeys("Suri");
		WebElement element = driver.findElement(By.id("name"));
		Actions action = new Actions(driver);
		action.click(element).keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.UP).perform();
		action.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.UP).perform();
		WebElement ele = driver.findElement(By.id("email"));
		action.click(ele).keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.UP).perform();
		

	}

}
