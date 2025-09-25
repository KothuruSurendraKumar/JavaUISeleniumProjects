package com.selenium.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value='RoundTrip']")).isSelected());
		
		System.out.println(driver.findElement(By.cssSelector("input[value='RoundTrip']")).isSelected());
		
		driver.findElement(By.cssSelector("input[value='RoundTrip']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='RoundTrip']")).isSelected());
		
		System.out.println(driver.findElement(By.cssSelector("input[value='RoundTrip']")).isSelected());
		
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		
		//to get count of no of checkboxes present in page
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
		
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
