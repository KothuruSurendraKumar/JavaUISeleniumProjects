package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int expectedYear = 2027;
		String expectedMonth = "November";
		String day = "21";
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
		String actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		String actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
		int year = Integer.parseInt(actualYear);

		while (!(actualMonth.equals(expectedMonth) && actualYear.equals(String.valueOf(expectedYear)))) {
			if (expectedYear > year
					|| (expectedYear == year && getMonthIndex(expectedMonth) > getMonthIndex(actualMonth))) {
				driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-next')]")).click();
			} else {
				driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-prev')]")).click();
			}
			actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
		}

		// Mar 2025
//		if (year < expectedYear) {
//			while (!(actualMonth.equals("July") && actualYear.equals("2026"))) {
//				driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-next')]")).click();
//				actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
//				actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
//			}
//		} else {
//			while (!(actualMonth.equals("July") && actualYear.equals(String.valueOf(expectedYear)))) {
//				driver.findElement(By.xpath("//a[contains(@class,'ui-datepicker-prev')]")).click();
//				actualMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
//				actualYear = driver.findElement(By.className("ui-datepicker-year")).getText();
//			}
//		}

		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[contains(text(),'"+day+"')]")).click();
		//System.out.println(driver.findElement(By.xpath("//input[@id='datepicker']")).getText());

	}

	private static int getMonthIndex(String month) {
		// TODO Auto-generated method stub
		switch (month) {
		case "January":
			return 0;
		case "February":
			return 1;
		case "March":
			return 2;
		case "April":
			return 3;
		case "May":
			return 4;
		case "June":
			return 5;
		case "July":
			return 6;
		case "August":
			return 7;
		case "September":
			return 8;
		case "October":
			return 9;
		case "November":
			return 10;
		case "December":
			return 11;
		default:
			throw new IllegalArgumentException("Invalid month: " + month);
		}
	}

}
