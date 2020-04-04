package selenium;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ask.base.Base;
public class BrokenLinksAndEmages extends Base  {

	SoftAssert sa =new SoftAssert();
		
	@Test
	public void findBrokenLinks() throws IOException {
		browserInit();
		launchApp();
	List	<WebElement> allLinks=driver.findElements(By.tagName("a"));
	allLinks.addAll(driver.findElements(By.tagName("img")));
	
	List<WebElement> activeLinks=new ArrayList <WebElement>();
	
	for(int i=0; i<allLinks.size();i++) {
		WebElement element=allLinks.get(i); 
	String url=element.getAttribute("href");
		if(url!=null && url.startsWith("http")) {
			activeLinks.add(element);
		}
	}
	for (int j=0;j<activeLinks.size();j++) {
		
	String activeUrl=	activeLinks.get(j).getAttribute("href");
	URL openConnection=new URL(activeUrl);
	HttpURLConnection connection=(HttpURLConnection) openConnection.openConnection();
	connection.connect();
	String responseMessage=connection.getResponseMessage();
	String responseOK="OK";
	
	
	sa.assertEquals(responseMessage, responseOK, activeUrl+ "!!!   FAILED  !!!"+responseMessage);
	
	}
	sa.assertAll();
	driver.quit();
}
	}