package ask.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
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

	@Test(enabled=true)
	public void setUp() throws IOException, InterruptedException {
		
		
		browserInit();
		
		driver.get("https://generator.email/inbox1/");
		
		String email = driver.findElement(By.xpath("//div[@id='newselect']/../..//following-sibling::b//span"))
				.getText();
		
		launchApp();
		Thread.sleep(2000);
		LoginPage loginPage = new LoginPage();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Register Now']/..")));
		loginPage.clickRegisterNowButton();
		RegistrationPage registrationPage = new RegistrationPage();
		registrationPage.enterEmail(email);
		Thread.sleep(3000);
		registrationPage.enterFirstName(prop.getProperty("studentFirstName"));
		registrationPage.enterLastName(prop.getProperty("studentLastName"));
		registrationPage.enterGroupCode(prop.getProperty("group"));
		registrationPage.enterPassword(prop.getProperty("studentPassword"));
		registrationPage.enterConfirmedPassword(prop.getProperty("confirmedStudentPassword"));		
		registrationPage.clickRegisterMeButton();
		
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
		
		try {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Confirm email address']")));		
		driver.findElement(By.xpath("//a[text()='Confirm email address']")).click();
		//Thread.sleep(2000);		
		Util.switchingsBetweenWindows();
		YourAccountActivatedPage yourAccountActivatedPage=new YourAccountActivatedPage();
		sa.assertTrue(yourAccountActivatedPage.getYouAccountWasActivatedText(), "Failed");
		sa.assertTrue(yourAccountActivatedPage.getSuccessNowYouCanUseTheSystemText(), "Failed");
		yourAccountActivatedPage.clickLoginWithCredentialsButton();		
		loginPage.login(email, prop.getProperty("confirmedStudentPassword"));
		StudentHomePage studentHomePage = new StudentHomePage();
		Assert.assertTrue(studentHomePage.getStudentName(prop.getProperty("studentFirstName"), prop.getProperty("studentLastName")));
		Assert.assertTrue(studentHomePage.getStudentLabel());
		Assert.assertEquals(studentHomePage.getCurrentUrl(), prop.getProperty("studentHomePageURL"));
		sa.assertAll();}
		catch(TimeoutException e) {
			driver.get("https://generator.email/inbox1/");
			
			String email1 = driver.findElement(By.xpath("//div[@id='newselect']/../..//following-sibling::b//span"))
					.getText();
			
			launchApp();
			Thread.sleep(2000);
			try {WebDriverWait wait1=new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Register Now']/..")));
			loginPage.clickRegisterNowButton();
			
			registrationPage.enterEmail(email1);}
			catch(StaleElementReferenceException e1) {
				WebDriverWait wait1=new WebDriverWait(driver, 10);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Register Now']/..")));
				loginPage.clickRegisterNowButton();
				
				registrationPage.enterEmail(email1);
				Thread.sleep(3000);
				registrationPage.enterFirstName(prop.getProperty("studentFirstName"));
				registrationPage.enterLastName(prop.getProperty("studentLastName"));
				registrationPage.enterGroupCode(prop.getProperty("group"));
				registrationPage.enterPassword(prop.getProperty("studentPassword"));
				registrationPage.enterConfirmedPassword(prop.getProperty("confirmedStudentPassword"));		
				registrationPage.clickRegisterMeButton();
				
				Thread.sleep(3000);
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
				loginPage.login(email, prop.getProperty("confirmedStudentPassword"));
				StudentHomePage studentHomePage = new StudentHomePage();
				Assert.assertTrue(studentHomePage.getStudentName(prop.getProperty("studentFirstName"), prop.getProperty("studentLastName")));
				Assert.assertTrue(studentHomePage.getStudentLabel());
				Assert.assertEquals(studentHomePage.getCurrentUrl(), prop.getProperty("studentHomePageURL"));
				sa.assertAll();
			}
			
		}
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
	@AfterMethod(enabled=false)
	public void tearDown() {
		driver.quit();
	}

}
