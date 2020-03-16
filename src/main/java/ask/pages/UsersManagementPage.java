package ask.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	@FindBy(xpath="//h6[text()='Group: 1']//preceding-sibling::h4[text()='Ivan Ivanov']")
	WebElement IvanIvanovGroup1;
	
	public void selectIvanIvanovGroup1() {
		IvanIvanovGroup1.click();
	}
	
	public void deleteStudents() throws InterruptedException {
		UserDetailsPage userDetailsPage =new UserDetailsPage();
		List <WebElement> students=driver.findElements(By.xpath("//h6[contains(text(),'Group:')]"));
		int numberOfStudents=students.size();
		for( int i=0; i<=numberOfStudents+i; i++) {
			try {
			students.get(i).click();
			Thread.sleep(1000);
			userDetailsPage.clickOptionsButton();
			Thread.sleep(1000);
			userDetailsPage.clickDeleteUserButton();
			Thread.sleep(1000);
			userDetailsPage.clickConfirmDeleteUserButton();
			Thread.sleep(2000);
			}
catch(StaleElementReferenceException e) {
	students=driver.findElements(By.xpath("//h6[contains(text(),'Group:')]"));
	students.get(i).click();
	
	userDetailsPage.clickOptionsButton();
	
	userDetailsPage.clickDeleteUserButton();

	userDetailsPage.clickConfirmDeleteUserButton();
	Thread.sleep(2000);
}
	
}
			
		
	

}}
