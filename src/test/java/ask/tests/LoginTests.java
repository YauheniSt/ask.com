package ask.tests;

import java.io.IOException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ask.base.Base;
import ask.pages.LoginPage;
import ask.pages.TeacherHomePage;

public class LoginTests extends Base {

	LoginPage loginPage;
	TeacherHomePage teacherHomePage;
    SoftAssert sa;
	
    @BeforeMethod
	public void setUp() throws IOException {
		browserInit();
		loginPage = new LoginPage();
		teacherHomePage = new TeacherHomePage();
		sa=new SoftAssert();

	}

	@Test(dataProvider = "getData")
	public void loginAsTeacherTC(String email, String password) {

		loginPage.login(email, password);
		try {
			// Assert.assertTrue(loginPage.getErrorMessageRequiredField());
			Assert.assertTrue(loginPage.getAuthenticationFailed());
		} catch (NoSuchElementException As) {
			sa.assertEquals(teacherHomePage.getCurrentUrl(), prop.getProperty("techerHomePageURL"),"url is not correct" );
			Assert.assertTrue(teacherHomePage.getTeacherLabel());
			
			
		}
		sa.assertAll();
	}

	

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[3][2];
		data[0][0] = "stashaniny@gmail.com";
		data[0][1] = "12345";

		data[1][0] = "stashaniny@gmail.com";
		data[1][1] = "Tel605144";

		data[2][0] = "stashanin@gmail.com";
		data[2][1] = "12345";
		return data;
	}

	@AfterMethod(enabled=true)
	public void tearDown() {
		driver.quit();
	}

}
