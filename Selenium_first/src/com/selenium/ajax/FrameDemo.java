package com.selenium.ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		//get no of frames in web page
		
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("frames present "+size);
		
		//achive frames using index.As in this web pase we have only 1 we can use index as 0
		driver.switchTo().frame(0);
		
		
		//achive the frame using web element
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@src='/resources/demos/droppable/default.html']")));
		
		//drag and drop the element
		
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		//droppable
		WebElement target = driver.findElement(By.id("droppable"));
		action.dragAndDrop(source, target).build().perform();
		
		//after completing frame if we need to access elements outside the frame we need to come out of frame.if not gives error element not found
		
		driver.switchTo().defaultContent();
	}

}
