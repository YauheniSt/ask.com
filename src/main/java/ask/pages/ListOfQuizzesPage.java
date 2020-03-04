package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import ask.base.Base;

public class ListOfQuizzesPage extends Base {

	public ListOfQuizzesPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectQuizFromList(String nameOfQuiz) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + nameOfQuiz + "')]")).click();

	}
public String getListOfQuizzesPageURL() {
	String listOfQuizzesPageURL=driver.getCurrentUrl();
	return listOfQuizzesPageURL;
}
}
