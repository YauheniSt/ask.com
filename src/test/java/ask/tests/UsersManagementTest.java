package ask.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.TeacherHomePage;
import ask.pages.UsersManagementPage;

public class UsersManagementTest extends Base {
	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	UsersManagementPage usersManagementPage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();		
		loginPage.login(prop.getProperty("teacherEmail"), prop.getProperty("teacherPassword"));
		teacherHomePage=new TeacherHomePage();
		teacherHomePage.clickUsersManagementLink();
		usersManagementPage=new UsersManagementPage();
		
	}
	
	@Test(groups= {"Regression"})
	public void verifyUserDisplayed() throws InterruptedException {
		Assert.assertTrue(usersManagementPage.getStudent(prop.getProperty("group"), prop.getProperty("studentFirstName"), prop.getProperty("studentLastName")));
			}
	
	
	@AfterMethod(enabled=true)
	public void tearDown() {
		driver.quit();
	}

}
