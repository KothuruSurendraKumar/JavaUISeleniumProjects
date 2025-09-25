package com.selenium.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/* 
 * 1.selection the check box in checkbox list
 * 2.Grab the text for selected check box
 * 3.Select the option in dropdown same the checkbox text
 * 4.enter the text grabed in checkbox in input text field
 * 5.click on alert and grab the text and verify the text present in alert text or not
 * */

public class AssignmentE2E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://qaclickacademy.com/practice.php");
		
		
		
		boolean checkbox= driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).isSelected();
		System.out.println("Is checked "+checkbox);
		//selection the check box in checkbox list
		driver.findElement(By.xpath("//input[@value ='option2']")).click();
		//Grab the text for selected check box
		String text = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		System.out.println(driver.findElement(By.xpath("//input[@value ='option2']")).isSelected());
		System.out.println("Print text "+text);
		
		//Select the option in dropdown same the checkbox text
		WebElement element = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
		
		//Enter the text got from checkbox
		driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		//click on alert and grab the text and verify the text present in alert text or not
		String alertString = driver.switchTo().alert().getText();
		
		if(alertString.contains(text)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		driver.switchTo().alert().accept();
		
		
		
		
		
		
		
		
	}

}
