package DataDriven.ExcelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	
	@Test(dataProvider="dataDrive")
	public void testData(String greeting,String comm,String id) {
		System.out.println(greeting+" "+comm+" "+id);
	}
	
	@DataProvider(name="dataDrive")
	public Object[][] getData() throws IOException {
		
//		Object[][] data = {{"Hello","Text",123},{"Hi!!","Call",405},{"Bye","Video",894}};
//		return data;
		DataFormatter formatter = new DataFormatter();
		FileInputStream file = new FileInputStream("//Users//surendra.k//Documents//selenium_files//TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("demo");
		int rowsCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		Object[][] data = new Object[rowsCount-1][colCount];
		for(int i=0;i<rowsCount-1;i++) {
			row = sheet.getRow(i+1);
			for(int j=0;j<colCount;j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		return data;
		
		
	}

}
