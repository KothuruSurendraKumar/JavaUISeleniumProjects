package com.selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//*[@placeholder='Type to Select Countries']")).sendKeys("ind");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@placeholder='Type to Select Countries']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//*[@placeholder='Type to Select Countries']")).sendKeys(Keys.DOWN);
		System.out.println(driver.findElement(By.xpath("//*[@placeholder='Type to Select Countries']")).getAttribute("value"));

	}

}
