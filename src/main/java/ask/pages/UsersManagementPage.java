package ask.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ask.base.Base;

public class UsersManagementPage extends Base {

	public UsersManagementPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean getStudent(String group, String studentFirstName, String studentLastName) {
		WebElement student = driver.findElement(By.xpath("//h6[text()='Group: " + group + "']//preceding-sibling::h4[text()='"
				+ studentFirstName + " " + studentLastName + "']"));		
			student.isDisplayed();		
		return true;
	}
	
	

	public void selectStudent(String group, String studentFirstName, String studentLastName) {
		WebElement student = driver.findElement(By.xpath("//h6[text()='Group: " + group + "']//preceding-sibling::h4[text()='"
				+ studentFirstName + " " + studentLastName + "']"));
		student.click();
	}

	

	}

