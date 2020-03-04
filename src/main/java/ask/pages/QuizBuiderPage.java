package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ask.base.Base;

public class QuizBuiderPage extends Base {

	public QuizBuiderPage() {
		PageFactory.initElements(driver, this);
	}

	public String getQuizBuiderPageUrl() {
		String quizBuiderPageUrl = driver.getCurrentUrl();
		return quizBuiderPageUrl;

	}

	@FindBy(xpath = "//input[@placeholder='Title Of The Quiz *']")
	WebElement titleOfQuizField;

	public void entertitleOfQuiz(String quizTitle) {
		titleOfQuizField.sendKeys(quizTitle);
	}

	@FindBy(xpath = "//mat-error[text()='This field is required']")
	WebElement titleOfQuizFieldRequired;

	public boolean getTitleOfQuizFieldRequiredError() {
		titleOfQuizFieldRequired.isDisplayed();
		return true;
	}

	@FindBy(xpath = "//span[contains(text(),'Back To Quizzes List')]/..")
	WebElement backToQuizButton;
	
	public void clickBackToQuizButton() {
		backToQuizButton.click();
	}
	
	@FindBy(xpath="//mat-icon[text()='add_circle']/../..")
	WebElement addQuestionButton;
	
	public void clickAddQuestionButton() {
		addQuestionButton.click();
	}
	
	@FindBy(xpath="//div[contains(text(),'Textual')]/../..")
	WebElement textualRadioButton;
	
	public void selectTextualQuestionType() {
		WebDriverWait wait=new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Textual')]/../..")));
		textualRadioButton.click();
	}
	
	@FindBy(xpath="//textarea")
	WebElement questionField;
	
	public void enterQuestion(String question) {
		questionField.sendKeys(question);
	}
	
	@FindBy(xpath="//span[contains(text(),'\"Show-Stopper\"')]/..//preceding-sibling::div")
	WebElement showStopperCheckBox;
	
	public void checkShowStopperCheckBox() {
		showStopperCheckBox.click();
	}
	

}
