package ask.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ask.base.Base;
import ask.pages.AssignmentsPage;
import ask.pages.ListOfQuizzesPage;
import ask.pages.LoginPage;
import ask.pages.TeacherHomePage;

public class AssignmentsTest extends Base {

	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	AssignmentsPage assignmentsPage;
	ListOfQuizzesPage listOfQuizzes;

	@BeforeMethod(alwaysRun=true)
	public void setUp() throws IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("teacherEmail"), prop.getProperty("teacherPassword"));
		teacherHomePage = new TeacherHomePage();
		assignmentsPage = new AssignmentsPage();
	}

	@Test(groups= {"Delete"})
	public void deleteAllAssignments() throws InterruptedException {
		teacherHomePage.clickAssignmentsLink();		
		assignmentsPage.deleteAllAssignments();

	}
	@AfterMethod(alwaysRun=true)
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
