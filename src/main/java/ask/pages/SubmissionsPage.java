package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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

	public GradePage selectSubmissinFromList(String group, String firstName, String lastName, String quizName) {
		try {
			driver.findElement(By.xpath("//td[text()='" + group + "']//following-sibling::td[text()='" + firstName + " "
					+ lastName + "']//following-sibling::td[text()='" + quizName
					+ "']/..//span[contains(text(),'Grade')]/..")).click();
		} catch (StaleElementReferenceException e) {
			
			driver.findElement(By.xpath("//td[text()='" + group + "']//following-sibling::td[text()='" + firstName + " "
					+ lastName + "']//following-sibling::td[text()='" + quizName
					+ "']/..//span[contains(text(),'Grade')]/..")).click();
		}
		return new GradePage();
	}
}
