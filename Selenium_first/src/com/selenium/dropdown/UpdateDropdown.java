package com.selenium.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//consider you have dropdown and that contains - & + which increases and decreases.
				//automate the case
				
				driver.findElement(By.id("divpaxinfo")).click();
				Thread.sleep(2000);
				//add count of 5
				
				System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
				
				for(int i=0;i < 3;i++) {
					driver.findElement(By.id("hrefIncAdt")).click(); //it will increase count by 1
				}
				
				for(int i=0;i <= 2;i++ ) {
					driver.findElement(By.id("hrefIncChd")).click();
				}
				
				for(int i=0;i <= 2 ;i++) {
					driver.findElement(By.id("hrefIncInf")).click();
				}
				
				driver.findElement(By.id("btnclosepaxoption")).click();
				
				System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
