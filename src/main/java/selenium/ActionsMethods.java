package selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import ask.base.Base;

public class ActionsMethods extends Base {
	
	
	@Test
	public void dragAndDrop() throws IOException {
		browserInit();
		launchApp();
		WebElement drag = driver
				.findElement(By.xpath("//div[@id='products']//div//ul//li[2]//a[contains(text(),'5000')]"));
		WebElement drop = driver
				.findElement(By.xpath("//h3[contains(text(),'DEBIT SIDE')]/..//h3[contains(text(),'Amount')]/..//li"));

		Actions actions = new Actions(driver);

		actions.dragAndDrop(drag, drop).build().perform();
		try {
			String text = drop.getText();
			System.out.println(text);
		} catch (StaleElementReferenceException e) {
			WebElement drop2 = driver.findElement(
					By.xpath("//h3[contains(text(),'DEBIT SIDE')]/..//h3[contains(text(),'Amount')]/..//li"));
			String text2 = drop2.getText();
			System.out.println(text2);
		}
	}

	@Test
	public void clickAndHold() throws IOException {
		browserInit();
		launchApp();
		WebElement drag = driver
				.findElement(By.xpath("//div[@id='products']//div//ul//li[2]//a[contains(text(),'5000')]"));
		WebElement drop = driver
				.findElement(By.xpath("//h3[contains(text(),'DEBIT SIDE')]/..//h3[contains(text(),'Amount')]/..//li"));

		Actions actions = new Actions(driver);
		actions.clickAndHold(drag).build().perform();
		actions.doubleClick(driver.findElement(By.xpath("//strong[text()='Note:']"))).build().perform();

	}
	

}
