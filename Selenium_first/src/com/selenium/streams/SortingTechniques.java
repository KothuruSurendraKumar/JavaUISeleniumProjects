package com.selenium.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/*
 * check the web table in sorted order or not
 */

public class SortingTechniques {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// click on the column and elements will get sort
		driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();
		// get all the web element in one list
		List<WebElement> originalList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		// get all the web element text in one list

		// List<String> newList = new ArrayList<>();
//		for(int i=0;i<originalList.size();i++) {
//			String item = originalList.get(i).getText();
//			System.out.println(originalList.get(i).getText());
//			//newList.add(item);
//		}

		// using streams
		List<String> newList = originalList.stream().map(s -> s.getText()).collect(Collectors.toList());
		originalList.stream().map(s -> s.getText()).forEach(System.out::println);

		// sort the new list which have text
		List<String> sortedList = newList.stream().sorted().collect(Collectors.toList());

		// compare the new list and sorted list if both are same and print sorted or not
		// in sorted order
		boolean isSorted = newList.equals(sortedList);
		if (isSorted) {
			System.out.println("List is sorted");
		} else {
			System.out.println("not sorted");
		}

		// Assertion
		Assert.assertTrue(newList.equals(sortedList));

		// get the price of product.In table for every veg have price.get the price of
		// any one product

		List<String> priceList = originalList.stream().filter(s -> s.getText().contains("Banana"))
				.map(s -> getProPrice(s)).collect(Collectors.toList());
		priceList.forEach(s -> System.out.println(s));

		// seleting only first page element.what if not prsent in first page.need to go
		// second page and need to get price from there
		// write pagination concept using selenium
		// first check in 1st page if not present in 1st page go to second so we using
		// do while
		// when we move to next page we need to add new items in list on that page so we
		// use updatedList
		List<String> price;
		do {

			List<WebElement> updatedList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			price = updatedList.stream().filter(s -> s.getText().contains("Rice")).map(s -> getProPrice(s))
					.collect(Collectors.toList());
			price.forEach(s -> System.out.println(s));
			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (price.size() < 1);

	}

	private static String getProPrice(WebElement s) {
		// TODO Auto-generated method stub
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
