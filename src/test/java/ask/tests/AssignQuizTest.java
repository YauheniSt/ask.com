package ask.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ask.base.Base;
import ask.pages.AssignQuizPage;
import ask.pages.AssignmentsPage;
import ask.pages.ListOfQuizzesPage;
import ask.pages.LoginPage;
import ask.pages.QuizBuiderPage;
import ask.pages.TeacherHomePage;

public class AssignQuizTest extends Base {

	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	AssignmentsPage assignmentsPage;
	AssignQuizPage assignQuizPage;

	@BeforeMethod
	public void setUp() throws IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("teacherEmail"), prop.getProperty("teacherPassword"));
		teacherHomePage = new TeacherHomePage();		
		teacherHomePage.clickAssignmentsLink();
		assignmentsPage=new AssignmentsPage();
		assignmentsPage.clickCreateNewAssignmentButton();
		assignQuizPage=new AssignQuizPage();
	}

	@Test
	public void assignQuizTC() throws InterruptedException {
		
		
		assignQuizPage.clickGroupFilterButton();
		assignQuizPage.selectGroupFromList(prop.getProperty("group"));
		assignQuizPage.checkStuden(prop.getProperty("group"));
		assignQuizPage.clickSelectQuizToAssignField();
		assignQuizPage.selectQuizToAssign(prop.getProperty("quizName"));
		assignQuizPage.clickGiveAssignmentButton();
		Thread.sleep(3000);
		Assert.assertEquals(assignmentsPage.getAssignmentsPageUrl(), prop.getProperty("assignmentsPageURL"));
		Assert.assertTrue(assignmentsPage.getAssignment(prop.getProperty("quizName")));
		assignmentsPage.clickAssignment(prop.getProperty("quizName"));
		Assert.assertTrue(assignmentsPage.verifyStudentName(prop.getProperty("studentFirstName"), prop.getProperty("studentLastName")));
		Assert.assertTrue(assignmentsPage.getPendingSubmission(prop.getProperty("studentFirstName"), prop.getProperty("studentLastName")));
		
	}
}
