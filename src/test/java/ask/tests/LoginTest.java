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
	String sheetName = "LoginData";

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		teacherHomePage = new TeacherHomePage();
		studentHomePage = new StudentHomePage();
		sa = new SoftAssert();
		util = new Util();

	}

	@Test
	public void loginAsTeacher() {
		loginPage.login(prop.getProperty("teacherEmail"), prop.getProperty("teacherPassword"));
		Assert.assertTrue(teacherHomePage.getTeacherLabel());

	}

	@Test(dataProvider="dataProvider")
	public void loginAsStudent(String email, String password) {
		
		loginPage.login(email, password);
		if(!email.isEmpty() && !password.isEmpty()) {		
		try {
			Assert.assertTrue(loginPage.getAuthenticationFailed());
		}
		catch(Exception e) {
			Assert.assertTrue(studentHomePage.getStudentLabel());
			Assert.assertEquals(studentHomePage.getCurrentUrl(), prop.getProperty("studentHomePageURL"));
		}
		}
		else if(email.isEmpty()) {
		Assert.assertTrue(loginPage.getEmailFieldIsRequired());
		}
		
		else if(password.isEmpty()) {
			Assert.assertTrue(loginPage.getPasswordFieldIsRequired());
			}
		
		
	}
	@DataProvider
	public Object[][] dataProvider() throws IOException{
	Object[][]	data =Util.dataGetting("Login");
		return data;
		
	}
	
	@AfterMethod(enabled=true)
	public void tearDown() {
		driver.quit();
	}
}
