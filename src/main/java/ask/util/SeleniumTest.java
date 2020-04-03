package ask.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ask.base.Base;

public class SeleniumTest extends Base {

	@Test
	public void findBrokenLinks() throws IOException {
		browserInit();
		launchApp();
		List <WebElement>  link=driver.findElements(By.tagName("a"));
		link.addAll(driver.findElements(By.tagName("img")));
		int linksNumber=link.size();
		
		
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		
		for(int i=0;i<linksNumber;i++)
		{System.out.println(link.get(i).getAttribute("href"));
			if(link.get(i).getAttribute("href") != null){
				activeLinks.add(link.get(i));
			}
		}
		System.out.println(activeLinks.size());
		
				}
		
	
	
}
