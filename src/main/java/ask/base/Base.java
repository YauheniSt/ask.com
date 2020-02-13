package ask.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ask.config.Config;
import ask.util.Util;

public class Base {
	public static Properties prop;
	public static WebDriver driver;
	public FileInputStream file;
	public Config config;

	
		
		
		
		public WebDriver browserInit() throws IOException {
			prop = new Properties();
			config = new Config();
			file = new FileInputStream(config.getConfigDir());
			prop.load(file);
			
		if (prop.get("browser").equals("chrome")) {
			System.setProperty(prop.getProperty("chromeDriver"), prop.getProperty("chromeDriverDir"));
			driver = new ChromeDriver();
		}
		else if (prop.get("browser").equals("gecko")) {
			System.setProperty(prop.getProperty("geckoDriver"), prop.getProperty("geckoDriverDir"));
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Util.implicitWait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;

	}}


