package com.selenium.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='AIP']")).click();
		Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']")).click();
        //it will select current date
        
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        //driver.findElement(By.className("ui-state-active")).click();
        
        
        //check the option is disabled or enabled
        //if we try like this we get true even it is disabled
        
        
        /*System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
        
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        
        System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());*/
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        
        
        
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
        	Assert.assertTrue(true);
        	System.out.println("It's enabled");
        }else {
        	Assert.assertTrue(false);
        }
        
	}

}
