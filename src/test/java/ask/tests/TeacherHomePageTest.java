package ask.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ask.base.Base;
import ask.pages.ListOfQuizzesPage;
import ask.pages.LoginPage;
import ask.pages.TeacherHomePage;

public class TeacherHomePageTest extends Base {
	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	ListOfQuizzesPage listOfQuizzesPage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		teacherHomePage=new TeacherHomePage();
	}
	
		@Test
		public void verifyListOfQuizzesPageUrl() throws InterruptedException {
		teacherHomePage.clickQuizzesButton();
		listOfQuizzesPage=new ListOfQuizzesPage();
		Thread.sleep(3000);
		Assert.assertEquals(listOfQuizzesPage.getListOfQuizzesPageURL(), prop.getProperty("listOfQuizzesPageUrl"));
		}
		
	

	
		
	

}
