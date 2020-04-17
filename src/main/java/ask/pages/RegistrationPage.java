package ask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ask.base.Base;

public class RegistrationPage extends Base {

	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	public String getRegistrationPageUrl() {
		String registrationPageUrl = driver.getCurrentUrl();
		return registrationPageUrl;
	}

	@FindBy(xpath = "//h4[text()='Registration']")
	WebElement registrationLabel;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	@CacheLookup
	WebElement firstNameField;

	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}

	@FindBy(xpath = "//input[@placeholder='First Name']/../../following-sibling::div[2]//div//mat-error[text()='Whitespaces are not allowed']")
	WebElement firstNameWhitespacesNotAallowedError;

	public boolean getFirstNameWhitespacesNotAallowedError() {
		firstNameWhitespacesNotAallowedError.isDisplayed();
		return true;
	}

	@FindBy(xpath = "//input[@placeholder='First Name']/../../following-sibling::div[2]//div//mat-error")
	WebElement firstNameIsRequiredError;

	public boolean getFirstNameIsRequired() {
		firstNameIsRequiredError.isDisplayed();
		return true;
	}

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	@CacheLookup
	WebElement lastNameField;

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	@FindBy(xpath = "//input[@placeholder='Last Name']/../../following-sibling::div[2]//div//mat-error[text()='Whitespaces are not allowed']")
	WebElement lastNameWhitespacesNotAallowedError;

	public boolean getLastNameWhitespacesNotAallowedError() {
		lastNameWhitespacesNotAallowedError.isDisplayed();
		return true;
	}

	@FindBy(xpath = "//input[@placeholder='Last Name']/../../following-sibling::div[2]//div//mat-error")
	WebElement lastNameIsRequiredError;

	public boolean getLastNameIsRequired() {
		lastNameIsRequiredError.isDisplayed();
		return true;
	}

	@FindBy(xpath = "//input[@placeholder='Email']")
	@CacheLookup
	WebElement emailField;

	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}

	@FindBy(xpath = "//input[@placeholder='Email']/../../following-sibling::div[2]//div//mat-error[text()='Should be a valid email address']")
	WebElement shouldBeValidEmailError;

	public boolean getShouldBeValidEmailError() {
		shouldBeValidEmailError.isDisplayed();
		return true;
	}

	@FindBy(xpath = "//input[@placeholder='Email']/../../following-sibling::div[2]//div//mat-error")
	WebElement emailIsRequiredError;

	public boolean getEmailIsRequired() {
		emailIsRequiredError.isDisplayed();
		return true;
	}

	@FindBy(xpath = "//input[@placeholder='Group Code']")
	@CacheLookup
	WebElement groupCodeField;

	public void enterGroupCode(String groupCode) {
		groupCodeField.sendKeys(groupCode);
	}

	@FindBy(xpath = "//input[@placeholder='Group Code']/../../following-sibling::div[2]//div//mat-error")
	WebElement groupCodeIsRequiredError;

	@FindBy(xpath = "//input[@placeholder='Password']")
	@CacheLookup
	WebElement passwordField;

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	@FindBy(xpath = "//input[@placeholder='Password']/../../following-sibling::div[2]//div//mat-error")
	WebElement passwordIsRequiredError;

	@FindBy(xpath = "//input[@placeholder='Password']/../../following-sibling::div[2]//div//mat-error[text()='Whitespaces are not allowed']")
	WebElement passwordWhitespacesNotAallowedError;

	@FindBy(xpath = "//input[@placeholder='Password']/../../following-sibling::div[2]//div//mat-error[text()='Too short. Should be at least 5 characters']")
	WebElement passwordSouldBe5CharactersError;

	public boolean getPasswordSouldBe5CharactersError() {
		passwordSouldBe5CharactersError.isDisplayed();
		return true;
	}

	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	@CacheLookup
	WebElement confirmPasswordField;

	public void enterConfirmedPassword(String confirmedPassword) {
		confirmPasswordField.sendKeys(confirmedPassword);
	}

	@FindBy(xpath = "//input[@placeholder='Confirm Password']/../../following-sibling::div[2]//div//mat-error")
	WebElement confirmPasswordIsRequiredError;

	@FindBy(xpath = "//input[@placeholder='Confirm Password']/../../following-sibling::div[2]//div//mat-error[text()='Entered passwords should match']")
	WebElement enteredPasswordsShouldMatchError;
	
	public boolean getEnteredPasswordsShouldMatchError() {		
		enteredPasswordsShouldMatchError.isDisplayed();
		return true;
	}

	@FindBy(xpath = "//input[@placeholder='Confirm Password']/../../following-sibling::div[2]//div//mat-error[text()='Whitespaces are not allowed']")
	WebElement confirmPasswordWhitespacesNotAallowedError;

	@FindBy(xpath = "//input[@placeholder='Confirm Password']/../../following-sibling::div[2]//div//mat-error[text()='Should be at least 5 characters']")
	WebElement confirmPasswordSouldBe5CharactersError;

	@FindBy(xpath = "//span[text()='Register Me']/..")
	@CacheLookup
	WebElement registerMeButton;

	public RegistrationConfirmationPage clickRegisterMeButton() {
		registerMeButton.click();
		return new RegistrationConfirmationPage();
	}

	@FindBy(xpath = "//span[text()='Back to Login']/..")
	WebElement backToLoginButton;

	public RegistrationConfirmationPage registration(String firstName, String lastName, String email, String groupCode,
			String password, String confirmedPassword) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		groupCodeField.sendKeys(groupCode);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(confirmedPassword);
		registerMeButton.click();
		return new RegistrationConfirmationPage();
	}

}
