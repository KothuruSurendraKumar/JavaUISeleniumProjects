package Demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNG_Demo {
  @Test
  public void f() {
	  WebDriver driver  = new ChromeDriver();
	  driver.get("https://google.com");
	  driver.manage().window().maximize();
	  System.out.println(driver.getTitle());
	  Assert.assertEquals("Google", driver.getTitle());
	  System.out.println(driver.getPageSource());
	  driver.close();
	  driver.quit();
	  
  }
}
