package com.selenium.ajax;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DragDropActionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		//we need now from main windows using link present in parent window we need to go to second window and get text and paste in first window
		//As we open multiple windows selenium will be in 1st window
		//we need to say go to second window.For that 1st get id's of windows which are open
		
		Set<String> ids = driver.getWindowHandles();
		//let us consider it gives[parentid,childid] we need to switch to child id
		Iterator<String> it = ids.iterator();
//		while(it.hasNext()) {
//			String v = it.next();
//			System.out.println(v);
//		}
		
		String parentId = it.next();
		String childId = it.next();
		
		//switch to child window
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(email);
		
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);
		
	}

}
