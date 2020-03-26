package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ask.base.Base;

public class AssessmentPage extends Base {
	public AssessmentPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterAnswerToTextQuestion(String question, String answer) {
		driver.findElement(By.xpath("//h3[text()='" + question + "']/..//textarea")).sendKeys(answer);
	}

	public void selectCorrectOptionSingleChoiseQuestion(String question, String correctOption) {
		driver.findElement(By.xpath("//h3[text()='" + question + "']/..//div[contains(text(),'" + correctOption
				+ "')]//preceding-sibling::div//div")).click();
	}

	public void checkCorrectOptionMultipleChoiseQuestion(String question, String correctOption) {
		driver.findElement(By.xpath("//h3[text()='" + question + "']/..//span[contains(text(),'" + correctOption
				+ "'  )]//preceding-sibling::div")).click();
	}

	public void clickSubmitMyAnswersButton(String quizName) {
		driver.findElement(By.xpath("//h4[text()='" + quizName + "']/..//button")).click();
	}

	public void clickSubmitSuccessButton() {
		driver.findElement(By.xpath("//span[text()='Ok']/..")).click();
	}

	public boolean getSuccessMessage() {
		driver.findElement(By.xpath("//h1[text()='Success!']")).isDisplayed();
		return true;
	}

	public boolean getSubmissionAcceptedMessage() {
		driver.findElement(By.xpath(
				"//p[text()='Your submission has been accepted. You might track your results on \"My Grades\" page.']"))
				.isDisplayed();
		return true;
	}
}
