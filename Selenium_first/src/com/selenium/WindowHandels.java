package com.selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandels {
	WebDriver driver;
	
	@BeforeMethod
	public void invokeBrowser() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void getTextFromChildWindow() {
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		String mainWindow = driver.getWindowHandle();
		System.out.println("Main wind : "+mainWindow);
		driver.findElement(By.xpath("//a[contains(text(),'Click')]")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> win = windows.iterator();
		String child = null;
		while(win.hasNext()) {
			String handle = win.next();
			if(!handle.equals(mainWindow)) {
				child = handle;
			}
		}
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.close();
		driver.switchTo().window(mainWindow);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		
	}

}
