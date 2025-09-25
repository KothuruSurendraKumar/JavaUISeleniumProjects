package Features.ChromeDevtoolsProtocol;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class GetLogsWithSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.xpath("//button[contains(@class,'add-to-cart')]")).click();
		driver.findElement(By.cssSelector("a[routerlink*='cart']")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry>  logs = entry.getAll();
		for(LogEntry log : logs) {
			System.out.println(log.getMessage());
		}
	}

}
