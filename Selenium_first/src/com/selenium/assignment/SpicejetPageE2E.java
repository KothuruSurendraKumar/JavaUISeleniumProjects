package com.selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class SpicejetPageE2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		//selected round trip
		driver.findElement(By.cssSelector("div[data-testid='round-trip-radio-button']")).click();	
		//driver.findElement(By.cssSelector(".css-1cwyjr8.r-homxoj.r-ubezar.r-10paoce.r-13qz1uu")).click();
		//driver.findElement(By.cssSelector(".css-76zvg2.r-cqee49.r-ubezar.r-1ozqkpa")).click();
		
		//select from tab div[data-testid='to-testID-origin']
		driver.findElement(By.cssSelector("div[data-testid='to-testID-origin']")).click();
		
		//select from as viz
		
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-ov7bg r-z2wwpe r-utggzx r-atwnbb r-cfp7ip'])[81]")).click();
		
		//driver.findElement(By.cssSelector("div[data-testid='to-testID-destination']")).click();
		Thread.sleep(2000);
		//After selecting select it open to automatically 
		//In to we are selection International
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-11u4nky r-1ljd8xs r-1phboty r-1x0uki6']/*[2]")).click();
		//select one of the city
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3']/*[2]")).click();
		
		
		//slected one date (//div[@class='css-1dbjc4n r-6koalj r-18u37iz r-d0pm55'])[1]/div[6]
		////div[@data-testid='undefined-month-September-2024']/*[3]/*[2]/div[@data-testid='undefined-calendar-day-4']
		
		
		//select one date from depature date and another return date
		//we can select 2 ways I have written both the ways
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-October-2024']/div[3]/div[2]/div[4]")).click();
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-November-2024']/div[3]/div[2]/div[@data-testid='undefined-calendar-day-4']")).click();
		
		Thread.sleep(2000);
		
		//select no of passengers it is a dropdown.1st we need to open the dropdown 
		
		driver.findElement(By.cssSelector("div[data-testid='home-page-travellers']")).click();
		
		for(int i=1;i <= 3;i++) {
			driver.findElement(By.cssSelector("div[data-testid='Adult-testID-plus-one-cta']")).click();
			
		}
		
		for(int i=1;i < 3;i++) {
			driver.findElement(By.cssSelector("div[data-testid='Children-testID-plus-one-cta']")).click();
			
		}
		
		for(int i=1;i < 2;i++) {
			driver.findElement(By.cssSelector("div[data-testid='Infant-testID-plus-one-cta']")).click();
			
		}
		
		//after selecting we need to print the text
		
		System.out.println(driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']/div[2]")).getText());
		
		Thread.sleep(1000);
		
		//it should work only elements with slect tag
		
//		WebElement dropdown = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-pm2fo r-11u4nky r-z2wwpe r-1phboty r-ou6ah9 r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']"));
//		
//		Select currency = new Select(dropdown);
//		
//		currency.selectByVisibleText("EUR");
		driver.findElement(By.xpath("//div[@style='flex: 0.3 1 0%; margin-left: 10px;']")).click();
		
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-h3f8nf r-u8s1d r-8fdsdq']/div/div/div[4]")).click();
		
		//select check box
		
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-m611by']/div/div/div[1]")).click();
		
		
		//click search flight
		
		driver.findElement(By.cssSelector("div[data-testid='home-page-flight-cta']")).click();
		
		
		
	}

}
