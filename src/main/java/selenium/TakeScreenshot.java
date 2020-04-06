package selenium;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import ask.base.Base;

public class TakeScreenshot extends Base {

	@Test
	public void scr() throws IOException {
	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File( "path"));
	
		
	}
}
