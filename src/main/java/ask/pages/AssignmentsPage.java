package ask.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ask.base.Base;

public class AssignmentsPage extends Base {

	public AssignmentsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getAssignmentsPageUrl() {
		String assignmentsPageUrl = driver.getCurrentUrl();
		return assignmentsPageUrl;
	}

	@FindBy(xpath = "//span[contains(text(),'Create New Assignment')]/..")
	WebElement createNewAssignmentButton;

	public void clickCreateNewAssignmentButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", createNewAssignmentButton);
	}

	public boolean getAssignment(String quiz) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz: " + quiz + "')]")).isDisplayed();
		return true;
	}

	public void clickAssignment(String quiz) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//mat-panel-title[contains(text(),'Quiz: " + quiz + "')]/../..")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz: " + quiz + "')]/../..")));
	}

	public boolean verifyStudentName(String studentFirstName, String studentLastName) {
		driver.findElement(By.xpath("//td[contains(text(),'" + studentFirstName + " " + studentLastName + "')]"))
				.isDisplayed();
		return true;
	}

	public boolean getPendingSubmission(String studentFirstName, String studentLastName) {
		driver.findElement(By.xpath("//td[contains(text(),'" + studentFirstName + " " + studentLastName
				+ "')]/..//span[contains(text(),'Pending Submission')]")).isDisplayed();
		return true;
	}
	
	public void deleteAllAssignments() throws InterruptedException {
	List <WebElement> dots=	driver.findElements(By.xpath("//mat-panel-title[contains(text(),'Assignment Date')]/..//mat-icon"));
	int numberOfAssignments=dots.size();
	for (int i=0; i<numberOfAssignments; i++) {
		try {
		dots.get(i).click();
		
		WebElement delete=driver.findElement(By.xpath("//span[text()='Delete Assignment']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", delete);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(3000);
		}
		catch (StaleElementReferenceException e) {
		WebElement dot=	driver.findElement(By.xpath("//mat-panel-title[contains(text(),'Assignment Date')]/..//mat-icon"));		
		dot.click();
		WebElement delete=driver.findElement(By.xpath("//span[text()='Delete Assignment']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", delete);		
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(3000);
		}
		
		
	}
	
	
	
	
	
	}
}
