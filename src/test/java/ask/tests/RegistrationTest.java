package ask.tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.RegistrationConfirmationPage;
import ask.pages.RegistrationPage;
import ask.util.Util;


public class RegistrationTest extends Base {

	static String sheetName = "Reg";
	LoginPage loginPage;
	RegistrationPage registrationPage;
	RegistrationConfirmationPage registrationConfirmationPage;

	@BeforeMethod
	public void set() throws IOException {
		browserInit();
		launchApp();
		loginPage = new LoginPage();
		loginPage.clickRegisterNowButton();
		registrationPage = new RegistrationPage();
		registrationConfirmationPage = new RegistrationConfirmationPage();
	}

	@Test(dataProvider = "getData")
	public void registration(String firstName, String lastName, String email, String groupCode, String password,
			String confirmedPassword) throws InterruptedException {
		registrationPage.registration(firstName, lastName, email, groupCode, password, confirmedPassword);
		if (firstName.isEmpty()) {
			Assert.assertTrue(registrationPage.getFirstNameIsRequired());
		} else if (lastName.equals("")) {
			Assert.assertTrue(registrationPage.getLastNameIsRequired());
		} else if (email.equals("")) {
			Assert.assertTrue(registrationPage.getEmailIsRequired());
		} else if (firstName.contains(" ")) {
			Assert.assertTrue(registrationPage.getFirstNameWhitespacesNotAallowedError());
		} else if (lastName.contains(" ")) {
			Assert.assertTrue(registrationPage.getLastNameWhitespacesNotAallowedError());
		} else if (password.length() < 5) {
			Assert.assertTrue(registrationPage.getPasswordSouldBe5CharactersError());
		} else if (!email.contains("@")) {
			Assert.assertTrue(registrationPage.getShouldBeValidEmailError());
		} else if (!password.equals(confirmedPassword)) {
			Assert.assertTrue(registrationPage.getEnteredPasswordsShouldMatchError());
		} else {
			Assert.assertEquals(
					registrationConfirmationPage
							.getRegistrationConfirmationPageURL(prop.getProperty("registrationConfirmationPage")),
					prop.getProperty("registrationConfirmationPage"));
		}

		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		Object[][] data = Util.dataGetting(sheetName);
		return data;
	}

	
	@AfterMethod(enabled = true)
	public void tearDown() {
		driver.quit();
	}

}
