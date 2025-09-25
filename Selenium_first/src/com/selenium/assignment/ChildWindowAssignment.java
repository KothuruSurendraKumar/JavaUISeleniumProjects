package com.selenium.assignment;

import java.util.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindowAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> ids = windows.iterator();
		
		String parentId = ids.next();
		String childId = ids.next();
		
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.tagName("h3")).getText());


	}

}
