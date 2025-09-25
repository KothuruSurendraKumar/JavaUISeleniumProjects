package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
/*
 * 1.scroll the window
 * 2.scroll the specific table or document present in window
 * achive using java script executors
 * */

public class ScrollDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//configre the javascript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//scroll the at window level
		//to go end of page
		while(true) {
		js.executeScript("window.scrollBy(0,500)");
		
		long height = (long) js.executeScript("return document.body.scrollHeight");
		long clientHeight = (long) js.executeScript("return window.innerHeight + window.scrollY");
		
		System.out.println("height"+height);
		System.out.println("clinet height"+clientHeight);
		
		if(clientHeight >= height) {
			break;
		}
		}
		//need to scroll specific element in window - achive using DOM elements
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		
		
		//get the all integers from table and count and print total
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		
		int a= 0;
		for(int i=0;i<elements.size();i++) {
			System.out.println(Integer.parseInt(elements.get(i).getText()));
			a = a + Integer.parseInt(elements.get(i).getText());
		}
		System.out.println("total "+a);
		String totalString = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		System.out.println("value "+totalString);
		Assert.assertEquals(a, Integer.parseInt(totalString));
		
		//calculate total for second table
		
		List<WebElement> values = driver.findElements(By.xpath("//table[@class='table-display']//tr//td[3]"));
		int sum = 0;
		for(int i=0;i<values.size();i++) {
			sum = sum + Integer.parseInt(values.get(i).getText());
			
		}
		System.out.println("sum "+sum);
		
	}

}
