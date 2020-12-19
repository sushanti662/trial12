package com.salesforce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory or Object Repository

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//img[@id='logo']")
	WebElement salesLogo;

	// Initialization of Page Factory(WebElements)
	// by creating Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions or functions are supposed to stay in page object model
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateSalesLogo() {
		return salesLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();

	}
}