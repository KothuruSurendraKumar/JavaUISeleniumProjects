package YatraProject.YatraProject;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YatraE2EProject {

	private static WebDriver driver;
	private static ChromeOptions options;
	private static WebDriverWait wait;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// WebDriverManager.chromiumdriver().setup();
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--blink-settings=imagesEnabled=false");
		//options.addArguments("--headless");
		driver = new ChromeDriver(options);
//		DevTools devTools = ((HasDevTools) driver).getDevTools();
//		devTools.createSession();
//		// Enable network interception
//		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//		// Block CSS and font types
//		devTools.send(Network.setBlockedURLs(List.of("*.css", "*.woff", "*.woff2", "*.ttf")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			By loginLocator = By.xpath("//span[@class='style_cross__q1ZoV']/img");
			wait.until(ExpectedConditions.visibilityOfElementLocated(loginLocator));
			WebElement loginPopup = driver.findElement(loginLocator);
			if (loginPopup.isDisplayed()) {
				loginPopup.click();
				System.out.println("Pop up hadled");
			} else {
				System.out.println("Pop up not displayed");
			}
		} catch (Exception e) {
			System.out.println("No popup displayed");
		}
		WebElement element = driver.findElement(By.xpath("//div[@class='css-w7k25o']"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
//		WebElement nextMonthButton = driver.findElement(By.xpath("//button[contains(@class,'react-datepicker__navigation--next')]"));
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//		nextMonthButton.click();
		By currentMonth = By.xpath("//div[@class='react-datepicker__month-container']");
		List<WebElement> currentMonthPrices = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(currentMonth));
		System.out.println(currentMonthPrices.size());
		WebElement priceElement = currentMonthPrices.get(0);
		String currentMonthText = priceElement.findElement(By.xpath("//div//span[@class='react-datepicker__current-month']")).getText();
		System.out.println("Current Month "+currentMonthText);
		By pricesEle = By.xpath("//span[contains(@class,'custom-day-content')]");
 		List<WebElement> prices = priceElement.findElements(pricesEle);
 		System.out.println("Sizes "+prices.size());
 		int lowPrice = Integer.MAX_VALUE;
 		WebElement dataElement = null;
		for(WebElement e : prices) {
			String price = e.getText();
			price = price.replace("₹", "").replace(",", "");
			System.out.println(Integer.parseInt(price));
			int extractedPrice = Integer.parseInt(price);
			if(extractedPrice < lowPrice) {
				lowPrice = extractedPrice;
				dataElement = e;
			}	
		}
		WebElement DataElement = dataElement.findElement(By.xpath(".."));
		String result = DataElement.getText() + "Lowest Price "+ lowPrice;
		System.out.println("result "+result);
		
		
		//
		////div[contains(@class,'row-calendar  dual-calendar')]//div[@class='react-datepicker__month-container'][2]

	}

}
