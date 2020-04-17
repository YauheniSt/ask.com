package ask.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ask.base.Base;

public class RegistrationConfirmationPage extends Base {
	
	public RegistrationConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String getRegistrationConfirmationPageURL(String registrationConfirmationPage) {
		WebDriverWait wait=new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.urlToBe(registrationConfirmationPage));		
		String registrationConfirmationPageURL=driver.getCurrentUrl();
		return registrationConfirmationPageURL;
		
	}
	

	

}
