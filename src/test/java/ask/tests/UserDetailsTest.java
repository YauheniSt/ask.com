package ask.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.TeacherHomePage;
import ask.pages.UserDetailsPage;
import ask.pages.UsersManagementPage;

public class UserDetailsTest extends Base {
	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	UsersManagementPage usersManagementPage;
	UserDetailsPage userDetailsPage;
	SoftAssert softAssert;

	@BeforeMethod
	public void setUp() throws IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("teacherEmail"), prop.getProperty("teacherPassword"));
		teacherHomePage = new TeacherHomePage();
		teacherHomePage.clickUsersManagementLink();
		usersManagementPage = new UsersManagementPage();

		usersManagementPage.selectStudent(prop.getProperty("group"), prop.getProperty("studentFirstName"),
				prop.getProperty("studentLastName"));
		userDetailsPage = new UserDetailsPage();
		softAssert = new SoftAssert();
	}

	@Test
	public void convertStudentToTeacherTest_658() throws InterruptedException {

		userDetailsPage.clickOptionsButton();
		userDetailsPage.clickChangeUsersRoleButton();
		userDetailsPage.clickSubmitChangeUsersRoleButton();
		// Thread.sleep(3000);
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// softAssert.assertTrue(userDetailsPage.getTEACHERlabel(), "Teacher is not
		// present");
		// softAssert.assertAll();
		Assert.assertTrue(userDetailsPage.getTEACHERlabel());
		teacherHomePage.clickLogOutButton();
		teacherHomePage.clickConfirmLogOutButton();

	}

	@Test
	public void verifyStudentCanBeDeleted() throws InterruptedException {

		userDetailsPage.deleteStudent();
		teacherHomePage.clickLogOutButton();
		Thread.sleep(2000);
		teacherHomePage.clickConfirmLogOutButton();
		loginPage.login(prop.getProperty("studentEmail"), prop.getProperty("studentPassword"));
		Assert.assertTrue(loginPage.getAuthenticationFailed());
		
		
	}

	@AfterMethod(enabled = true)
	public void tearDown() {
		driver.quit();
	}

}
