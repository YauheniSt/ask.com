package ask.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ask.base.Base;

public class Util extends Base {
	public static int implicitWait = 5;
	
	public void waitForRegisterNowButton() {
	WebDriverWait wait=new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Register Now']/..")));
	}
	public void waitForRegistrationConfirmationPageURL() {
		WebDriverWait wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.urlToBe(prop.getProperty("registrationConfirmationPage")));
		}
	
	
	//public static String TESTDATA_SHEET_PATH = "C:\\My workspace\\askData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	

	public static Object[][] getTestData(String sheetName) {
		String TESTDATA_SHEET_PATH = "\\ask.com\\src\\main\\java\\ask\\testData\\askData.xlsx";
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

			}
		}
		return data;
	}
}
