package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("story books");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement dropdown = driver.findElement(By.id("s-result-sort-select"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Newest Arrivals");
		List<WebElement> list = driver.findElements(By.xpath("(//div[@data-cy='title-recipe']//span)[1]"));
		for(WebElement ele:list) {
			System.out.println(ele.getText());
		}
		
	}

}
