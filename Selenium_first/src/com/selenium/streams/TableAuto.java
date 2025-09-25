package com.selenium.streams;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[2]"));
		
		for(WebElement e : ele) {
			if(e.getText().equals("John")) {
				System.out.println(e.findElement(By.xpath("./following-sibling::td[1]")).getText());
			}
		}

	}

}
