package ask.tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.RegistrationConfirmationPage;
import ask.pages.RegistrationPage;
import ask.util.Util;

public class RegistrationTest extends Base {

	LoginPage loginPage;
	RegistrationPage registrationPage;
	Util util;
	String sheetName="Registration";
	RegistrationConfirmationPage registrationConfirmationPage;

	@BeforeMethod
	public void setUp() throws IOException {
		browserInit();
		loginPage = new LoginPage();
		util=new Util();
		util.waitForRegisterNowButton();
		loginPage.clickRegisterNowButton();		
		registrationPage=new RegistrationPage();
		registrationConfirmationPage=new RegistrationConfirmationPage();
		
	}
	@DataProvider
	public Object[][] getRegistrationData() {
	Object data[][]=util.getTestData(sheetName);
	return data;
	}
	
	@Test(dataProvider="getRegistrationData", priority=1)
	public void registrationTC(String firstName, String lastName, String email, String groupCode, String password, String confirmedPassword) throws InterruptedException {
		registrationPage.enterFirstName(firstName);
		registrationPage.enterLastName(lastName);
		registrationPage.enterEmail(email);
		registrationPage.enterGroupCode(groupCode);
		registrationPage.enterPassword(password);
		registrationPage.enterConfirmedPassword(confirmedPassword);
		registrationPage.clickRegisterMeButton();
		util.waitForRegistrationConfirmationPageURL();
		Assert.assertEquals(prop.getProperty("registrationConfirmationPage"), registrationConfirmationPage.getRegistrationConfirmationPageURL());
	}

}
