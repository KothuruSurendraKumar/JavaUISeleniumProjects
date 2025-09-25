package com.selenium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DownloadFileInPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "/Users/surendra.k/Documents/testing";
		
		Map<String,Object> prefs = new HashMap<>();
		//setting default directory
		prefs.put("download.default_directory", path);
		//Ensure no confirmation dialog box appears
		prefs.put("download.prompt_for_downlaod", false);
		prefs.put("plugins.always_open_pdf_externally", true);
		prefs.put("profile.managed_default_content_settings.images", 2); // Block images
		prefs.put("profile.managed_default_content_settings.stylesheets", 2); // Block CSS
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://file-examples.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Browse')]")).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='container-fluid']//div//div[3]//a[text()='Browse']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		element.click();
		
		
		
		
		
		
		//driver.manage().window().maximize();
//		WebElement element = driver.findElement(By.xpath("//div[@class='container-fluid']//div//div[3]//a[text()='Browse']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		Point point = element.getLocation();
//		int x = point.getX();
//		int y = point.getY();
//		//js.executeScript("arguments[0].scrollIntoView(true)", element);
//		//scroll the at window level
//		js.executeScript("window.scrollBy(0,1800)");
//		element.click();
//		//getting an ads to handle done the refresh
//		driver.navigate().refresh();
//		driver.findElement(By.xpath("//div[@class='container-fluid']//div//div[3]//a[text()='Browse']")).click();
////		String mainWindow = driver.getWindowHandle();
////		Set<String> window = driver.getWindowHandles();
////		for(String win : window) {
////			driver.switchTo().window(win);
////			driver.close();
////		}
//		js.executeScript("window.scrollBy(0,2800)");
//		driver.findElement(By.xpath("//table[@id='table-files']//tbody//tr[3]//a")).click();
//		driver.findElement(By.xpath("//table[@id='table-files']//tbody//tr[1]//a")).click();

	}

}
