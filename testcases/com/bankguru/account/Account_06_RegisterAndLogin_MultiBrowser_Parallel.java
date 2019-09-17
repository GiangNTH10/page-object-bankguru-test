package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Account_06_RegisterAndLogin_MultiBrowser_Parallel extends AbstractTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMuiltiBrowser(browserName);
		email = "automation10" + randomDataTest() + "@gmail.com";
		loginPage = PageGeneratorManager.getLoginPage(driver);
		System.out.println("Driver ID at Test Class:" + driver.toString());

	}

	@Test
	public void TC_01_RegisterToSystem() {

		loginPageUrl = loginPage.getCurrentPageUrl();
		System.out.println("REGISTER - STEP: 1. Click to 'Here' link");
		// driver.findElement(By.xpath("//a[text()='here']")).click();
		registerPage = loginPage.clickToHereLink();

		System.out.println("STEP: 2. Input to Email ID textbox");
		// driver.findElement(By.name("emailid")).sendKeys(email);
		registerPage.inputToEmailTextbox(email);

		System.out.println("STEP: 3. Click to SUBMIT button");
		// driver.findElement(By.name("btnLogin")).click();
		registerPage.clickToSubmitButton();

		System.out.println("STEP: 4. Get Username / Password infor");
		// username = driver.findElement(By.xpath("//td[text()='User ID
		// :']/following-sibling::td")).getText();
		// password = driver.findElement(By.xpath("//td[text()='Password
		// :']/following-sibling::td")).getText();
		username = registerPage.getUserNameInformation();
		password = registerPage.getPasswordInformation();
	}

	@Test
	public void TC_02_LoginToSystem() {
		System.out.println("LOGIN - STEP: 1. Open Login page");
		registerPage.openLoginPage(loginPageUrl);

		System.out.println("STEP: 2. Input to UserID / Password textbox");
		// driver.findElement(By.name("uid")).sendKeys(username);
		// driver.findElement(By.name("password")).sendKeys(password);
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

}
