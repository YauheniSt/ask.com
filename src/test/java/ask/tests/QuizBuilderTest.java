package ask.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ask.base.Base;
import ask.pages.ListOfQuizzesPage;
import ask.pages.LoginPage;
import ask.pages.QuizBuiderPage;
import ask.pages.TeacherHomePage;
import ask.util.Util;

public class QuizBuilderTest extends Base {
	
	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
	ListOfQuizzesPage listOfQuizzes;
	QuizBuiderPage quizBuiderPage;
	Util util;
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() throws IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("teacherEmail"), prop.getProperty("teacherPassword"));
		teacherHomePage = new TeacherHomePage();
		teacherHomePage.clickQuizzesButton();
		listOfQuizzes=new ListOfQuizzesPage();
		listOfQuizzes.clickCreateNewQuizButton();
		quizBuiderPage=new QuizBuiderPage();
	}
	
	@Test(groups= {"Acceptance"})
	public void createNewQuizTest() throws InterruptedException {
		
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
		Thread.sleep(3000);
		Assert.assertEquals(listOfQuizzes.getListOfQuizzesPageURL(), prop.getProperty("listOfQuizzesPageUrl"));
		Assert.assertTrue(listOfQuizzes.getQuizFromList(prop.getProperty("quizName")));
	}
    
	@AfterMethod
	public void tearDown() {
		util=new Util();
	    util.quiteBrowser();
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
		util=new Util();
	    util.quiteBrowser();
	}
	
	
}
