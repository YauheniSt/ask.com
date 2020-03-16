package ask.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ask.base.Base;

public class UserDetailsPage extends Base {
	public UserDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='mat-button-wrapper']//parent::button")
	WebElement optionsButton;
	@FindBy(xpath = "//mat-icon[text()='school']//parent::button")
	WebElement changeUsersRoleButton;
	@FindBy(xpath = "//span[text()='Change Role']")
	WebElement submitChangeUsersRoleButton;
	@FindBy(xpath = "//td[text()='STUDENT']")
	WebElement STUDENTlabel;
	@FindBy(xpath = "//td[text()='TEACHER']")
	WebElement TEACHERlabel;
	
	@FindBy(xpath = "//mat-icon[text()='delete']/..")
	WebElement deleteUserButton;
	
	public void clickDeleteUserButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deleteUserButton);
		
	}
	@FindBy(xpath = "//span[text()='Delete']/..")
	WebElement confirmDeleteUserButton;
	
	public void clickConfirmDeleteUserButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", confirmDeleteUserButton);

	}

	public boolean getTEACHERlabel() {
		TEACHERlabel.isDisplayed();
		return true;
	}

	public boolean getSTUDENTlabel() {
		//WebDriverWait w = new WebDriverWait(driver, 15);
		//w.until(ExpectedConditions.visibilityOf(STUDENTlabel));
		STUDENTlabel.isDisplayed();
		return true;
	}

	public void clickSubmitChangeUsersRoleButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submitChangeUsersRoleButton);

	}

	public void clickChangeUsersRoleButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", changeUsersRoleButton);

	}

	public void clickOptionsButton() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", optionsButton);

	}

}
