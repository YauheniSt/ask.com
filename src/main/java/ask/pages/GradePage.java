package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import ask.base.Base;

public class GradePage extends Base {
	public GradePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean getQuizName(String quizName) {
		driver.findElement(By.xpath("//td[text()='Quiz:']//following-sibling::td[text()='" + quizName + "']"))
				.isDisplayed();
		return true;
	}

	public boolean getStudentName(String studentFirstName, String studentLastName) {
		driver.findElement(By.xpath("//td[text()='Student:']//following-sibling::td[text()='" + studentFirstName + " "
				+ studentLastName + "']")).isDisplayed();
		return true;
	}

	public boolean getGroupName(String group) {
		driver.findElement(By.xpath("//td[text()='Group:']//following-sibling::td[text()='" + group + "']"))
				.isDisplayed();
		return true;
	}

	public void gradeStudent(String textualQuestion, String commentToTextualAnswer, String singleChoiseQuestion,
			String commentToSingleChoiseAnswer, String multipleChoisQuestion, String commentToMultipleChoisAnswer,
			String teacherSummary) {
		driver.findElement(By.xpath("//h4[text()='" + textualQuestion + "']/..//textarea"))
				.sendKeys(commentToTextualAnswer);
		driver.findElement(By.xpath("//h4[text()='" + singleChoiseQuestion + "']/..//textarea"))
				.sendKeys(commentToSingleChoiseAnswer);
		driver.findElement(By.xpath("//h4[text()='" + multipleChoisQuestion + "']/..//textarea"))
				.sendKeys(commentToMultipleChoisAnswer);
		driver.findElement(By.xpath("//span[text()='Save']/../../..//textarea")).sendKeys(teacherSummary);
		driver.findElement(By.xpath("//span[text()='Save']")).click();
	}

}
