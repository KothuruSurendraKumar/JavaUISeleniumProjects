package com.selenium.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//dynamic dropdown
		//it is nothing but it will update dynamically
		//In our sheet we are automating departure city and arrival city.Here arrival city will apper only after selecting depature city
		
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//		
//		driver.findElement(By.xpath("//a[@value='BLR']")).click();
//		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		//some projs there is no support for indexing
		//we can follow parent-cj=hild relationship
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		
	}

}
