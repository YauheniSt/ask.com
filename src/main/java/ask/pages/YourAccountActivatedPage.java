package ask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ask.base.Base;

public class YourAccountActivatedPage extends Base {

	public YourAccountActivatedPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[text()='You Account was Activated!']")
	WebElement youAccountWasActivatedText;
	
	@FindBy(xpath = "//p[contains(text(),'Success, now you can use the system!')]")
	WebElement successNowYouCanUseTheSystemText;
	
	@FindBy(xpath = "//span[contains(text(),'Login with Credentials')]")
	WebElement loginWithCredentialsButton;
	
	public LoginPage clickLoginWithCredentialsButton() {
		loginWithCredentialsButton.click();
		return new LoginPage();
		
	}
	
	
	
	
	
	public boolean getSuccessNowYouCanUseTheSystemText() {
		successNowYouCanUseTheSystemText.isDisplayed();
		return true;}

	public boolean getYouAccountWasActivatedText() {
		youAccountWasActivatedText.isDisplayed();
		return true;

	

	}

}
