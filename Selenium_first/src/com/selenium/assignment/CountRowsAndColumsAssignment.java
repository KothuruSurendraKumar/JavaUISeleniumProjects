package com.selenium.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountRowsAndColumsAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> listRows = driver.findElements(By.xpath("//table[@class='table-display']//tr"));
		System.out.println("Total rows "+listRows.size());
		List<WebElement> listColumns = driver.findElements(By.xpath("//table[@class='table-display']//th"));
		System.out.println("Total columns "+listColumns.size());
		List<WebElement> content = driver.findElements(By.xpath("//table[@class='table-display']//tr[3]//td"));
		for(int i=0;i<content.size();i++) {
			
			System.out.println(content.get(i).getText());
		}

	}

}
