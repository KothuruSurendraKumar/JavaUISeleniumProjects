package DataDriven.ExcelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class AppTest {

	@Test
	public void getData() throws IOException {

//		Object[][] data = {{"Hello","Text",123},{"Hi!!","Call",405},{"Bye","Video",894}};
//		return data;

		FileInputStream file = new FileInputStream("//Users//surendra.k//Documents//selenium_files//TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("demo");
		int rowsCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		Object[][] data = new Object[rowsCount - 1][colCount];
		for (int i = 0; i < rowsCount - 1; i++) {
			System.out.println("OuterLoop Started");
			row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {
				System.out.println(row.getCell(j));
			}
			System.out.println("OuterLoop Ended");
		}

	}
}
