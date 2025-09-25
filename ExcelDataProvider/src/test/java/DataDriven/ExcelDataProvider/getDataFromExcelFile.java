package DataDriven.ExcelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getDataFromExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		List<Map<String, String>> data = getDataAsMap();

		for (Map<String, String> m : data) {
			System.out.println(m);
		}

	}

	public static List<Map<String, String>> getDataAsMap() throws IOException {
		FileInputStream fis = new FileInputStream("//Users//surendra.k//Documents//selenium_files//TestData.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("testcases");
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getPhysicalNumberOfCells();
		List<Map<String, String>> datMap = new ArrayList<>();
		for (int i = 1; i < rowCount; i++) {
			XSSFRow subRow = sheet.getRow(i);
			if (subRow == null)
				continue;
			Map<String, String> map = new HashMap<>();
			for (int j = 0; j < colCount; j++) {
				String commonRow = row.getCell(j).getStringCellValue();
				XSSFCell cell = subRow.getCell(j);
				map.put(commonRow, getCellStringValue(cell));

			}
			datMap.add(map);
		}
		return datMap;

	}

	private static String getCellStringValue(XSSFCell cell) {
		// TODO Auto-generated method stub
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		default:
			return "";
		}

	}

}
