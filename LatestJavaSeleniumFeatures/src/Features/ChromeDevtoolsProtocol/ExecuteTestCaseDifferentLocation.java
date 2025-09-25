package Features.ChromeDevtoolsProtocol;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExecuteTestCaseDifferentLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		ChromeDriver driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String,Object> coordinates = new HashMap<String,Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);
		
		
		devTools.send(Emulation.setGeolocationOverride(Optional.of(40.4191667), Optional.of(-82.9133333), Optional.of(1)));
		//driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		driver.get("https://my-location.org/");
		System.out.println(driver.findElement(By.id("address")).getText());
		
//		driver.get("https://google.com");
//		driver.findElement(By.name("q")).sendKeys("netflix",Keys.RETURN);
//		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
//
//		driver.findElement(By.cssSelector(".our-story-card-title")).getText();
//
//		System.out.println(driver.findElement(By.xpath("//div[@class='our-story-card-text']/h1")).getText());


		

	}

}
