package ask.tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.StudentHomePage;
import ask.pages.TeacherHomePage;
import ask.util.Util;

public class LoginTest extends Base {

	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	StudentHomePage studentHomePage;
    SoftAssert sa;
    Util util;
    String sheetName="LoginData";
	
    @BeforeMethod(alwaysRun=true)
	public void setUp() throws IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		teacherHomePage = new TeacherHomePage();
		studentHomePage=new StudentHomePage();
		sa=new SoftAssert();
		util=new Util();

	}
    

    @Test(groups= {"Acceptance"})
	public void loginAsStudentTC() {

		loginPage.login(prop.getProperty("studentEmail"), prop.getProperty("studentPassword"));
		try {
			// Assert.assertTrue(loginPage.getErrorMessageRequiredField());
			Assert.assertTrue(loginPage.getAuthenticationFailed());
		} catch (NoSuchElementException e) {
			sa.assertEquals(studentHomePage.getCurrentUrl(), prop.getProperty("studentHomePageURL"),"url is not correct" );
			Assert.assertTrue(studentHomePage.getStudentLabel());
			
			
		}
		sa.assertAll();
	}

    @DataProvider
    public Object[][] getLoginData() throws InvalidFormatException {
    Object data[][]=Util.getTestData(sheetName);
    return data;	    	
    }
    
	@Test(dataProvider = "getLoginData", groups= {"Regression"})
	public void loginAsTeacherTC(String email, String password) {

		loginPage.login(email, password);
		try {
			// Assert.assertTrue(loginPage.getErrorMessageRequiredField());
			Assert.assertTrue(loginPage.getAuthenticationFailed());
		} catch (NoSuchElementException e) {
			sa.assertEquals(teacherHomePage.getCurrentUrl(), prop.getProperty("techerHomePageURL"),"url is not correct" );
			Assert.assertTrue(teacherHomePage.getTeacherLabel());
			
			
		}
		sa.assertAll();
	}

	

	/*@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[3][2];
		data[0][0] = "stashaniny@gmail.com";
		data[0][1] = "12345";

		data[1][0] = "stashaniny@gmail.com";
		data[1][1] = "Tel605144";

		data[2][0] = "stashanin@gmail.com";
		data[2][1] = "12345";
		return data;
	}*/

	@AfterMethod(enabled=false)
	public void tearDown() {
		driver.quit();
	}

}
