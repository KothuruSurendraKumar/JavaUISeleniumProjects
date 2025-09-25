package com;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieDemoExampleAdd {
	
	WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		driver = new ChromeDriver();
	}
	
	@Test
	public void addCookie() {
		driver.get("https://www.google.com/");
		Cookie cookie = new Cookie("userOne","John");
		driver.manage().addCookie(cookie);
	}
	
	
	@Test(dependsOnMethods = { "addCookie" })
	public void getCookieByName() {
		driver.get("https://www.google.com/");
		Cookie cookie = driver.manage().getCookieNamed("userOne");
		if(cookie != null) {
			System.out.println("Name: "+cookie.getName()+" "+"Value :"+cookie.getValue());
		}
		else {
			System.out.println("Cookie Not Found");
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
