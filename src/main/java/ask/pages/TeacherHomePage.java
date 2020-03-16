package ask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ask.base.Base;

public class TeacherHomePage extends Base {

	public TeacherHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='TEACHER'] ")
	WebElement teacherLable;

	@FindBy(xpath = "//h5[text()='Log Out']")
	WebElement logOutButton;

	@FindBy(xpath = "//span[text()='Log Out']//parent::button")
	WebElement confirmLogOutButton;
	
	@FindBy(xpath = "//h5[text()='Quizzes']/..//..//..")
	WebElement quizzesButton;
	
	public ListOfQuizzesPage clickQuizzesButton() {
		quizzesButton.click();
		return new ListOfQuizzesPage();
		
	}

	public String getCurrentUrl() {
		String teacherHomePageURL = driver.getCurrentUrl();
     return teacherHomePageURL;
	}

	public void clickConfirmLogOutButton() {
		confirmLogOutButton.click();

	}

	public void clickLogOutButton() {
		logOutButton.click();

	}

	public boolean getTeacherLabel() {
		teacherLable.isDisplayed();
		return true;
	}

	@FindBy(xpath = "//h5[contains(text(),'Management')]/../../..")
	WebElement usersManagementLink;

	public UsersManagementPage clickUsersManagementLink() {
		usersManagementLink.click();
		return new UsersManagementPage();
	}
	@FindBy(xpath = "//h5[text()='Assignments']/../../..")
	WebElement assignmentsLink;
	
	public AssignQuizPage clickAssignmentsLink() {
		assignmentsLink.click();
		return new AssignQuizPage();
	}
	@FindBy(xpath="//h5[text()='Submissions']/../../..")
	WebElement submissionsLink;
	
	public SubmissionsPage clickSubmissionsLink() {
		submissionsLink.click();
		return new SubmissionsPage();
	}
	
	
}
