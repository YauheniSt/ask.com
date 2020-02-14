package ask.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	

}
