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

public class BrokenLinksAndEmages extends Base {

	SoftAssert sa = new SoftAssert();

	@Test
	public void findBrokenLinks() throws IOException {
		browserInit();
		launchApp();
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		allLinks.addAll(driver.findElements(By.tagName("img")));

		List<WebElement> activeLinks = new ArrayList<WebElement>();

		for (int i = 0; i < allLinks.size(); i++) {
			WebElement element = allLinks.get(i);
			String url = element.getAttribute("href");
			if (url != null && url.startsWith("http")) {
				activeLinks.add(element);
			}
		}
		for (int j = 0; j < activeLinks.size(); j++) {

			String activeUrl = activeLinks.get(j).getAttribute("href");
			URL openConnection = new URL(activeUrl);
			HttpURLConnection connection = (HttpURLConnection) openConnection.openConnection();
			connection.connect();
			String responseMessage = connection.getResponseMessage();
			String responseOK = "OK";

			sa.assertEquals(responseMessage, responseOK, activeUrl + "!!!   FAILED  !!!" + responseMessage);

		}
		sa.assertAll();
		driver.quit();
	}

	@Test
	public void findBrokenLinksPractice() throws IOException {
		browserInit();
		launchApp();
		// find all links on the page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		// create an ArrayList to add only active links
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		// create for loop to add the active links to ArrayList<WebElement>()
		for (int i = 0; i < links.size(); i++) {
			// the following line return "href" attribute value which is nothing but URL
			String url = links.get(i).getAttribute("href");
			// create condition to return only real links: not empty and start from http,
			// and add them to ArrayList<WebElement>()
			if (url != null && url.startsWith("http")) {
				activeLinks.add(links.get(i));
			}
		}
		// create a loop to get access to each active link
		for (int j = 0; j < activeLinks.size(); j++) {
			// the following line return active URL
			String activeUrl = activeLinks.get(j).getAttribute("href");
			// create an object of URL class to open connection with activeUrls:
			URL openConnectin = new URL(activeUrl);
			// create an object of HttpURLConnection class to get connected to activeUrls:
			HttpURLConnection connection = (HttpURLConnection) openConnectin.openConnection();
			// get connected via connect method:
			connection.connect();
			//get response message or response code:
			String responseMessage=connection.getResponseMessage();
			String expectedResponseMessage="OK";
			//int status=connection.getResponseCode();
			//create an assertion to compare the results:
			sa.assertEquals(responseMessage, expectedResponseMessage, activeUrl+ " !!!failed!!! "+responseMessage);
		}
		//assertAll to get all the failed activeUrls
		sa.assertAll();
	}
}