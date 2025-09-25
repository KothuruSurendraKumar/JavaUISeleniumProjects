package com.selenium.streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


//In web page we have search box based on that get the results 
//For example when you enter product name it name conatains in filter list print the product

public class FilterElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//send keys to search box
		driver.findElement(By.id("search-field")).sendKeys("Ch");
		
		
		//1st get the all elements after string enetered in search box
		List<WebElement> productList = driver.findElements(By.xpath("//tr/td[1]"));
		
		productList.stream().map(s -> s.getText()).forEach(System.out::println);
		
		List<WebElement> filterList = productList.stream().filter(s -> s.getText().contains("Ch")).collect(Collectors.toList());
		
		filterList.stream().map(s -> s.getText()).forEach(System.out::println);
		//as product list and filterlist both are same size if size is different then filter is not happened correctly
		
		Assert.assertEquals(productList.size(), filterList.size());
		

	}

}
