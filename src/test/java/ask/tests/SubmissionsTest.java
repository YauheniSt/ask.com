package ask.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ask.base.Base;
import ask.pages.AssessmentPage;
import ask.pages.AssignQuizPage;
import ask.pages.AssignmentsPage;
import ask.pages.GradePage;
import ask.pages.ListOfQuizzesPage;
import ask.pages.LoginPage;
import ask.pages.MyAssignmentsPage;
import ask.pages.QuizBuiderPage;
import ask.pages.StudentHomePage;
import ask.pages.SubmissionsPage;
import ask.pages.TeacherHomePage;


public class SubmissionsTest extends Base {

	StudentHomePage studentHomePage;
	MyAssignmentsPage myAssignmentsPage;
	AssessmentPage assessmentPage;
	AssignmentsPage assignmentsPage;
	AssignQuizPage assignQuizPage;
	QuizBuilderTest quizBuilderTest;
	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	ListOfQuizzesPage listOfQuizzes;
	QuizBuiderPage quizBuiderPage;
	SubmissionsPage submissionsPage;
	SoftAssert sa;
	GradePage gradePage;

	@BeforeClass(alwaysRun = true)
	public void submitAssignment() throws InterruptedException, IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("teacherEmail"), prop.getProperty("teacherPassword"));
		teacherHomePage = new TeacherHomePage();
		teacherHomePage.clickQuizzesButton();
		listOfQuizzes = new ListOfQuizzesPage();
		listOfQuizzes.clickCreateNewQuizButton();
		QuizBuiderPage quizBuiderPage = new QuizBuiderPage();
		quizBuiderPage.entertitleOfQuiz(prop.getProperty("quizName"));
		quizBuiderPage.clickAddQuestionButton();
		quizBuiderPage.selectTextualQuestionType();
		quizBuiderPage.enterQuestion(prop.getProperty("textualQuestion"));
		quizBuiderPage.checkShowStopperCheckBox();
		quizBuiderPage.clickAddQuestionButton();
		quizBuiderPage.selectSingleChoiseQuestionType();
		quizBuiderPage.enterQuestion(prop.getProperty("singleChoiseQuestion"));
		quizBuiderPage.enterOption1(prop.getProperty("singleChoiseQuestion"), prop.getProperty("singleChoiseOption1"));
		quizBuiderPage.enterOption2(prop.getProperty("singleChoiseQuestion"), prop.getProperty("singleChoiseOption2"));
		quizBuiderPage.selectOption2(prop.getProperty("singleChoiseQuestion"));
		quizBuiderPage.clickAddQuestionButton();
		quizBuiderPage.selectMultipleChoiseQuestionType();
		quizBuiderPage.enterQuestion(prop.getProperty("multipleChoisQuestion"));
		quizBuiderPage.enterOption1multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"),
				prop.getProperty("multipleChoisQuestionOption1"));
		quizBuiderPage.enterOption2multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"),
				prop.getProperty("multipleChoisQuestionOption2"));
		quizBuiderPage.clickAddOptionButton(prop.getProperty("multipleChoisQuestion"));
		quizBuiderPage.enterOption3multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"),
				prop.getProperty("multipleChoisQuestionOption3"));
		quizBuiderPage.clickAddOptionButton(prop.getProperty("multipleChoisQuestion"));
		quizBuiderPage.enterOption4multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"),
				prop.getProperty("multipleChoisQuestionOption4"));
		quizBuiderPage.clickAddOptionButton(prop.getProperty("multipleChoisQuestion"));
		quizBuiderPage.enterOption5multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"),
				prop.getProperty("multipleChoisQuestionOption5"));
		quizBuiderPage.clickAddOptionButton(prop.getProperty("multipleChoisQuestion"));
		quizBuiderPage.enterOption6multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"),
				prop.getProperty("multipleChoisQuestionOption6"));
		quizBuiderPage.clickAddOptionButton(prop.getProperty("multipleChoisQuestion"));
		quizBuiderPage.enterOption7multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"),
				prop.getProperty("multipleChoisQuestionOption7"));
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 1);
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 2);
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 3);
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 4);
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 5);
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 6);
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 7);
		quizBuiderPage.clickSaveButton();
		Thread.sleep(3000);
		teacherHomePage.clickAssignmentsLink();
		assignmentsPage = new AssignmentsPage();
		assignmentsPage.clickCreateNewAssignmentButton();
		assignQuizPage = new AssignQuizPage();
		assignQuizPage.clickGroupFilterButton();
		assignQuizPage.selectGroupFromList(prop.getProperty("group"));
		Thread.sleep(3000);
		assignQuizPage.checkStuden(prop.getProperty("group"));
		assignQuizPage.clickSelectQuizToAssignField();
		assignQuizPage.selectQuizToAssign(prop.getProperty("quizName"));
		assignQuizPage.clickGiveAssignmentButton();
		teacherHomePage.clickLogOutButton();
		Thread.sleep(1000);
		teacherHomePage.clickConfirmLogOutButton();
		Thread.sleep(1000);
		loginPage.login(prop.getProperty("studentEmail"), prop.getProperty("studentPassword"));
		studentHomePage=new StudentHomePage();
		studentHomePage.clickMyAssignmentsButton();
		
		myAssignmentsPage=new MyAssignmentsPage();
		
		myAssignmentsPage.clickGoToAssessmentButton(prop.getProperty("quizName"));
		assessmentPage=new AssessmentPage();
		assessmentPage.enterAnswerToTextQuestion(prop.getProperty("textualQuestion"), "A set of APIs");
		assessmentPage.selectCorrectOptionSingleChoiseQuestion(prop.getProperty("singleChoiseQuestion"),
				prop.getProperty("singleChoiseOption2"));
		assessmentPage.checkCorrectOptionMultipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"),
				prop.getProperty("multipleChoisQuestionOption1"));
		assessmentPage.clickSubmitMyAnswersButton(prop.getProperty("quizName"));
		assessmentPage.clickSubmitSuccessButton();
		driver.quit();

	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("teacherEmail"), prop.getProperty("teacherPassword"));
		teacherHomePage=new TeacherHomePage();
		teacherHomePage.clickSubmissionsLink();
		submissionsPage = new SubmissionsPage();
		sa=new SoftAssert();
		gradePage=new GradePage();
	}

	@Test(groups= {"Acceptance"})
	public void verifySubmissionDisplayed() {
		
		submissionsPage.selectSubmissinFromList(prop.getProperty("group"), prop.getProperty("studentFirstName"),
				prop.getProperty("studentLastName"), prop.getProperty("quizName"));
		sa.assertTrue(gradePage.getQuizName(prop.getProperty("quizName")), "Quiz name is incorrect");
		sa.assertTrue(gradePage.getStudentName(prop.getProperty("studentFirstName"), prop.getProperty("studentLastName")), "Student's name is not corerct");
		sa.assertTrue(gradePage.getGroupName(prop.getProperty("group")), "GroupName is not correct");
		sa.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();		
	}
	
	@AfterClass
	public void deleteQuizzes() throws IOException, InterruptedException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("teacherEmail"), prop.getProperty("teacherPassword"));
		teacherHomePage = new TeacherHomePage();
		teacherHomePage.clickQuizzesButton();
		listOfQuizzes=new ListOfQuizzesPage();
		listOfQuizzes.deleteAllQuizzes();
		driver.quit();
	}
}
