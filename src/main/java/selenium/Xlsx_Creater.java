package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ask.base.Base;

public class Xlsx_Creater extends Base {
	static String sheetName="email2";
	Xlsx_Creater xlsx_Creater;
	
	@Test
	public void createData() throws IOException {
		String dir = System.getProperty("user.dir");
		String fileDir = dir + "//src//main//java//ask//testData//askData.xlsx";

		FileInputStream file = new FileInputStream(fileDir);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.createSheet(sheetName);

		for (int i = 0; i < 5; i++) {
			XSSFRow row = sheet.createRow(i);
			for (int j = 0; j < 3; j++) {
				row.createCell(j).setCellValue("Test");
			}
		}
		FileOutputStream file2 = new FileOutputStream(fileDir);
		wb.write(file2);
		file2.close();

	}

	
	public static String getData() throws IOException {

		String dir = System.getProperty("user.dir");
		String fileDir = dir + "//src//main//java//ask//testData//askData.xlsx";
		FileInputStream file = new FileInputStream(fileDir);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowsCount = sheet.getLastRowNum();
		int columnsNumber = sheet.getRow(0).getLastCellNum();

		String data = null;
		for (int i = 0; i <= rowsCount; i++) {
			XSSFRow currentRow = sheet.getRow(i);
			for (int j = 0; j < columnsNumber; j++) {
			data = currentRow.getCell(j).toString();
			}
		}
		return data;

	}

	public  String getEmail() throws IOException {

		browserInit();

		driver.get("https://generator.email/inbox1/");

		String email = driver.findElement(By.xpath("//div[@id='newselect']/../..//following-sibling::b//span"))
				.getText();
		return email;
		// System.out.println(email);
	}

	public static void putDataInTable() throws IOException {
		Xlsx_Creater xlsx_Creater=new Xlsx_Creater();
		String email=xlsx_Creater.getEmail();
		String dir = System.getProperty("user.dir");
		String fileDir = dir + "//src//main//java//ask//testData//askData.xlsx";

		FileInputStream file = new FileInputStream(fileDir);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.createSheet(sheetName);

		XSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue(email);

		FileOutputStream file2 = new FileOutputStream(fileDir);
		wb.write(file2);
		file2.close();
		
	}
	
	
	@Test
	public void printEmail() throws IOException {
		xlsx_Creater=new Xlsx_Creater();
		Xlsx_Creater.putDataInTable();
		System.out.println(getData());
	}
}
