package Features.ChromeDevtoolsProtocol;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAutentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
//		Predicate<URI> predicateUri = uri -> uri.getHost().contains("httpbin.org");
//		((HasAuthentication)driver).register(predicateUri,UsernameAndPassword.of("foo", "bar"));
		driver.get("https://httpbin.org/basic-auth/foo/bar");
		//driver.get("https://foo:bar@httpbin.org/basic-auth/foo/bar");
		}

}
