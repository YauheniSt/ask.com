package ask.pages;
import ask.base.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MyAssignmentsPage extends Base {
	public MyAssignmentsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getMyAssignmentsPageUrl() {
	String	myAssignmentsPageUrl=driver.getCurrentUrl();
	return myAssignmentsPageUrl;
	}
	
	public boolean getQuizNameAssignedToStudent(String quizName) {
		driver.findElement(By.xpath("//td[contains(text(),'"+quizName+"')]")).isDisplayed();
		return true;
	}


	public void clickGoToAssessmentButton(String quizName) {
		driver.findElement(By.xpath("//td[contains(text(),'"+quizName+"')]/..//button")).click();
	}
}
