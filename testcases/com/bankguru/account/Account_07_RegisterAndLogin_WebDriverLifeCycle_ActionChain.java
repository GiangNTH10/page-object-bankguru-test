package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class Account_07_RegisterAndLogin_WebDriverLifeCycle_ActionChain extends AbstractTest{

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMuiltiBrowser(browserName);
		email = "automation10" + randomDataTest() + "@gmail.com";
		loginPage = PageGeneratorManager.getLoginPage(driver);
		System.out.println("Driver ID at Test Class:" +driver.toString());
		
	}

	@Test
	public void TC_01_RegisterToSystem() {

		loginPageUrl = loginPage.getCurrentPageUrl();
		System.out.println("REGISTER - STEP: 1. Click to 'Here' link");
		registerPage = loginPage.clickToHereLink();

		System.out.println("STEP: 2. Input to Email ID textbox");
		registerPage.inputToEmailTextbox(email);

		System.out.println("STEP: 3. Click to SUBMIT button");
		registerPage.clickToSubmitButton();

		System.out.println("STEP: 4. Get Username / Password infor");
		username = registerPage.getUserNameInformation();
		password = registerPage.getPasswordInformation();
	}

	@Test
	public void TC_02_LoginToSystem() {
		System.out.println("LOGIN - STEP: 1. Open Login page");
		loginPage = registerPage.openLoginPage(loginPageUrl);

		System.out.println("STEP: 2. Input to UserID / Password textbox");
		loginPage.inputToUserIDTextbox(username);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("STEP: 3. Click to LOGIN button");
		// driver.findElement(By.name("btnLogin")).click();
		homePage = loginPage.clickToLoginButton();

		System.out.println("STEP: 4. Verify Welcome Message displayed");
		homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank");

		System.out.println("STEP: 5. Verify UserID displayed");
		homePage.isUserIDDisplayed(username);

	}
	
	@Test
	public void TC_03_OpenMultiplePage() {
		System.out.println("ACTION: 1. Home Page navigate to New Customer Page");
		newCustomerPage = homePage.openNewCustomerPage(driver);
		
		System.out.println("ACTION: 2. Home Page navigate to Edit Customer Page");
		editCustomerPage = newCustomerPage.openEditCustomerPage(driver);
		
		loginPage = editCustomerPage.openLogoutLink(driver);
		
		loginPage.inputToUserIDTextbox(username);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		System.out.println("ACTION: 3. Edit Customer Page navigate to New Customer Page");
		newCustomerPage = homePage.openNewCustomerPage(driver);
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	public int randomDataTest() {
		Random random = new Random();
		return random.nextInt(99999);
	}
	
	WebDriver driver;
	String email, username, password, loginPageUrl;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editCustomerPage;
}
