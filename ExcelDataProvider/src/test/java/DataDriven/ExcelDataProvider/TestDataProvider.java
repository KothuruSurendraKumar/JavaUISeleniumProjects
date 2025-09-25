package DataDriven.ExcelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {

	@DataProvider(name = "excel")
	public Object[][] getDataFromExcel() throws IOException {
		FileInputStream fis = new FileInputStream("//Users//surendra.k//Documents//selenium_files//TestData.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("demo");
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getPhysicalNumberOfCells();
		Object[][] data = new Object[rowCount - 1][2];
		for (int i = 1; i < rowCount; i++) {
			row = sheet.getRow(i);
			String s1 = row.getCell(0).toString();
			String s2 = row.getCell(1).toString();
			data[i - 1][0] = s1;
			data[i - 1][1] = s2;
		}
		return data;
	}

	@DataProvider(name = "excelSheet")
	public Object[][] getAllDataFromExcel() throws IOException {
		FileInputStream fis = new FileInputStream("//Users//surendra.k//Documents//selenium_files//TestData.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("testcases");
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getPhysicalNumberOfCells();
		Object[][] data = new Object[rowCount - 1][colCount];
		for (int i = 1; i < rowCount; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i - 1][j] = getCellValue(cell);
			}
		}
		return data;
	}

	private Object getCellValue(XSSFCell cell) {
		// TODO Auto-generated method stub
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue();// if cell conatins date it returns date
			} else {
				double num = cell.getNumericCellValue();
				if (num == Math.floor(num)) {
					return (int) num; // Convert to Integer if it's a whole number
				}
				return num; // Return as double otherwise
			}
		default:
			return "Not type";
		}

	}

	// @Test(dataProvider = "excelSheet")
	public void getData(String a1, String a2, int a3, String a4) {
		System.out.println(a1 + " " + a2 + " " + a3 + " " + a4);
	}

	// @Test(dataProvider="excel")
	public void getData(String a1, String a2) {
		System.out.println(a1 + " " + a2);
	}

}
