package ask.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.MyGradesPage;
import ask.pages.StudentHomePage;
import junit.framework.Assert;

public class MyGradesTest extends Base {

	LoginPage loginPage;
	StudentHomePage studentHomePage;
	MyGradesPage myGradesPage;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("studentEmail"), prop.getProperty("studentPassword"));
		studentHomePage=new StudentHomePage();
		myGradesPage=new MyGradesPage();
		studentHomePage.clickMyGradesButton();
			}
	@Test(groups= {"Regression"})
	public void verifyStudentCanCheckGradeDetails() {
		myGradesPage.clickDetailsButton(prop.getProperty("quizName"));
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

	
	
}
