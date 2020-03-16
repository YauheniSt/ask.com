package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ask.base.Base;

public class AssignQuizPage extends Base {
	public AssignQuizPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getAssignQuizPageUrl() {
	String url=	driver.getCurrentUrl();
	return url;
	}
	
	@FindBy(xpath="//mat-select[@placeholder='Group Filter']//div//div")
	WebElement groupFilterButton;
	
	public void clickGroupFilterButton() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", groupFilterButton);
		
	}
	public void selectGroupFromList(String group) {
		driver.findElement(By.xpath("//span[text()='All']/../..//mat-option//span[text()='"+group+"']")).click();	

	}
	
	public void checkStuden(String group) {
		driver.findElement(By.xpath("//span[contains(text(),'"+group+"')]/..//preceding-sibling::mat-pseudo-checkbox")).click();	

	}
	@FindBy(xpath="//span[contains(text(),'Select Quiz To Assign')]/..")
	WebElement selectQuizToAssignField;
	
	public void clickSelectQuizToAssignField() {
		selectQuizToAssignField.click();
	}	
	public void selectQuizToAssign(String quiz) {
		driver.findElement(By.xpath("//span[contains(text(),'"+quiz+"')]")).click();
	}
	@FindBy(xpath="//span[text()='Give Assignment']/..")
	WebElement giveAssignmentButton;
	
	public void clickGiveAssignmentButton() {
		giveAssignmentButton.click();
	}
	
	
	
}
