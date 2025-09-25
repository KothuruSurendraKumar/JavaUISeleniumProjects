package DownloadAndUpload.DownloadUploadDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadDownload {

	public static void main(String[] args) throws IOException {
		String rowName = "Apple";
		String colName = "price";
		String filePath = "/Users/surendra.k/Downloads/download.xlsx";
		String modValue = "544";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// download the file
		driver.findElement(By.id("downloadButton")).sendKeys(Keys.RETURN);

		// Edit the excel sheet value
		

		int columnNum = getColumnNumber(filePath, colName);
		int rowNumber = getRowNum(filePath, rowName);
		boolean isFound = updateCellValue(filePath, columnNum, rowNumber, modValue);
		Assert.assertTrue(isFound);

		// upload file
		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		upload.sendKeys(filePath);

		// get the success message wait untill success msg displayed and wait untill msg
		// disapper

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		// Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter
		// Toastify__toast-body
		WebElement toster = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		wait.until(ExpectedConditions.visibilityOf(toster));
		System.out.println("Success Msg " + toster.getText());
		Assert.assertEquals("Updated Excel Data Successfully.", toster.getText());
		wait.until(ExpectedConditions.invisibilityOf(toster));

		// verify the cell value with updated and exisiting.these also correct but we
		// need to get based on fruit name
		// WebElement cellValue =
		// driver.findElement(By.xpath("//div[@id='row-1']//div[@data-column-id='4']//div"));
		// Here 1st got apple text 2nd go to parent 3rd go to grand parent 4th access
		// the price particular element in row
		// to be more genric get the price column and add it
		String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		WebElement cellValue = driver.findElement(By.xpath("//div[text()='" + rowName
				+ "']//parent::div//parent::div//div[@id='cell-" + priceColumn + "-undefined']"));
		System.out.println("Value: " + cellValue.getText());
		Assert.assertEquals(modValue, cellValue.getText());

	}

	private static boolean updateCellValue(String filePath, int columnNum, int rowNumber, String value) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(rowNumber-1);
		Cell cell = row.getCell(columnNum-1);
		cell.setCellValue(value);
		FileOutputStream output = new FileOutputStream(filePath);
		workbook.write(output);
		workbook.close();
		return true;
	}

	private static int getRowNum(String filePath, String name) throws IOException {
		DataFormatter formatter = new DataFormatter();
		FileInputStream file = new FileInputStream(filePath);
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

	private static int getColumnNumber(String filePath, String name) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
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
