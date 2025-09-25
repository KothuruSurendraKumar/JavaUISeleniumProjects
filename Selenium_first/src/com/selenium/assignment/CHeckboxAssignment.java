package com.selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/*
 * 1.check the first checkbox and verify it's succesfully check or not
 * 2.uncheck the checkbox and verify successfullt ucheckd or not
 * 3.print no.of checkboxes in page
 * 
 */


public class CHeckboxAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//check the checkbox and verify
		System.out.println(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());
		driver.findElement(By.cssSelector("input[value='option1']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());
		
		
		//uncheck the checkbox and verify
		driver.findElement(By.cssSelector("input[value='option1']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());
		
		//get count of the check box
		
		
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 3);
		
	}

}
