package ask.tests;

import java.io.IOException;

import org.testng.Assert;
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

	@BeforeMethod(alwaysRun=true)
	public void setUp() throws IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("teacherEmail"), prop.getProperty("teacherPassword"));
		teacherHomePage = new TeacherHomePage();
		teacherHomePage.clickQuizzesButton();
		listOfQuizzes=new ListOfQuizzesPage();
		
	}
	@Test
	public void verifyQuizName() {
		listOfQuizzes.selectQuizFromList(prop.getProperty("quizName"));
	}
	
	@Test
	public void verifyQuizBuiderPageUrl() {
		listOfQuizzes.clickCreateNewQuizButton();
		Assert.assertEquals(listOfQuizzes.getListOfQuizzesPageURL(), prop.getProperty("quizBuiderPageUrl"));
	}
	 @Test(groups= {"Delete"})
	 public void verifyAllQuizzesCanBeDeleted() throws InterruptedException {
		 teacherHomePage.clickQuizzesButton();
		 listOfQuizzes.deleteAllQuizzes();
	 }
	

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}
