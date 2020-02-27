package ask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ask.base.Base;

public class RegistrationPage extends Base {
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
public String getRegistrationPageUrl() {
String 	registrationPageUrl=driver.getCurrentUrl();
return registrationPageUrl;
}	
	@FindBy(xpath="//h4[text()='Registration']")
	WebElement registrationLabel;
		
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstNameField;
	
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);		
	}
	
	@FindBy(xpath="//input[@placeholder='First Name']/../../following-sibling::div[2]//div//mat-error[text()='Whitespaces are not allowed']")
	WebElement firstNameWhitespacesNotAallowedError;
	
	@FindBy(xpath="//input[@placeholder='First Name']/../../following-sibling::div[2]//div//mat-error")
	WebElement firstNameIsRequiredError;	
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastNameField;
	
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);		
	}
	
	@FindBy(xpath="//input[@placeholder='Last Name']/../../following-sibling::div[2]//div//mat-error[text()='Whitespaces are not allowed']")
	WebElement lastNameWhitespacesNotAallowedError;
	
	@FindBy(xpath="//input[@placeholder='Last Name']/../../following-sibling::div[2]//div//mat-error")
	WebElement lastNameIsRequiredError;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement emailField;
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);		
	}
	
	@FindBy(xpath="//input[@placeholder='Email']/../../following-sibling::div[2]//div//mat-error[text()='Should be a valid email address']")
	WebElement shouldBeValidEmailError;
	
	@FindBy(xpath="//input[@placeholder='Email']/../../following-sibling::div[2]//div//mat-error")
	WebElement emailIsRequiredError;
		
	@FindBy(xpath="//input[@placeholder='Group Code']")
	WebElement groupCodeField;
	
	public void enterGroupCode(String groupCode) {
		groupCodeField.sendKeys(groupCode);		
	}
	
	
	@FindBy(xpath="//input[@placeholder='Group Code']/../../following-sibling::div[2]//div//mat-error")
	WebElement groupCodeIsRequiredError;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passwordField;
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);		
	}
	
	@FindBy(xpath="//input[@placeholder='Password']/../../following-sibling::div[2]//div//mat-error")
	WebElement passwordIsRequiredError;
	
	@FindBy(xpath="//input[@placeholder='Password']/../../following-sibling::div[2]//div//mat-error[text()='Whitespaces are not allowed']")
	WebElement passwordWhitespacesNotAallowedError;
	
	@FindBy(xpath="//input[@placeholder='Password']/../../following-sibling::div[2]//div//mat-error[text()='Should be at least 5 characters']")
	WebElement passwordSouldBe5CharactersError;	
		
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	WebElement confirmPasswordField;
	
	public void enterConfirmedPassword(String confirmedPassword) {
		confirmPasswordField.sendKeys(confirmedPassword);		
	}
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']/../../following-sibling::div[2]//div//mat-error")
	WebElement confirmPasswordIsRequiredError;
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']/../../following-sibling::div[2]//div//mat-error[text()='Entered passwords should match']")
	WebElement enteredPasswordsShouldMatchError;
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']/../../following-sibling::div[2]//div//mat-error[text()='Whitespaces are not allowed']")
	WebElement confirmPasswordWhitespacesNotAallowedError;
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']/../../following-sibling::div[2]//div//mat-error[text()='Should be at least 5 characters']")
	WebElement confirmPasswordSouldBe5CharactersError;
			
	@FindBy(xpath="//span[text()='Register Me']/..")
	WebElement registerMeButton;
	
	public RegistrationConfirmationPage clickRegisterMeButton() {
		registerMeButton.click();
		return new RegistrationConfirmationPage();
	}
	
	@FindBy(xpath="//span[text()='Back to Login']/..")
	WebElement backToLoginButton;
	

}
