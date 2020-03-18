package ask.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
	
	AssignmentsPage assignmentsPage;
	AssignQuizPage assignQuizPage;
	QuizBuilderTest quizBuilderTest;
	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	ListOfQuizzesPage listOfQuizzes;
	QuizBuiderPage quizBuiderPage;

	@BeforeClass
public void createQuiz() throws InterruptedException, IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("teacherEmail"), prop.getProperty("teacherPassword"));
		teacherHomePage = new TeacherHomePage();
		teacherHomePage.clickQuizzesButton();
		listOfQuizzes=new ListOfQuizzesPage();
		listOfQuizzes.clickCreateNewQuizButton();
		QuizBuiderPage quizBuiderPage=new QuizBuiderPage();		
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
		quizBuiderPage.enterOption1multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"), prop.getProperty("multipleChoisQuestionOption1"));
		quizBuiderPage.enterOption2multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"), prop.getProperty("multipleChoisQuestionOption2"));
		quizBuiderPage.clickAddOptionButton(prop.getProperty("multipleChoisQuestion"));
		quizBuiderPage.enterOption3multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"), prop.getProperty("multipleChoisQuestionOption3"));
		quizBuiderPage.clickAddOptionButton(prop.getProperty("multipleChoisQuestion"));
		quizBuiderPage.enterOption4multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"), prop.getProperty("multipleChoisQuestionOption4"));
		quizBuiderPage.clickAddOptionButton(prop.getProperty("multipleChoisQuestion"));
		quizBuiderPage.enterOption5multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"), prop.getProperty("multipleChoisQuestionOption5"));
		quizBuiderPage.clickAddOptionButton(prop.getProperty("multipleChoisQuestion"));
		quizBuiderPage.enterOption6multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"), prop.getProperty("multipleChoisQuestionOption6"));
		quizBuiderPage.clickAddOptionButton(prop.getProperty("multipleChoisQuestion"));
		quizBuiderPage.enterOption7multipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"), prop.getProperty("multipleChoisQuestionOption7"));
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 1);
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 2);
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 3);
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 4);
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 5);
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 6);
		quizBuiderPage.checkCorrectOptionMultipleChoiseQuestionType(prop.getProperty("multipleChoisQuestion"), 7);
		quizBuiderPage.clickSaveButton();
}
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
