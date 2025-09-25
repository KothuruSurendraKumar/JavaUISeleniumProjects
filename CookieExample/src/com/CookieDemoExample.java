package com;

import org.testng.annotations.Test;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieDemoExample {
	
	@Test
	public void addCookie() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Cookie cookie = new Cookie("user","John");
		driver.manage().addCookie(cookie);
		driver.quit();
	}
	@Test
	public void getCookies() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie : cookies) {
			System.out.println("Name: "+cookie.getName()+" "+"Value :"+cookie.getValue());
		}
		driver.quit();
		
	}
	
	@Test
	public void getCookieByName() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Cookie cookie = driver.manage().getCookieNamed("user");
		if(cookie != null) {
			System.out.println("Name: "+cookie.getName()+" "+"Value :"+cookie.getValue());
		}
		else {
			System.out.println("Cookie Not Found");
		}
		driver.quit();
	}

}
