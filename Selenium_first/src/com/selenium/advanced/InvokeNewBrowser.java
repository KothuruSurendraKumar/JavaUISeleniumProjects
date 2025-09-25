package com.selenium.advanced;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

/*
 * There is an requirement that we need to get data from another window or tab
 * Means with one driver we need to open another tab or window and get the data and paste in main window
 * this can achived by selenium 4.0 version
 * 
 * Task:
 * open one browser : https://rahulshettyacademy.com/angularpractice/ 
 * in this there is name field.in that name field paste the 1st course name present in this link
 * https://rahulshettyacademy.com/
 */

public class InvokeNewBrowser {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");	
		driver.manage().window().maximize();
		//invoke new tab or window
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		//it will open blank tab.But our selenium still points to main window only
		//now switch to child window and open another url
		//get the ids of windows opened and switch to specific tab
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		Thread.sleep(2000);
		//get the 1st course name
		String text = driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")).get(1).getText();
		System.out.println(text);
		driver.switchTo().window(parentWindow);
		WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
		name.sendKeys(text);
		
		//after entring the text get screen shot of name field
		//we can fileutils and fileHandler both will conver file to pysical file to view
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("element.png"));
		
		//get screen shot of full screen
		File fullPage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(fullPage, new File("screen.png"));
		
		//driver.close();
		//get the width and height of webelement
		System.out.println(name.getRect().getDimension().height);
		System.out.println(name.getRect().getDimension().width);
		
		Assert.assertEquals(name.getRect().getDimension().height, 38);
		Assert.assertEquals(name.getRect().getDimension().width, 1110);
		
		

	}

}
