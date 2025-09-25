package com.selenium.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");	
		
		//Normally to find certain elements we dont have specific selectors to find the element.Inselenium 4.0 this featurs are introduced
		//Here we need to extract text <lablel>Name</label> we need to extract Name text .But we have only tag name
		//1.we can get by traversing using x-path
		//2.using advance selenium features
		//selenium 4.0 supports only tag name
		
		WebElement nameBox = driver.findElement(By.xpath("//input[@name='name']"));
		
		//above
		String text = driver.findElement(with(By.tagName("label")).above(nameBox)).getText();
		System.out.println("text "+text);
		
		
		//below
		
		WebElement element = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		
		//flex will not supported by selenium 4.0 features
		driver.findElement(with(By.tagName("input")).below(element)).click();
		
		//left
		
		WebElement checkBox = driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBox)).click();
		
		//right
		
		WebElement rightExample = driver.findElement(By.cssSelector("[for='exampleFormControlRadio1']"));
		
		driver.findElement(with(By.tagName("input")).toRightOf(rightExample)).click();
	}
	
	

}
