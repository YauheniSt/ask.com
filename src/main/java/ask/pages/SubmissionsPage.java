package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import ask.base.Base;

public class SubmissionsPage extends Base {
	public SubmissionsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getSubmissionsPageUrl() {
		String submissionsPageUrl = driver.getCurrentUrl();
		return submissionsPageUrl;
	}

	public void selectSubmissinFromList(String group, String firstName, String lastName, String quizName) {
		driver.findElement(By.xpath(
				"//td[text()='"+group+"']//following-sibling::td[text()='"+firstName+" "+lastName+"']//following-sibling::td[text()='"+quizName+"']/..//span[contains(text(),'Grade')]/.."))
				.click();
	}
}
