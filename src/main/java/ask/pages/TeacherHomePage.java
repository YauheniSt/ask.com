package ask.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ask.base.Base;

public class TeacherHomePage extends Base {
	
	public TeacherHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='TEACHER'] ")
	WebElement teacherLable;
	
	public boolean getTeacherLabel() {
		teacherLable.isDisplayed();
		return true;
	}

}
