package DownloadAndUpload.DownloadUploadDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class DataDrivenExcel {

	public static void main(String[] args) throws IOException {
		
		String filePath = "/Users/surendra.k/Downloads/download.xlsx";
		
		int columnNum = getColumnNumber(filePath,"price");
		int rowNumber = getRowNum(filePath,"Apple");
		boolean isFound = updateCellValue(filePath,columnNum,rowNumber,"599");
		Assert.assertTrue(isFound);
		// TODO Auto-generated method stub
		// Edit the data in excel sheet
		// 1st get the cell number for particular row and column here we are updation
		// apple row price column
	}

	private static boolean updateCellValue(String filePath, int columnNum, int rowNumber, String value) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(columnNum);
		cell.setCellValue(value);
		FileOutputStream output = new FileOutputStream(filePath);
		workbook.write(output);
		workbook.close();
		return true;
		
	}

	private static int getRowNum(String fileName,String name) throws IOException {
		// TODO Auto-generated method stub
		DataFormatter formatter = new DataFormatter();
		FileInputStream file = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> rows = sheet.rowIterator();
		int r = 1, rowNum = -1;
		while (rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> c = row.cellIterator();
			while (c.hasNext()) {
				Cell ce = c.next();
				if (formatter.formatCellValue(ce).equalsIgnoreCase(name)) {
					rowNum = r;
				}
			}
			r++;
		}
		System.out.println("row Num :" + rowNum);
		return rowNum;
	}

	private static int getColumnNumber(String fileName,String name) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> rows = sheet.rowIterator();
		Row firstRow = rows.next();
		Iterator<Cell> cells = firstRow.cellIterator();
		int k = 1, column = 0;
		while (cells.hasNext()) {
			Cell cell = cells.next();
			if (cell.getStringCellValue().equalsIgnoreCase(name)) {
				column = k;
			}
			k++;
		}
		System.out.println("price cell : " + column);
		return column;
	}

}
