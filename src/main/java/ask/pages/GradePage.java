package ask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import ask.base.Base;

public class GradePage extends Base{
public GradePage() {
	PageFactory.initElements(driver, this);
}

public boolean getQuizName(String quizName) {
	driver.findElement(By.xpath("//td[text()='Quiz:']//following-sibling::td[text()='"+quizName+"']")).isDisplayed();
	return true;
}
public boolean getStudentName(String studentFirstName, String studentLastName) {
	driver.findElement(By.xpath("//td[text()='Student:']//following-sibling::td[text()='"+studentFirstName+" "+studentLastName+"']")).isDisplayed();
	return true;
}
public boolean getGroupName(String group) {
	driver.findElement(By.xpath("//td[text()='Group:']//following-sibling::td[text()='"+group+"']")).isDisplayed();
	return true;
}


}
