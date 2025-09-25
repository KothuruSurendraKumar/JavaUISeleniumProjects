package com.getCookieFromFile;

import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;

public class CookieFromFile {
	
	
	WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
		driver = new ChromeDriver(options);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void loadValuesFromFile() throws IOException {
		driver.get("https://www.google.com/");
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"//cookie.txt"));
		String line;
		while((line=reader.readLine()) != null) {
			String[] arr = line.split("=");
			Cookie cookie = new Cookie(arr[0],arr[1]);
			driver.manage().addCookie(cookie);
		}
	}
	
	@Test(dependsOnMethods = { "loadValuesFromFile" })
	public void getCookies() {
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie : cookies) {
			System.out.println("Name: "+cookie.getName()+" "+"Value :"+cookie.getValue());
		}
	}

}
