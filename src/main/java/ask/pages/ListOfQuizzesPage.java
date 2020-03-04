package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ask.base.Base;

public class ListOfQuizzesPage extends Base {

	public ListOfQuizzesPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Create New Quiz']/..")
	WebElement createNewQuizButton;
	
	public QuizBuiderPage clickCreateNewQuizButton() {
		createNewQuizButton.click();
		return new QuizBuiderPage();
	}
	

	public void selectQuizFromList(String nameOfQuiz) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + nameOfQuiz + "')]")).click();

	}
public String getListOfQuizzesPageURL() {
	String listOfQuizzesPageURL=driver.getCurrentUrl();
	return listOfQuizzesPageURL;
}
}
