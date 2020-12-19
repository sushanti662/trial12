package com.salesforce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salesforce.qa.base.TestBase;
import com.salesforce.qa.pages.HomePage;
import com.salesforce.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		// to call the constructor from the base class so to use the properties
		super();
	}
	// hello

	@BeforeMethod
	public void setUp() {
		initialization();// calling initialisation method from TestBase class
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login | Salesforce");
	}

	@Test(priority = 2)
	public void LoginPageLogoTest() {
		boolean flag = loginPage.validateSalesLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void LoginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
