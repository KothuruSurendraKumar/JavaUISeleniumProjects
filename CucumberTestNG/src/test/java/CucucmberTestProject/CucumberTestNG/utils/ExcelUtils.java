package CucucmberTestProject.CucumberTestNG.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	public static List<Map<String, String>> readFile(String filePath,String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet st = wb.getSheet(sheet);
		List<Map<String,String>> data = new ArrayList<>();
		Row header = st.getRow(0);
		for(int i=1;i<=st.getLastRowNum();i++) {
			Map<String,String> rowData = new HashMap<>();
			Row row = st.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++) {
				rowData.put(header.getCell(j).getStringCellValue().trim().toLowerCase(),row.getCell(j).toString());
				System.out.println("Header "+header.getCell(j).getStringCellValue()+" Values :"+row.getCell(j).toString());
			}
			data.add(rowData);
		}
		wb.close();
		return data;
	}

}
