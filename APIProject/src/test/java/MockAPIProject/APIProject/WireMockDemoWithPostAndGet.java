package MockAPIProject.APIProject;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WireMockDemoWithPostAndGet {
	private WireMockServer wireMockServer;
	@BeforeClass
	public void setUp() {
		wireMockServer = new WireMockServer(8081); // Start WireMock on port 8081
        wireMockServer.start();
		WireMock.configureFor("localhost", 8081);

		WireMock.stubFor(
				post(urlEqualTo("/api/postCall")).withRequestBody(equalToJson("{\"name\":\"John\",\"age\":25}"))
						.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json")
								.withBody("{\"message\":\"send Request succesfully\"}")));

		WireMock.stubFor(get(urlEqualTo("/api/getResponse")).willReturn(aResponse().withStatus(200)
				.withHeader("Content-Type", "application/json").withBody("{\"name\":\"jhon\",\"age\":25}")));
	}

	@Test
	public void TestResponse() throws IOException {
		String postResponse = makePostCall();
		System.out.println(postResponse);

		String getResponse = makeGetCall();
		System.out.println(getResponse);
	}

	private String makeGetCall() throws IOException {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://localhost:8081/api/getResponse");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String out;
			StringBuilder res = new StringBuilder();
			while ((out = in.readLine()) != null) {
				res.append(out);
			}
			return res.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	private String makePostCall() throws IOException {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://localhost:8081/api/postCall");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);
			String jsonInput = "{\"name\":\"John\",\"age\":25}";

			try (OutputStream os = conn.getOutputStream()) {
				byte[] input = jsonInput.getBytes("utf-8");
				os.write(input, 0, input.length);
				
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String out;
			StringBuilder respo = new StringBuilder();
			while ((out = in.readLine()) != null) {
				respo.append(out);
			}
			System.out.println(respo.toString() +"String response");
			return respo.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
