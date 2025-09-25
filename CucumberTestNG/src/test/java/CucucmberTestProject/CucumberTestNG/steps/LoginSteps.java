package CucucmberTestProject.CucumberTestNG.steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;

import CucucmberTestProject.CucumberTestNG.data.SharedContext;
import CucucmberTestProject.CucumberTestNG.utils.ExcelUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps {
	SharedContext sharedContext;

	public LoginSteps(SharedContext sharedContext) {
		this.sharedContext = sharedContext;
	}

	@Given("I load login data from excel")
	public void i_load_login_data_from_excel() throws EncryptedDocumentException, IOException {
		// System.out.println(System.getProperty("user.dir")+"//src//test//resources//data/TestFile.xlsx");
		String path = System.getProperty("user.dir") + "/src/test/resources/dataFiles/TestFile.xlsx";
		System.out.println("File Loaded -------------- Succesfully");
		List<Map<String, String>> data = ExcelUtils.readFile(path, "Sheet1");
//		sharedContext.username = data.get(0).get("username");
//		sharedContext.password = data.get(0).get("password");
		sharedContext.allUserData = data;
		for (Map<String, String> rowData : data) {
			System.out.println("Username " + rowData.get("username") + "Password " + rowData.get("password"));
		}
	}
	
	@When("I login using extracted username and password")
	public void i_login_using_extracted_username_and_password() {
		for(Map<String,String> userData : sharedContext.allUserData) {
			System.out.println("Actual Username "+userData.get("username"));
			System.out.println("Actual Password "+userData.get("password"));
		}
	}

}
