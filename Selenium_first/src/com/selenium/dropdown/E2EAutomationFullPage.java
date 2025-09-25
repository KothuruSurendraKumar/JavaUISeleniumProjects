package com.selenium.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2EAutomationFullPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[value='RoundTrip']")).click();
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='GOI']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='ATQ']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		driver.findElement(By.cssSelector("input[value='OneWay']")).click();
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			Assert.assertTrue(true);
			System.out.println("it's enabled");
		}else {
			System.out.println("It's Disabled");
			Assert.assertFalse(false);
		}
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		for(int i=1;i<=2;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		for(int i=1;i<=2 ;i++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}
		
		WebElement type = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select element = new Select(type);
		
		element.selectByVisibleText("AED");
		
		driver.findElement(By.id("ctl00_mainContent_IndArm")).click();
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
