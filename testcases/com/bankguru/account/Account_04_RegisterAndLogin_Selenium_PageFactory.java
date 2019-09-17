package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.RegisterPageFactory;

public class Account_04_RegisterAndLogin_Selenium_PageFactory {
	WebDriver driver;
	String email, username, password, loginPageUrl;
	RegisterPageFactory registerPage;
	LoginPageFactory loginPage;
	HomePageFactory homePage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		email = "automation10" + randomDataTest() + "@gmail.com";

		loginPage = new LoginPageFactory(driver);
		registerPage = new RegisterPageFactory(driver);
		homePage = new HomePageFactory(driver);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		System.out.println("PRE CONDITION - STEP: 1. 	Open Bank Guruu Application");
		driver.get("http://demo.guru99.com/v4/index.php");

		System.out.println("PRE CONDITION - STEP: 2. 	Get Login Url");
		loginPageUrl = loginPage.getCurrentPageUrl();
	}

	@Test
	public void TC_01_RegisterToSystem() {

		System.out.println("REGISTER - STEP: 1. Click to 'Here' link");
		// driver.findElement(By.xpath("//a[text()='here']")).click();
		loginPage.clickToHereLink();

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
		loginPage.clickToLoginButton();

		System.out.println("STEP: 4. Verify Welcome Message displayed");
		// String welcomeMessage =
		// driver.findElement(By.cssSelector("marquee")).getText();
		// Assert.assertEquals(welcomeMessage, "Welcome To Manager's Page of Guru99
		// Bank");
		homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank");

		System.out.println("STEP: 5. Verify UserID displayed");
		// Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id :
		// "+username+"']")).isDisplayed());
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

}
