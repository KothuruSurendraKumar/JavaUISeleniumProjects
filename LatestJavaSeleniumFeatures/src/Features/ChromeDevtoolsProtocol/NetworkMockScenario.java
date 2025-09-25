package Features.ChromeDevtoolsProtocol;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v130.fetch.Fetch;

/*
 * consider you have requirement get all user books list if any user have only one book then print the message like one book found
 * for that we need to ceate new session and login as another user and get the message
 * Instead of creating new session we can do in one session
 * consider this url https://rahulshettyacademy.com/Library/GetBook.php?AuthorName=shettyAll if author name is ShettyAll it will get all books
 * if AuthorName is BadGuy it will give only one book just mock the network call with shettyAll with BadGuy and get message in same session
 * 
 */

public class NetworkMockScenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools tools = driver.getDevTools();
		tools.createSession();
		// enable the fetch
		tools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		// need to modify the request
		tools.addListener(Fetch.requestPaused(), request -> {
			// 1st get the url need to mock
			if (request.getRequest().getUrl().contains("shetty")) {
				// modify the url
				String newUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println("NewURL : " + newUrl);
				// After modifying the url resume the request flow using continueRequest and
				// send the mocked url to client
				tools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newUrl), Optional.empty(),
						Optional.empty(), Optional.empty(), Optional.empty()));
			} else {
				// if shetty is find modify request or else continue without mocking
				tools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		// WebElement ptag = driver.findElement(By.tagName("p"));
		try {
			if (driver.findElement(By.tagName("p")) != null) {
				String msg = driver.findElement(By.tagName("p")).getText();
				System.out.println(msg);

			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("No P Message");
		}

	}

}
