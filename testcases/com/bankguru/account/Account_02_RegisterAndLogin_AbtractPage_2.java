package com.bankguru.account;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_02_RegisterAndLogin_AbtractPage_2 extends AbstractPage{
  WebDriver driver;
  String email, username, password, loginPageURL;
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  email = "automation10" + randomDataTest() + "@gmail.com";	  

	  
	//  driver.get("http://demo.guru99.com/v4/index.php");
	  openUrl(driver, "http://demo.guru99.com/v4/index.php");
	  
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  loginPageURL = getCurrentPageUrl(driver);
  }

  @Test
  public void TC_01_RegisterToSystem() {

	  System.out.println("REGISTER - STEP: 1. Click to 'Here' link");
	//  driver.findElement(By.xpath("//a[text()='here']")).click();
	  clickToElement(driver, "//a[text()='here']");
	  
	  System.out.println("STEP: 2. Input to Email ID textbox");
	//  driver.findElement(By.name("emailid")).sendKeys(email);
	  sendkeyToElement(driver, "//input[@name='emailid']", email);
	  
	  System.out.println("STEP: 3. Click to SUBMIT button");
	//  driver.findElement(By.name("btnLogin")).click();
	  clickToElement(driver, "//input[@name='btnLogin']");
	  
	  System.out.println("STEP: 4. Get Username / Password infor");
	//  username = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	  username = getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
	//  password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	  password = getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
  }
  
  @Test
  public void TC_02_LoginToSystem() {
	  System.out.println("LOGIN - STEP: 1. Open Login page");
	  driver.get(loginPageURL);
	  
	  System.out.println("STEP: 2. Input to UsserID / Password textbox");
	  driver.findElement(By.name("uid")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  
	  System.out.println("STEP: 3. Click to SUBMIT button");
	  driver.findElement(By.name("btnLogin")).click();
	  
	  System.out.println("STEP: 4. Verify Welcome Message displayed");
	  String welcomeMessage = driver.findElement(By.cssSelector("marquee")).getText();
	  Assert.assertEquals(welcomeMessage, "Welcome To Manager's Page of Guru99 Bank");
	  
	  System.out.println("STEP: 5. Verify UserID displayed");
	  Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : "+username+"']")).isDisplayed());
	  

  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int randomDataTest() {
	  Random random = new Random();
	  return random.nextInt(99999);
  }

}
