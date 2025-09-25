package com;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	public static void main(String[] args) throws IOException {
		// Get the filepath for excel sheet

	}

	public ArrayList<Object> getData(String testName) throws IOException {
		FileInputStream file = new FileInputStream("//Users//surendra.k//Documents//selenium_files//TestData.xlsx");
		// Access the excel file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// we have no of sheets we need to get desired sheet
		int sheets = workbook.getNumberOfSheets();
		ArrayList<Object> list = new ArrayList<Object>();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testcases")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Get access to rows
				Iterator<Row> row = sheet.rowIterator();
				// get first row
				Row firstRow = row.next();
				// get cells in rows
				Iterator<Cell> cells = firstRow.cellIterator();
				int k = 0, column = 0;
				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCase")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);

				// get the data prusent in Purchase row
				while (row.hasNext()) {
					Row r = row.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testName)) {
						Iterator<Cell> c = r.cellIterator();
						while (c.hasNext()) {
							Cell value = c.next();
							// System.out.println(value.getStringCellValue());
							if (value.getCellType() == CellType.STRING) {
								list.add(value.getStringCellValue());
							} else {
								list.add(NumberToTextConverter.toText(value.getNumericCellValue()));
								//list.add(value.getNumericCellValue());
							}
						}
					}
				}
			}
		}
		return list;
	}
	
	public ArrayList<String> getAllData() throws IOException {
		FileInputStream file = new FileInputStream("//Users//surendra.k//Documents//selenium_files//TestData.xlsx");
		// Access the excel file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		ArrayList<String> data = new ArrayList<String>();
		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("demo")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.rowIterator();
				while(rows.hasNext()) {
					Row r = rows.next();
					Iterator<Cell> cells = r.cellIterator();
					while(cells.hasNext()) {
						Cell cell = cells.next();
						if(cell.getCellType() == CellType.STRING) {
							data.add(cell.getStringCellValue());
						}else {
							data.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
						}
					}
				}
				
			}
		}
		
		
		return data;
	}

}
