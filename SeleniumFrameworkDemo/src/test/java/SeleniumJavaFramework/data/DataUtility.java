package SeleniumJavaFramework.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//we have json data file we need to convert into map to get data
public class DataUtility {
	
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		//convert json into string -use file utils
		String jsonDataString = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//SeleniumJavaFramework//data//PurcahseOrder.json"),StandardCharsets.UTF_8);
		
		//convert string into map - use jakson data bind
		ObjectMapper mapper = new ObjectMapper();	
		List<HashMap<String,String>> data = mapper.readValue(jsonDataString, new TypeReference<List<HashMap<String,String>>>(){});
		
		//above list contains 2 hash maps which we added in json data
		return data;
		
	}

}
