package com.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

/*
 * Some https pages have ssl certification verification .Then we need to click advanced and click on the link
 * In selenium there is class chromeOptions,firefoxOptions,safariOptions etc..
 * Internally it handles all the steps like click on advanced and click on link
 * 
 * setting up the proxy in your automation
 * why we use proxy means some websites we need to run from different countries.In that way we can add country IP and port and run the case from that country
 * 
 * need to download the links from web site in specfic path
 * 
 * done by using chrome options
 * */

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//runWithProxy();
		getTitleByAcceptingSSLCert();
		

	}
	
	public static void getTitleByAcceptingSSLCert() {
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--ignore-certificate-errors");
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");

        // Perform actions on the page (for testing purposes)
        System.out.println("Title: " + driver.getTitle());

		
	}
	
	public static void runWithProxy() {
		ChromeOptions option = new ChromeOptions();
		//SafariOptions option1 = new SafariOptions();
		//setting up proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("17.13.1.23:3030");
		option.setCapability("proxy", proxy);
		//Download the files in specific path
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("prefs", prefs);
		option.setAcceptInsecureCerts(true);
		//option1.setAcceptInsecureCerts(true);		
		WebDriver driver = new ChromeDriver(option);
		//WebDriver driver2 = new SafariDriver(option1);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
	}
	

}
