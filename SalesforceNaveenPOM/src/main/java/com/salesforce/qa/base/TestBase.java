package com.salesforce.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.salesforce.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	// Use of Constructor in PageObjectModel, to read the Properties file from
	// config to TestBase class

	// starting of TestBase() method to read configuration from config.properties
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\JavaPrograms\\eclipse-workspace\\SalesforceNaveenPOM\\src\\main\\java\\com\\salesforce\\qa\\config\\config.properties");
			prop.load(ip);
			// System.getProperties().putAll(prop);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // ending of TestBase() method

	// Starting initialization() method
	public static void initialization() {
		// System.getProperty("browser");if you use prop.load and putAll den you can use
		// this.
		// String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			// WebDriverManager.chromedriver().setup();// you have added webdrivermanager in
			// your POM.xml
			System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			// WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver",
					"C:\\geckoDriver_Firefox\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	} // end of Initialization() method
}