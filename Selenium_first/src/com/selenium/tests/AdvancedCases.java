package com.selenium.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*Scenario: Need to Test anybank.com site
Condition A: test the application hosted in 2 different Regions.
Condition B: It is SSL Based site, handle SSL.
Condition C: Need to configure the Proxy for each region.
Condition D: Using region identifier, identify region.
Condition E: Utilize the same cookie in every session.
*/

public class AdvancedCases {
	// Test the application hosted in 2 regions
	public static Map<String, String> regionProxyMap = new HashMap<String, String>();
	static {

		regionProxyMap.put("US", "https://us-west.proxy.example.com:8080");
		regionProxyMap.put("EU", "https://eu-central.proxy.example.com:8080");
	}

	public static String getRegionIdentifier() {
		return "US";
	}

	public static void main(String[] args) {
		String region = getRegionIdentifier();
		String proxy = regionProxyMap.get(region);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--proxy-server",proxy);
		options.addArguments("--ignore-certificate-errors");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://smartproxy.com/");
		System.out.println(driver.getTitle());
		
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie c : cookies) {
			System.out.println(c.getName() +" : "+c.getValue());
		}
		

	}

}
