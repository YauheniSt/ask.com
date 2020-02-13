package ask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ask.base.Base;

public class LoginPage extends Base {

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@formcontrolname='email']")
	WebElement emailField;
	@FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement singUpButton;
	@FindBy(xpath = "//mat-error[text()='This field is required']")
	WebElement errorMessageRequiredField;
	@FindBy(xpath = "//div[text()='Authentication failed. User not found or password does not match']")
	WebElement authenticationFailed;
	
	public boolean getAuthenticationFailed() {
		authenticationFailed.isDisplayed();
		return true;
	}

	public boolean getErrorMessageRequiredField() {
		errorMessageRequiredField.isDisplayed();
		return true;
	}

	public TeacherHomePage login (String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		singUpButton.click();
		return new TeacherHomePage();
	}

}
