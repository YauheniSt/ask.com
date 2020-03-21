package ask.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ask.base.Base;

public class Util extends Base {
	
	
	public void quiteBrowser() {
		driver.quit();
	}
	
	public static int implicitWait = 5;
	public static void refreshBrowser() {
		driver.navigate().refresh();
		}
	
	public static void switchingsBetweenWindows() {
	Set<String> it=driver.getWindowHandles();
	Iterator<String> ind=it.iterator();
	String parent = ind.next();
	String child=ind.next();
	driver.switchTo().window(child);
	
		}
	
	public static void navigateBack3Times() {
	for (int i = 0; i < 3; i++) {
		driver.navigate().back();
	}}
	
	public String emailGenerator() {
	driver.get("https://generator.email/inbox1/");
	String email = driver.findElement(By.xpath("//div[@id='newselect']/../..//following-sibling::b//span"))
			.getText();
	return email;	
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("/ask.com/resources");
		FileUtils.copyFile(scrFile, new File("/ask.com/resources/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public void waitForRegisterNowButton() {
	WebDriverWait wait=new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Register Now']/..")));
	}
	public void waitForRegistrationConfirmationPageURL() {
		WebDriverWait wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.urlToBe(prop.getProperty("registrationConfirmationPage")));
		}
	static String TESTDATA_SHEET_PATH="\\ask.com\\src\\main\\java\\ask\\testData\\askData.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static Object[][] getTestData(String sheetName) {
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
}}