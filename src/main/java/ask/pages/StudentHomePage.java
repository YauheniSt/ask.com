package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ask.base.Base;

public class StudentHomePage extends Base {
	
	public StudentHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[text()='STUDENT']")
	WebElement studentLabel;
	
	public boolean getStudentLabel() {
		studentLabel.isDisplayed();
		return true;
	}
	
  public boolean getStudentName(String firstName, String lastName) {
	  WebDriverWait wait=new WebDriverWait(driver, 3);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='"+firstName+" "+lastName+"']")));
	  
	  driver.findElement(By.xpath("//h3[text()='"+firstName+" "+lastName+"']")).isDisplayed();
	  return true;
  }
	
  public String getCurrentUrl() {
		String teacherHomePageURL = driver.getCurrentUrl();
   return teacherHomePageURL;
	}

	
	
	
}
