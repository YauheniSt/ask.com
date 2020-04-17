package ask.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ask.base.Base;

public class Util extends Base {

	public void quiteBrowser() {
		driver.quit();
	}

	public static int implicitWait = 2;

	public static void refreshBrowser() {
		driver.navigate().refresh();
	}
	@Test
	public void convertCelsiusToFahrenheit() {
	       double factor= 9.0/5.0;
	      // double FT=factor*41+ 32;
	    System.out.println(factor);

	    }

	public static void switchingsBetweenWindows() {
		Set<String> it = driver.getWindowHandles();
		Iterator<String> ind = it.iterator();
		String parent = ind.next();
		String child = ind.next();
		driver.switchTo().window(child);

	}

	public static void navigateBack3Times() {
		for (int i = 0; i < 3; i++) {
			driver.navigate().back();
		}
	}

	public String emailGenerator() {
		driver.get("https://generator.email/inbox1/");
		String email = driver.findElement(By.xpath("//div[@id='newselect']/../..//following-sibling::b//span"))
				.getText();
		return email;
	}

	public static void getScreenshot(String result) throws IOException {
		String dir = System.getProperty("user.dir");
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(dir + "//failers//" + result + ".png"));

	}
	
	public void getScre() throws IOException {
	File file= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File("C:"));
	}

	/*
	 * public static void takeScreenshotAtEndOfTest() throws IOException { File
	 * scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); String
	 * currentDir = System.getProperty("user.dir"); FileUtils.copyFile(scrFile, new
	 * File(currentDir + System.currentTimeMillis() + ".png")); }
	 */

	public void waitForRegisterNowButton() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Register Now']/..")));
	}

	public void waitForRegistrationConfirmationPageURL() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.urlToBe(prop.getProperty("registrationConfirmationPage")));
	}

	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		String dir = System.getProperty("user.dir");
		String TESTDATA_SHEET_PATH = dir + "\\src\\main\\java\\ask\\testData\\askData.xlsx";
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
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

	
	
	public static Object[][] dataGetting(String sheetName) throws IOException {
	String dir=	System.getProperty("user.dir");
	String dataDir=dir + "\\src\\main\\\\java\\ask\\testData\\askData.xlsx";
	String path="C:\\ask.com\\src\\main\\java\\ask\\testData\\askData.xlsx";
		FileInputStream file=new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sh=wb.getSheet(sheetName);
		
		int rowsNumber=sh.getLastRowNum();
		int cellsNumber=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new	Object[rowsNumber][cellsNumber];	
		
		for (int i=0; i<rowsNumber;i++) {
		XSSFRow currentRow=	sh.getRow(i+1);
		for(int j=0;j<cellsNumber;j++) {
			
		data[i][j]=	currentRow.getCell(j).toString();
		}
			
		}return data;
		
	}
	
	public static Object[][] dataGetting1(String sheetName) throws IOException {
		String dir=	System.getProperty("user.dir");
		String dataDir=dir + "\\src\\main\\\\java\\ask\\testData\\askData.xlsx";
		String path="C:\\ask.com\\src\\main\\java\\ask\\testData\\askData.xlsx";
			FileInputStream file=new FileInputStream(path);
			XSSFWorkbook wb=new XSSFWorkbook(file);
			XSSFSheet sh=wb.getSheet(sheetName);
			
			//int rowsNumber=sh.getLastRowNum();
			//int cellsNumber=sh.getRow(0).getLastCellNum();
			
			Object[][] data=new	Object[6][6];	
			
			for (int i=0; i<6;i++) {
			XSSFRow currentRow=	sh.getRow(i+1);
			for(int j=0;j<6;j++) {
				
			data[i][j]=	currentRow.getCell(j).toString();
			}
				
			}return data;
			
		}
		
	
		
		}
	
	
	
