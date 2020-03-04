package ask.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.RegistrationConfirmationPage;
import ask.pages.RegistrationPage;
import ask.pages.StudentHomePage;
import ask.pages.YourAccountActivatedPage;
import ask.util.Util;

public class RegistrationTest extends Base {

	@BeforeMethod
	public void set() {

	}

	@Test
	public void setUp() throws IOException, InterruptedException {
		String firstName = "Fedya";
		String lastName = "Belkin";
		String groupCode = "123";
		String password = "12345";
		String confirmedPassword = "12345";
		//open browser
		browserInit();
		//open email generator
		driver.get("https://generator.email/inbox1/");
		//get email
		String email = driver.findElement(By.xpath("//div[@id='newselect']/../..//following-sibling::b//span"))
				.getText();
		//open ask
		launchApp();
		Thread.sleep(2000);
		//click register me button
		LoginPage loginPage = new LoginPage();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Register Now']/..")));
		loginPage.clickRegisterNowButton();
		//fill out registration form and submit it
		RegistrationPage registrationPage = new RegistrationPage();
		registrationPage.enterEmail(email);
		registrationPage.enterFirstName(firstName);
		registrationPage.enterLastName(lastName);
		registrationPage.enterGroupCode(groupCode);
		registrationPage.enterPassword(password);
		registrationPage.enterConfirmedPassword(confirmedPassword);
		registrationPage.clickRegisterMeButton();
		
		//verify successfull registration page is landed
		Thread.sleep(3000);
		SoftAssert sa = new SoftAssert();
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage();
		sa.assertEquals(registrationConfirmationPage.getRegistrationConfirmationPageURL(),
				prop.getProperty("registrationConfirmationPage"),"registration confirmation url is incorrect");
		Thread.sleep(5000);
		//navigate to email generator web site
		Util.navigateBack3Times();
		//refresh the page in order to get confirmation of account activation
		Thread.sleep(3000);
		Util.refreshBrowser();			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Confirm email address']")));		
		driver.findElement(By.xpath("//a[text()='Confirm email address']")).click();
		//Thread.sleep(2000);		
		Util.switchingsBetweenWindows();
		YourAccountActivatedPage yourAccountActivatedPage=new YourAccountActivatedPage();
		sa.assertTrue(yourAccountActivatedPage.getYouAccountWasActivatedText(), "Failed");
		sa.assertTrue(yourAccountActivatedPage.getSuccessNowYouCanUseTheSystemText(), "Failed");
		yourAccountActivatedPage.clickLoginWithCredentialsButton();		
		loginPage.login(email, confirmedPassword);
		StudentHomePage studentHomePage = new StudentHomePage();
		Assert.assertTrue(studentHomePage.getStudentName(firstName, lastName));
		Assert.assertTrue(studentHomePage.getStudentLabel());
		Assert.assertEquals(studentHomePage.getCurrentUrl(), prop.getProperty("studentHomePageURL"));
		sa.assertAll();
	}

	/*
	 * @DataProvider public Object[][] getRegistrationData() { Object data[][] =
	 * util.getTestData(sheetName); return data; }
	 * 
	 * @Test(dataProvider = "getRegistrationData", priority = 1) public void
	 * registrationTC(String firstName, String lastName, String email, String
	 * groupCode, String password, String confirmedPassword) throws
	 * InterruptedException {
	 * 
	 * registrationPage.enterFirstName(firstName);
	 * registrationPage.enterLastName(lastName); registrationPage.enterEmail(email);
	 * registrationPage.enterGroupCode(groupCode);
	 * registrationPage.enterPassword(password);
	 * registrationPage.enterConfirmedPassword(confirmedPassword);
	 * registrationPage.clickRegisterMeButton();
	 * util.waitForRegistrationConfirmationPageURL();
	 * Assert.assertEquals(prop.getProperty("registrationConfirmationPage"),
	 * registrationConfirmationPage.getRegistrationConfirmationPageURL()); }
	 */

}
