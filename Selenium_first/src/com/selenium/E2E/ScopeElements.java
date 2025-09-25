package com.selenium.E2E;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//1.get the count no of links present in web page
		//Hint : if it is link then it has a tag
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2.get the no of links present in footer section 
		//now we need to limit the scope for footer section only.nothing but need to sub driver for footer
		
		//first get the footer web element
		//limiting web driver scope
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		//now we can get the no of links present in footer section
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//3.inside footer there will be an 4 sections.need to count of links present in 1st section
		//create another sub driver in footer and get the links
		
		WebElement subDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(subDriver.findElements(By.tagName("a")).size());
		
		//4.open the each and every link and check the link is opening or not
		//As of now it has 4 if it increase or decrease need to write code if it is dynamic
		
		int getLinks = subDriver.findElements(By.tagName("a")).size();
		
		//if links increase or decrease it will handle the code
		//code will fail if you write only for loop because after clicking first link page will mode to that clikable page.when trying to click second link gives an error element not found
		//after clicking each link and back and fro means it will take more time
		//when we press cntrl + enter link open in new tab we can send as keys
		for(int i = 1; i < getLinks ; i++) {
			//as it was mac we using command it it is windows we use control
			//As we need to press two keys so we using chord
			String clickTheLinks = Keys.chord(Keys.COMMAND,Keys.ENTER);
			subDriver.findElements(By.tagName("a")).get(i).sendKeys(clickTheLinks);
			Thread.sleep(5000L);
			
			
		}
		
		//5.After opening all the links get the titles of each link
		Set<String> windowsOpend = driver.getWindowHandles();
		Iterator<String> it = windowsOpend.iterator();
		int getNoOfWindows = windowsOpend.size();
		//System.out.println(getNoOfWindows);
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		
		

	}

}
