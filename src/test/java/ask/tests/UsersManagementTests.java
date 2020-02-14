package ask.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.TeacherHomePage;
import ask.pages.UsersManagementPage;

public class UsersManagementTests extends Base {
	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	UsersManagementPage usersManagementPage;
	@BeforeMethod
	public void setUp() throws IOException {
		browserInit();
		loginPage = new LoginPage();		
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		teacherHomePage=new TeacherHomePage();
		teacherHomePage.clickUsersManagementLink();
		usersManagementPage=new UsersManagementPage();
	}
	

}
