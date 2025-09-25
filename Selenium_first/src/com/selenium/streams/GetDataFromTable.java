package com.selenium.streams;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDataFromTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/");

		List<WebElement> li = driver.findElements(By.xpath("//table[@id='customers']//tbody//td[2]"));
		li.stream().map(s -> s.getText()).forEach(s -> System.out.println(s));

		WebElement ele = li.stream().filter(s -> s.getText().contains("Jenkins")).map(s -> getCheckBox(s)).findFirst()
				.orElse(null);
		if (ele != null) {
			ele.click();
			System.out.println(ele.isSelected());
		} else {
			System.out.println(ele.isSelected());
		}
		
		for(WebElement elee : li) {
			String text = elee.getText().trim();
			
			if(text.equalsIgnoreCase("Selenium")) {
				WebElement row = elee.findElement(By.xpath("./parent::tr"));
				List<WebElement> columns = row.findElements(By.tagName("td"));

                // Extracting details
                String checkboxStatus = columns.get(0).findElement(By.tagName("input")).isSelected() ? "Checked" : "Unchecked";
                String name = columns.get(1).getText();
                String contact = columns.get(2).getText();
                String country = columns.get(3).getText();
                String description = columns.get(4).getText();

                // Print row details
                System.out.println("Checkbox: " + checkboxStatus);
                System.out.println("Name: " + name);
                System.out.println("Contact: " + contact);
                System.out.println("Country: " + country);
                System.out.println("Description: " + description);
			}
		}

	}

	private static Object getAllDetails(WebElement s) {
		// TODO Auto-generated method stub
		return null;
	}

	private static WebElement getCheckBox(WebElement ele) {
		// TODO Auto-generated method stub
		return ele.findElement(By.xpath("preceding-sibling::td//input[@type='checkbox']"));

	}

}
