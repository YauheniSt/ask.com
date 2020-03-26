package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import ask.base.Base;

public class MyGradesPage extends Base {
	
	public MyGradesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getMyGradesPageUrl() {
	String myGradesPageUrl=	driver.getCurrentUrl();
	return myGradesPageUrl;
	}
	
	public void clickDetailsButton(String quizName) {
		WebElement detailsButton = driver
				.findElement(By.xpath("//t[text()='"+quizName+"']/..//span[contains(text(),'Details')]/.."));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", detailsButton);
	}
}
