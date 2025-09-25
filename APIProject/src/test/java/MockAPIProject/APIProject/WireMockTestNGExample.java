package MockAPIProject.APIProject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class WireMockTestNGExample {
	
	@BeforeClass
	public void mockServerSetUp() {
		WireMock.configureFor("localhost", 8081);
	}
	@Test
	public void mockTestAPI() throws IOException {
		WireMock.stubFor(get(urlEqualTo("/api/getCall"))
				.willReturn(aResponse()
						.withStatus(200)
						//.withHeader("Content-Type", "application/json")
						.withBody("{ \"message\": \"Mocked data for component\" }")));
		String res = makeAPiRequest();
		System.out.println(res);
		
		
	}
	
	private String makeAPiRequest() throws IOException {
		try {
			URL url = new URL("http://localhost:8081/api/getCall");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			BufferedReader red = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while((inputLine = red.readLine()) != null) {
				response.append(inputLine);
			}
			red.close();
			return response.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	

}
