package ask.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ask.base.Base;
import ask.pages.ListOfQuizzesPage;
import ask.pages.LoginPage;
import ask.pages.TeacherHomePage;

public class ListOfQuizzesTest extends Base {

	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	ListOfQuizzesPage listOfQuizzes;

	@BeforeMethod
	public void setUp() throws IOException {
		browserInit();
		loginPage = new LoginPage();
		loginPage.login("stashaniny@gmail.com", "12345");
		teacherHomePage = new TeacherHomePage();
		teacherHomePage.clickQuizzesButton();
		listOfQuizzes=new ListOfQuizzesPage();
	}
	@Test
	public void verifyQuizName() {
		listOfQuizzes.selectQuizFromList(prop.getProperty("quizName"));
	}

	@AfterMethod(enabled=true)
	public void tearDown() {
		driver.quit();
	}

}
