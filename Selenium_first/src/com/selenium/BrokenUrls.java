package com.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/*
 * Get the broken links in webpage
 * broken links are nothing but page gives response code above 400
 * 
 * using java method openConnection we get response code and aseert 
 * */

public class BrokenUrls {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		openFourthURLInPage(driver);
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		//If we use assert if first case failed it will stop execution
//		//using soft assert it will complete full execution and at last it will assert the response
//		SoftAssert ass = new SoftAssert();
//		List<WebElement> urls = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
//		System.out.println(urls.size());
//		for(int i=0;i<urls.size();i++) {
//			System.out.println(urls.get(i).getAttribute("href"));
//			String link = urls.get(i).getAttribute("href");
//			
//			HttpURLConnection conn = (HttpURLConnection) new URL(link).openConnection();
//			conn.setRequestMethod("HEAD");
//			conn.connect();
//			int code = conn.getResponseCode();
//			System.out.println("code "+code);
//			
//			ass.assertTrue(code < 400, "Broken Link "+urls.get(i).getText()+"With the code "+code);
//			
//////			if(code > 400) {
//////				System.out.println("Broken Link "+urls.get(i).getAttribute("href"));
//////			}
////			if(code > 403) {
////				System.out.println("Broken Link "+urls.get(i).getText()+"With the code "+code);
////				Assert.assertTrue(false);
////				//System.out.println("Broken Link "+urls.get(i).getText());
//			//}
//		}
//		ass.assertAll();

	}

	private static void openFourthURLInPage(WebDriver driver) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		driver.get("https://selectorshub.com/xpath-practice-page/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {
			try {
				String link = links.get(i).getAttribute("href");
				
				HttpURLConnection conn = (HttpURLConnection) new URL(link).openConnection();
				conn.setRequestMethod("HEAD");
				conn.setConnectTimeout(5000);
				conn.setReadTimeout(5000);
				conn.connect();
				int code = conn.getResponseCode();
				System.out.println("code " + code);
				if (code > 400) {
					System.out.println(link + " : " + code);
				}
			} catch (IOException e) {
				System.out.println("Connection refused or failed: ");
				e.printStackTrace();
			}
		}

	}

}
