package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ask.base.Base;

public class StudentHomePage extends Base {

	public StudentHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[text()='Log Out']")
	WebElement logOutButton;

	@FindBy(xpath = "//span[text()='Log Out']//parent::button")
	WebElement confirmLogOutButton;

	public void clickConfirmLogOutButton() {
		confirmLogOutButton.click();
	}

	public void clickLogOutButton() {
		JavascriptExecutor js= (JavascriptExecutor) driver; 
		js.executeAsyncScript("arguments[0].click();", confirmLogOutButton);
		
	}

	@FindBy(xpath = "//p[text()='STUDENT']")
	WebElement studentLabel;

	public boolean getStudentLabel() {
		studentLabel.isDisplayed();
		return true;
	}

	public boolean getStudentName(String firstName, String lastName) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='" + firstName + " " + lastName + "']")));

		driver.findElement(By.xpath("//h3[text()='" + firstName + " " + lastName + "']")).isDisplayed();
		return true;
	}

	public String getCurrentUrl() {
		String teacherHomePageURL = driver.getCurrentUrl();
		return teacherHomePageURL;
	}

	@FindBy(xpath = "//h5[text()='My Assignments']/../../..")
	WebElement myAssignmentsButton;

	public AssessmentPage clickMyAssignmentsButton() {
		myAssignmentsButton.click();
		return new AssessmentPage();
	}

	@FindBy(xpath = "//h5[text()='My Grades']/../../..")
	WebElement myGradesButton;

	public MyGradesPage clickMyGradesButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", myGradesButton);
        return new MyGradesPage();
	}

	public void clickDetailsButton() {
		WebElement detailsButton = driver
				.findElement(By.xpath("//td[text()='Web App']/..//span[contains(text(),'Details')]/.."));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", detailsButton);
	}
}
