package ask.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.TeacherHomePage;
import ask.pages.UserDetailsPage;
import ask.pages.UsersManagementPage;

public class UsersManagementTest extends Base {
	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	UsersManagementPage usersManagementPage;
	UserDetailsPage userDetailsPage;
	@BeforeMethod
	public void setUp() throws IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();		
		loginPage.login(prop.getProperty("teacherEmail"), prop.getProperty("teacherPassword"));
		teacherHomePage=new TeacherHomePage();
		teacherHomePage.clickUsersManagementLink();
		usersManagementPage=new UsersManagementPage();
		userDetailsPage=new UserDetailsPage();
	}
	
	@Test
	public void deleteUser() throws InterruptedException {
		usersManagementPage.deleteStudents();
		
	}
	
	
	@AfterMethod(enabled=false)
	public void tearDown() {
		driver.quit();
	}

}
