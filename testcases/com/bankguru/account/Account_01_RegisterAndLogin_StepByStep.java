package com.bankguru.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_01_RegisterAndLogin_StepByStep {
  WebDriver driver;
  String email, username, password, loginPageURL;
  
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("http://demo.guru99.com/v4/index.php");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  loginPageURL = driver.getCurrentUrl();
	  email = "automation10" + randomDataTest() + "@gmail.com";
  }

  @Test
  public void TC_01_RegisterToSystem() {

	  System.out.println("REGISTER - STEP: 1. Click to 'Here' link");
	  driver.findElement(By.xpath("//a[text()='here']")).click();
	  
	  System.out.println("STEP: 2. Input to Email ID textbox");
	  driver.findElement(By.name("emailid")).sendKeys(email);
	  
	  System.out.println("STEP: 3. Click to SUBMIT button");
	  driver.findElement(By.name("btnLogin")).click();
	  
	  System.out.println("STEP: 4. Get Username / Password infor");
	  username = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	  password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
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

  @Test
  public void TC_03_NameCanNotEmpty() {
	  System.out.println("LOGIN - STEP: 1. Open New Customer page");
	  
	  System.out.println("LOGIN - STEP: 1. Focus on Name field");
	  
	  System.out.println("LOGIN - STEP: 1. Clear value of Name field");
	  
	  System.out.println("LOGIN - STEP: 1. Press TAB and move to next field");
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
