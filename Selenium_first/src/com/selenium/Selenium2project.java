package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;

public class Selenium2project {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		
		
		driver.findElement(By.id("inputUsername")).sendKeys("King");
		driver.findElement(By.name("inputPassword")).sendKeys("password");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//Assert.assertEquals(driver.findElement(By.cssSelector("p.error")).getText(), "Incorrect username or password");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Raju");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("raju@cts.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("king@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("12345");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.className("infoMsg")).getText());
		
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("inputUsername")).sendKeys("King");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		driver.findElement(By.className("logout-btn")).click();
		Thread.sleep(1000);
		driver.close();
		
		
		
		

	}

	private static String getPassword(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String full = driver.findElement(By.className("infoMsg")).getText();
		
		String[] pass1 = full.split("'");
		
		String[] pass2 = pass1[1].split("'");
		
		String password = pass2[0];
		
		
		return password;
	}
	
	
	

}
