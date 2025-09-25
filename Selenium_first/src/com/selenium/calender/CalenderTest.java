package com.selenium.calender;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//need to select the date according to input given
//after setting up date need to assert with date seeted

public class CalenderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String year = "2027";
		String month = "6";
		String day = "11";
		
		String[] arr = {month,day,year};
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.xpath("//button[text() ='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		//driver.findElements(By.xpath("//button[@class='react-calendar__year-view__months__month']")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		
		List<WebElement> actualList=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0;i<actualList.size();i++) {
			//get the all value(month,year,date)
			actualList.get(i).getAttribute("value");
			System.out.println(actualList.get(i).getAttribute("value"));
			//asserting the value which we seeted in web page
			Assert.assertEquals(actualList.get(i).getAttribute("value"), arr[i]);
		}
		
		
		

	}

}
