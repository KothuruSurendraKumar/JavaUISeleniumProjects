package Features.ChromeDevtoolsProtocol;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v130.network.Network;

import com.google.common.collect.ImmutableList;

/*
 * In web page we have some many images when page is loading it will take too much time to load fase we can block images and get the page
 */

public class BlockFeatureScenario {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		DevTools tools = driver.getDevTools();
		tools.createSession();
		
		tools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		tools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		
		////a[contains(text(),'Appium')]
		driver.findElement(By.xpath("//a[contains(text(),'Appium')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]")).click();
		Thread.sleep(3000);
		String msg = driver.findElement(By.xpath("//p[@class='sp']")).getText();
		System.out.println(msg);
		driver.findElement(By.cssSelector("a[routerlink*='cart']")).click();
		try {
			WebElement ele = driver.findElement(By.xpath("//div[@class='media']"));
			if(ele != null) {
				System.out.println("Product Added");
			}
		}catch(Exception e) {
			System.out.println("Element Not Added");
		}
		
	}

}
