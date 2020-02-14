package ask.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.TeacherHomePage;
import ask.pages.UserDetailsPage;
import ask.pages.UsersManagementPage;

public class UserDetailsTests extends Base {
	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	UsersManagementPage usersManagementPage;
	UserDetailsPage userDetailsPage;
	SoftAssert softAssert;
	
	@BeforeMethod
	public void setUp() throws IOException {
		browserInit();
		loginPage = new LoginPage();		
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		teacherHomePage=new TeacherHomePage();
		teacherHomePage.clickUsersManagementLink();
		usersManagementPage=new UsersManagementPage();
		usersManagementPage.selectIvanIvanovGroup1();
		userDetailsPage=new UserDetailsPage();
		softAssert=new SoftAssert();
	}
	@Test
	public void convertStudentToTeacherTest_658() throws InterruptedException {
		userDetailsPage.clickOptionsButton();
		userDetailsPage.clickChangeUsersRoleButton();
		userDetailsPage.clickSubmitChangeUsersRoleButton();	
		Thread.sleep(3000);
		softAssert.assertTrue(userDetailsPage.getTEACHERlabel(), "Teacher is not present");
		softAssert.assertAll();
		
	}

}
