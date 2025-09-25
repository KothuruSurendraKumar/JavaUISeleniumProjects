package com.selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Nested Frames")).click();
		
		int size = driver.findElements(By.tagName("frame")).size();
		//System.out.println("size "+size);
		driver.switchTo().frame(0);
		int size2 = driver.findElements(By.tagName("frame")).size();
		//System.out.println("size "+size2);
		
		driver.switchTo().frame(1);
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
		
		
		
		
		

	}

}
