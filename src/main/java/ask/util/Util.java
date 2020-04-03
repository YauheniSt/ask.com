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

	@Test
	public void dragAndDrop() throws IOException {
		browserInit();
		launchApp();
		WebElement drag = driver
				.findElement(By.xpath("//div[@id='products']//div//ul//li[2]//a[contains(text(),'5000')]"));
		WebElement drop = driver
				.findElement(By.xpath("//h3[contains(text(),'DEBIT SIDE')]/..//h3[contains(text(),'Amount')]/..//li"));

		Actions actions = new Actions(driver);

		actions.dragAndDrop(drag, drop).build().perform();
		try {
			String text = drop.getText();
			System.out.println(text);
		} catch (StaleElementReferenceException e) {
			WebElement drop2 = driver.findElement(
					By.xpath("//h3[contains(text(),'DEBIT SIDE')]/..//h3[contains(text(),'Amount')]/..//li"));
			String text2 = drop2.getText();
			System.out.println(text2);
		}
	}

	@Test
	public void clickAndHold() throws IOException {
		browserInit();
		launchApp();
		WebElement drag = driver
				.findElement(By.xpath("//div[@id='products']//div//ul//li[2]//a[contains(text(),'5000')]"));
		WebElement drop = driver
				.findElement(By.xpath("//h3[contains(text(),'DEBIT SIDE')]/..//h3[contains(text(),'Amount')]/..//li"));

		Actions actions = new Actions(driver);
		actions.clickAndHold(drag).build().perform();
		actions.doubleClick(driver.findElement(By.xpath("//strong[text()='Note:']"))).build().perform();

	}
	
		
		}
	
	
	
