package ask.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.MyGradesPage;
import ask.pages.StudentHomePage;


public class StudentHomePageTest extends Base {

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
			}
	@Test(groups= {"Acceptance"})
	public void verifyStudentCanCheckGrades() {
		studentHomePage.clickMyGradesButton();
		Assert.assertEquals(myGradesPage.getMyGradesPageUrl(), prop.getProperty("myGradesPageUrl"));
	}
	
	@Test(groups= {"Acceptance"})
	public void verifyStudentCanCheckGrades1() {
		studentHomePage.clickMyGradesButton();
		Assert.assertEquals(myGradesPage.getMyGradesPageUrl(), prop.getProperty("myGradesPageUrl"));
	}
	
}
