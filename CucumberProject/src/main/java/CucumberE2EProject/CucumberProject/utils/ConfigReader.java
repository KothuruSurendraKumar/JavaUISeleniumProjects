package CucumberE2EProject.CucumberProject.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public Properties intilizeProperties() throws IOException {
		Properties prop = new Properties();
		File profile = new File(System.getProperty("user.dir")+"//src//test//resources//config//config.properties");
		
		try {
			FileInputStream fip = new FileInputStream(profile);
			prop.load(fip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
