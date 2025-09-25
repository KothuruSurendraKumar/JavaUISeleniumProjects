package com.selenium.ajax;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =   new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		//Declare Action class
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
		
		//we need enter keys in capital letters
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hellO").build().perform();
		
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		//after entering the text need to select the text
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().sendKeys("watch").doubleClick().build().perform();
		
		action.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).contextClick().build().perform();
		
		
		driver.quit();

	}

}
