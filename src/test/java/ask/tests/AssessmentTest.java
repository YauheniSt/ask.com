package ask.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.MyAssignmentsPage;
import ask.pages.AssessmentPage;
import ask.pages.StudentHomePage;
import junit.framework.Assert;


public class AssessmentTest extends Base {
	
	LoginPage loginPage;	
	StudentHomePage studentHomePage;
	MyAssignmentsPage myAssignmentsPage;
	AssessmentPage assessmentPage;
        
	@BeforeMethod
	public void setUp() throws IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("studentEmail"), prop.getProperty("studentPassword"));
		myAssignmentsPage=new MyAssignmentsPage();
		studentHomePage=new StudentHomePage();
		assessmentPage=new AssessmentPage();
        }
		@Test
		public void completeAssignment1() throws InterruptedException {
			studentHomePage.clickMyAssignmentsButton();
			Assert.assertEquals(prop.getProperty("myAssignmentUrl"), myAssignmentsPage.getMyAssignmentsPageUrl());
			myAssignmentsPage.clickGoToAssessmentButton(prop.getProperty("quizName"));
			assessmentPage.enterAnswerToTextQuestion(prop.getProperty("textualQuestion"), "A set of APIs");
			assessmentPage.selectCorrectOptionSingleChoiseQuestion(prop.getProperty("singleChoiseQuestion"), prop.getProperty("singleChoiseOption2"));
			assessmentPage.checkCorrectOptionMultipleChoiseQuestion(prop.getProperty("multipleChoisQuestion"), prop.getProperty("multipleChoisQuestionOption1"));
			assessmentPage.clickSubmitMyAnswersButton(prop.getProperty("quizName"));
			Assert.assertTrue(assessmentPage.getSuccessMessage());
			Assert.assertTrue(assessmentPage.getSubmissionAcceptedMessage());
			assessmentPage.clickSubmitSuccessButton();
			Assert.assertEquals(prop.getProperty("myAssignmentUrl"), myAssignmentsPage.getMyAssignmentsPageUrl());
			
		}
		


}
