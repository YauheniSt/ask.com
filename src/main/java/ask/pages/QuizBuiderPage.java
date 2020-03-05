package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	@FindBy(xpath = "//input[@placeholder='Title Of The Quiz *']")
	WebElement titleOfQuizField;

	public void entertitleOfQuiz(String quizTitle) {
		titleOfQuizField.sendKeys(quizTitle);
	}

	public String getQuizBuiderPageUrl() {
		String quizBuiderPageUrl = driver.getCurrentUrl();
		return quizBuiderPageUrl;

	}

	public void clickAddOptionButton(String question) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//mat-panel-title[contains(text(),'"
				+ question + "')]/.. /..//following-sibling::div//span[contains(text(),'Add Option')]/..")));

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

	@FindBy(xpath = "//mat-icon[text()='add_circle']/../..")
	WebElement addQuestionButton;

	public void clickAddQuestionButton() {
		addQuestionButton.click();
	}

	@FindBy(xpath = "//mat-panel-title[contains(text(),'new empty question')]/../..//following-sibling::div//div[contains(text(),'Textual')]")
	WebElement textualQuestionType;

	public void selectTextualQuestionType() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(textualQuestionType));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", textualQuestionType);

	}

	@FindBy(xpath = "//mat-panel-title[contains(text(),'new empty question')]/../..//following-sibling::div//div[contains(text(),'Single-Choice')]")
	WebElement singleChoiseQuestionType;

	public void selectSingleChoiseQuestionType() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(singleChoiseQuestionType));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", singleChoiseQuestionType);

	}

	@FindBy(xpath = "//mat-panel-title[contains(text(),'new empty question')]/../..//following-sibling::div//div[contains(text(),'Multiple-Choice')]")
	WebElement multipleChoiseQuestionType;

	public void selectMultipleChoiseQuestionType() {

		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(multipleChoiseQuestionType));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", multipleChoiseQuestionType);
	}

	@FindBy(xpath = "//mat-panel-title[contains(text(),'new empty question')]/../..//following-sibling::div//textarea[@formcontrolname='question']")
	WebElement questionField;

	public void enterQuestion(String question) {
		questionField.sendKeys(question);
	}

	public void enterOption1(String question, String singleChoiseOption1) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + question
				+ "')]/../..//following-sibling::div//textarea[@placeholder='Option 1*']"))
				.sendKeys(singleChoiseOption1);
	}

	public void checkCorrectOptionMultipleChoiseQuestionType(String question, int number) {
		driver.findElement(By.xpath(
				"//mat-panel-title[contains(text(),'"+question+"')]/../..//following-sibling::div//textarea[@placeholder='Option "+number+"*']/../../../..//preceding-sibling::mat-checkbox//label//div"))
				.click();
	}

	public void enterOption2(String question, String singleChoiseOption2) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + question
				+ "')]/../..//following-sibling::div//textarea[@placeholder='Option 2*']"))
				.sendKeys(singleChoiseOption2);
	}

	public void enterOption1multipleChoiseQuestion(String question, String multipleChoisQuestionOption1) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + question
				+ "')]/../..//following-sibling::div//textarea[@placeholder='Option 1*']"))
				.sendKeys(multipleChoisQuestionOption1);
	}

	public void enterOption2multipleChoiseQuestion(String question, String multipleChoisQuestionOption2) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + question
				+ "')]/../..//following-sibling::div//textarea[@placeholder='Option 2*']"))
				.sendKeys(multipleChoisQuestionOption2);
	}

	public void enterOption3multipleChoiseQuestion(String question, String multipleChoisQuestionOption3) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + question
				+ "')]/../..//following-sibling::div//textarea[@placeholder='Option 3*']"))
				.sendKeys(multipleChoisQuestionOption3);
	}

	public void enterOption4multipleChoiseQuestion(String question, String multipleChoisQuestionOption4) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + question
				+ "')]/../..//following-sibling::div//textarea[@placeholder='Option 4*']"))
				.sendKeys(multipleChoisQuestionOption4);
	}

	public void enterOption5multipleChoiseQuestion(String question, String multipleChoisQuestionOption5) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + question
				+ "')]/../..//following-sibling::div//textarea[@placeholder='Option 5*']"))
				.sendKeys(multipleChoisQuestionOption5);
	}

	public void enterOption6multipleChoiseQuestion(String question, String multipleChoisQuestionOption6) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + question
				+ "')]/../..//following-sibling::div//textarea[@placeholder='Option 6*']"))
				.sendKeys(multipleChoisQuestionOption6);
	}

	public void enterOption7multipleChoiseQuestion(String question, String multipleChoisQuestionOption7) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + question
				+ "')]/../..//following-sibling::div//textarea[@placeholder='Option 7*']"))
				.sendKeys(multipleChoisQuestionOption7);
	}

	public void selectOption2(String question) {
		driver.findElement(By.xpath("//mat-panel-title[contains(text(),'" + question
				+ "')]/../..//following-sibling::div//textarea[@placeholder='Option 2*']/../../../../..//div//div[2]"))
				.click();
	}

	@FindBy(xpath = "//span[contains(text(),'\"Show-Stopper\"')]/..//preceding-sibling::div")
	WebElement showStopperCheckBox;

	public void checkShowStopperCheckBox() {
		showStopperCheckBox.click();
	}
   @FindBy(xpath="//span[contains(text(),'Save')]/..")
   WebElement saveButton;
   
   public ListOfQuizzesPage clickSaveButton() {
	   saveButton.click();
	   return new ListOfQuizzesPage();
	   
   }
}