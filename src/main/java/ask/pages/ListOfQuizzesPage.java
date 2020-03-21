package ask.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ask.base.Base;

public class ListOfQuizzesPage extends Base {

	public ListOfQuizzesPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Create New Quiz']/..")
	WebElement createNewQuizButton;

	public QuizBuiderPage clickCreateNewQuizButton() {
		createNewQuizButton.click();
		return new QuizBuiderPage();
	}

	public void selectQuizFromList(String nameOfQuiz) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + nameOfQuiz + "')]")).click();

	}

	public boolean getQuizFromList(String nameOfQuiz) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + nameOfQuiz + "')]")).isDisplayed();
		return true;

	}

	public String getListOfQuizzesPageURL() {
		String listOfQuizzesPageURL = driver.getCurrentUrl();
		return listOfQuizzesPageURL;
	}

	public void deleteAllQuizzes() throws InterruptedException {

		List<WebElement> quizzes = driver.findElements(By.xpath("//mat-panel-title"));
		int numberOfQuizzes = quizzes.size();
		for (int i = 0; i < numberOfQuizzes; i++) {
			System.out.println(numberOfQuizzes);
			try {
				
				quizzes.get(i).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[text()='Delete']/..")).click();
				Thread.sleep(1000);
				WebElement confirmDeleteButton = driver.findElement(By.xpath(
						"//p[text()='Are you sure want to DELETE whole quiz? This action cannot be undone!']/../..//button[2]"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", confirmDeleteButton);

				Thread.sleep(3000);
			}

			catch (StaleElementReferenceException e) {

				WebElement quiz = driver.findElement(By.xpath("//mat-panel-title"));
				quiz.click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[text()='Delete']/..")).click();
				Thread.sleep(1000);
				WebElement confirmDeleteButton = driver.findElement(By.xpath(
						"//p[text()='Are you sure want to DELETE whole quiz? This action cannot be undone!']/../..//button[2]"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", confirmDeleteButton);

			}
			Thread.sleep(1000);
		}

	}
}
