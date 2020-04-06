package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ask.base.Base;

public class Xlsx_reader extends Base {
	
	//explanation
	public static Object[][] dataReader() throws IOException {
		String dir=System.getProperty("user.dir");
		String fileDir=dir+"\\src\\main\\java\\ask\\testData\\askData.xlsx";
		//let the Selenium know where our data file is located
		FileInputStream file=new FileInputStream(fileDir);
		//define our workbook
		XSSFWorkbook wb=new XSSFWorkbook(file);
		//define sheet on the workbook
		XSSFSheet sh=wb.getSheet("Registration");
		//count the number of rows in the table
		int rowsNumber=sh.getLastRowNum();
		//count number of columns in the table
		int columnsNumber=sh.getRow(0).getLastCellNum();
		//create an object of multidimensional array in order to store data
		Object [][] data=new Object[rowsNumber][columnsNumber];
		//create a loop to go through all the rows
		for(int i=0;i<rowsNumber;i++) {
		
		//create a loop inside the loop to go through all the cells in the current row and collect the in the array
		for(int j=0; j<columnsNumber;j++) {
			data[i][j]=sh.getRow(i+1).getCell(j).toString();
		}
		}return data;
	}
	//in order to drive the data in test case we need testNG dataProvider where we pull the data from the reader method
	//and store the in Object array
	@DataProvider
	public Object[][] getData() throws IOException {
		Object [][] data=dataReader();
		return data;
	}
	//now we are ready to drive the data into test case. Define all the parameters that stored in the array
	@Test(dataProvider="getData")
	public void testCase(String firstName, String lastName, String email, String group, String pw, String cpw) {
		System.out.println(firstName+"   "+lastName+"   "+email+"   "+group+"   "+pw+"   "+cpw);
	}
	
	
	
	@Test
	public void readDataPractice() throws IOException {
		String dir = System.getProperty("user.dir");
		String TESTDATA_SHEET_PATH = dir + "\\src\\main\\java\\ask\\testData\\askData.xlsx";
		FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet=workBook.getSheet("Registration");
		int rowsNumber=sheet.getLastRowNum();
		int columnNumber=sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<rowsNumber;i++) {
		XSSFRow row=sheet.getRow(i+1);
		
		for(int j=0;j<columnNumber;j++) {
		String	cellValue=row.getCell(j).toString();
		System.out.print("    "+cellValue);
		}
		System.out.println();	
			
		}
		

	}
	@Test
	public void readDataPractice1() throws IOException {
		String dir = System.getProperty("user.dir");
		String TESTDATA_SHEET_PATH = dir + "\\src\\main\\java\\ask\\testData\\askData.xlsx";
		FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sh=wb.getSheet("Registration");
		
		for(int i=1;i<=sh.getLastRowNum();i++) {
		XSSFRow row=sh.getRow(i);
		
		String firstName=row.getCell(0).toString();
		System.out.println(firstName);
		String lastName=row.getCell(1).toString();
		System.out.println(lastName);
		String email=row.getCell(2).toString();
		System.out.println(email);
		String group=row.getCell(3).toString();
		System.out.println(group);
		String password=row.getCell(4).toString();		
		System.out.println(password);
		String confirmpassword=row.getCell(5).toString();		
		System.out.println(confirmpassword);
		System.out.println();
		}
		
	}
}