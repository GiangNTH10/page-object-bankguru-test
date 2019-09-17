package com.bankguru.customer;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_01_NewCustomer_PageObjectParttern extends AbstractTest{
	WebDriver driver;
	String email, username, password, loginPageUrl;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPageObject;
	
	String customerNameNumericValue, customerNameSpecialCharactersValue, customerNameFirstCharacterAsSpaceValue;
	String addressFirstCharacterAsSpaceValue, customerCityNumericValue, customerCitySpecialCharactersValue, cityFirstCharacterAsSpaceValue;
	String customerStateNumericValue, customerStateSpecialCharactersValue, StateFirstCharacterAsSpaceValue;
	String pINNumericValue, pINNumericMoreThan6DigitValue, pINNumericLessThan6DigitValue, pINNumericHasSpecialCharacterValue;
	String pINNumericFirstCharacterBlankValue, pINNumericCharacterBlankValue;
	String telephoneFirstCharacterBlankValue, telephoneHaveBlankValue, telephoneHaveSpecialCharacterValue;
	String emailInvalidFormatValue, emailFirstCharacterBlankValue;
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMuiltiBrowser(browserName);
		email = "automation10" + randomDataTest() + "@gmail.com";


		customerNameNumericValue = "1234";
		customerNameSpecialCharactersValue = "name!@#";
		customerNameFirstCharacterAsSpaceValue = " ";
		addressFirstCharacterAsSpaceValue = " ";
		customerCityNumericValue = "city123";
		customerCitySpecialCharactersValue = "!@#";
		cityFirstCharacterAsSpaceValue = " ";
		customerStateNumericValue = "1234";
		customerStateSpecialCharactersValue = "!@#";
		StateFirstCharacterAsSpaceValue = " ";
		pINNumericValue = "1234PIN";
		pINNumericMoreThan6DigitValue = "1234567";
		pINNumericLessThan6DigitValue = "12";
		pINNumericHasSpecialCharacterValue = "!@#";
		pINNumericFirstCharacterBlankValue = " ";
		pINNumericCharacterBlankValue = "1 2";
		telephoneFirstCharacterBlankValue = "  123";
		telephoneHaveBlankValue = "1 2";
		telephoneHaveSpecialCharacterValue = "!@#";
		emailInvalidFormatValue = "guru99@gmail";
		emailFirstCharacterBlankValue = " guru99@gmail.com";
		
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		System.out.println("PRE CONDITION - STEP: 2. 	Get Login Url");
		loginPageUrl = loginPage.getCurrentPageUrl();

		System.out.println("PRE CONDITION - STEP: 3. Click to 'Here' link");
		registerPage = loginPage.clickToHereLink();

		System.out.println("PRE CONDITION - STEP: 4. Input to Email ID textbox");
		registerPage.inputToEmailTextbox(email);

		System.out.println("PRE CONDITION - STEP: 5. Click to SUBMIT button");
		registerPage.clickToSubmitButton();

		System.out.println("PRE CONDITION - STEP: 6. Get Username / Password infor");
		username = registerPage.getUserNameInformation();
		password = registerPage.getPasswordInformation();
		
		System.out.println("PRE CONDITION - STEP: 7. Open Login page");
		loginPage = registerPage.openLoginPage(loginPageUrl);

		System.out.println("PRE CONDITION - STEP: 8. Input to UserID / Password textbox");
		loginPage.inputToUserIDTextbox(username);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("PRE CONDITION - STEP: 9. Click to LOGIN button");
		homePage = loginPage.clickToLoginButton();

		System.out.println("PRE CONDITION - STEP: 10. Verify Welcome Message displayed");
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));
		
		System.out.println("PRE CONDITION - STEP: 11. Verify UserID displayed");
		Assert.assertTrue(homePage.isUserIDDisplayed(username));
		
	}

	@Test
	public void TC_01_NameCanNotBeEmpty() {
		
		System.out.println("TC_01_NameCanNotBeEmpty");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Navigate to New Customer Page");
		newCustomerPageObject = homePage.openNewCustomerPage(driver);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Do not enter a value in Name field");
		newCustomerPageObject.clearValueInNameField();
		
		System.out.println("NEW CUSTOMER - STEP: 3. Press TAB and move next field");
		newCustomerPageObject.pressTABNameAndMoveNextField();
		
		System.out.println("NEW CUSTOMER - STEP: 4. Verify error message at Name field");
		Assert.assertTrue(newCustomerPageObject.isCustomerNameErrorMessageDisplayed("Customer name must not be blank"));
	}
	
	@Test
	public void TC_02_NameCanNotBeNumeric() {
		
		System.out.println("TC_02_NameCanNotBeNumeric");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter Numeric value in Name field");
		newCustomerPageObject.enterValueInNameField(customerNameNumericValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify error message at Name field");
		Assert.assertTrue(newCustomerPageObject.isCustomerNameErrorMessageDisplayed("Numbers are not allowed"));
	}
	
	@Test
	public void TC_03_NameCanNotHaveSpecialCharacters() {
		
		System.out.println("TC_03_NameCanNotHaveSpecialCharacters");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter Special Character in Name field");
		newCustomerPageObject.enterValueInNameField(customerNameSpecialCharactersValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify error message at Name field");
		Assert.assertTrue(newCustomerPageObject.isCustomerNameErrorMessageDisplayed("Special characters are not allowed"));
	}

	@Test
	public void TC_04_NameCanNotHaveFirstCharactersAsBlankSpace() {
		
		System.out.println("TC_04_NameCanNotHaveFirstCharactersAsBlankSpace");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter Special Character in Name field");
		newCustomerPageObject.enterValueInNameField(customerNameFirstCharacterAsSpaceValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify error message at Name field");
		Assert.assertTrue(newCustomerPageObject.isCustomerNameErrorMessageDisplayed("First character cannot be space"));
	}
	
	@Test
	public void TC_05_AddressCanNotBeEmpty() {
		
		System.out.println("TC_05_AddressCanNotBeEmpty");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Do not enter a value in Address field");
		newCustomerPageObject.clearValueInAddressField();
		
		System.out.println("NEW CUSTOMER - STEP: 2. Press TAB and move next field");
		newCustomerPageObject.pressTABAddressAndMoveNextField();
		
		System.out.println("NEW CUSTOMER - STEP: 3. Verify error message at Address field");
		Assert.assertTrue(newCustomerPageObject.isAddressErrorMessageDisplayed("ADDRESS cannot be empty"));
	}
		
	@Test
	public void TC_06_AddressCanNotHaveFirstCharactersAsBlankSpace() {
		
		System.out.println("TC_06_AddressCanNotHaveFirstCharactersAsBlankSpace");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter Special Character in Address field");
		newCustomerPageObject.enterValueInAddressField(addressFirstCharacterAsSpaceValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify error message at Address field");
		Assert.assertTrue(newCustomerPageObject.isAddressErrorMessageDisplayed("First character cannot be space"));
	}
	
	@Test
	public void TC_07_CityCanNotBeEmpty() {
		
		System.out.println("TC_07_CityCanNotBeEmpty");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Do not enter a value in City field");
		newCustomerPageObject.clearValueInCityField();
		
		System.out.println("NEW CUSTOMER - STEP: 2. Press TAB and move next field");
		newCustomerPageObject.pressTABCityAndMoveNextField();
		
		System.out.println("NEW CUSTOMER - STEP: 3. Verify error message at City field");
		Assert.assertTrue(newCustomerPageObject.isCityErrorMessageDisplayed("City Field must be not blank"));
	}
	
	@Test
	public void TC_08_CityCanNotBeNumeric() {
		
		System.out.println("TC_08_CityCanNotBeNumeric");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter Numeric value in City field");
		newCustomerPageObject.enterValueInCityField(customerCityNumericValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify error message at City field");
		Assert.assertTrue(newCustomerPageObject.isCityErrorMessageDisplayed("Numbers are not allowed"));
	}
	
	@Test
	public void TC_09_CityCanNotHaveSpecialCharacters() {
		
		System.out.println("TC_09_CityCanNotHaveSpecialCharacters");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter Special Character in City field");
		newCustomerPageObject.enterValueInCityField(customerCitySpecialCharactersValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify error message at City field");
		Assert.assertTrue(newCustomerPageObject.isCityErrorMessageDisplayed("Special characters are not allowed"));
	}

	@Test
	public void TC_10_CityCanNotHaveFirstCharactersAsBlankSpace() {
		
		System.out.println("TC_10_CityCanNotHaveFirstCharactersAsBlankSpace");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter Special Character in City field");
		newCustomerPageObject.enterValueInCityField(cityFirstCharacterAsSpaceValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify error message at City field");
		Assert.assertTrue(newCustomerPageObject.isCityErrorMessageDisplayed("First character cannot be space"));
	}
	
	@Test
	public void TC_11_StateCanNotBeEmpty() {
		
		System.out.println("TC_11_StateCanNotBeEmpty");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Do not enter a value in State field");
		newCustomerPageObject.clearValueInStateField();
		
		System.out.println("NEW CUSTOMER - STEP: 2. Press TAB and move next field");
		newCustomerPageObject.pressTABStateAndMoveNextField();
		
		System.out.println("NEW CUSTOMER - STEP: 3. Verify error message at State field");
		Assert.assertTrue(newCustomerPageObject.isStateErrorMessageDisplayed("State must not be blank"));
	}
	
	@Test
	public void TC_12_StateCanNotBeNumeric() {
		
		System.out.println("TC_12_StateCanNotBeNumeric");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter Numeric value in State field");
		newCustomerPageObject.enterValueInStateField(customerStateNumericValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify error message at State field");
		Assert.assertTrue(newCustomerPageObject.isStateErrorMessageDisplayed("Numbers are not allowed"));
	}
	
	@Test
	public void TC_13_StateCanNotHaveSpecialCharacters() {
		
		System.out.println("TC_09_StateCanNotHaveSpecialCharacters");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter Special Character in State field");
		newCustomerPageObject.enterValueInStateField(customerStateSpecialCharactersValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify error message at State field");
		Assert.assertTrue(newCustomerPageObject.isStateErrorMessageDisplayed("Special characters are not allowed"));
	}

	@Test
	public void TC_14_StateCanNotHaveFirstCharactersAsBlankSpace() {
		
		System.out.println("TC_10_StateCanNotHaveFirstCharactersAsBlankSpace");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter Special Character in State field");
		newCustomerPageObject.enterValueInStateField(StateFirstCharacterAsSpaceValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify error message at State field");
		Assert.assertTrue(newCustomerPageObject.isStateErrorMessageDisplayed("First character cannot be space"));
	}
	
	@Test
	public void TC_15_PINMustBeNumeric() {
		
		System.out.println("TC_15_PINMustBeNumeric");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter Numeric value in PIN field");
		newCustomerPageObject.enterValueInPINField(pINNumericValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify required numeric at PIN field");
		Assert.assertTrue(newCustomerPageObject.isPINErrorMessageDisplayed("Characters are not allowed"));
	}
	
	@Test
	public void TC_16_PINCanNotBeEmpty() {
		
		System.out.println("TC_16_PINCanNotBeEmpty");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Do not enter a value in PIN field");
		newCustomerPageObject.clearValueInPINField();
		
		System.out.println("NEW CUSTOMER - STEP: 2. Press TAB and move next field");
		newCustomerPageObject.pressTABPINAndMoveNextField();
		
		System.out.println("NEW CUSTOMER - STEP: 3. Verify error message at PIN field");
		Assert.assertTrue(newCustomerPageObject.isPINErrorMessageDisplayed("PIN code must not be blank"));
	}

	@Test
	public void TC_17_PINMustHave6Digits() {
		
		System.out.println("TC_17_PINMustHave6Digits");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter less than 6 digital in PIN Field");
		newCustomerPageObject.enterValueInPINField(pINNumericLessThan6DigitValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify PIN Must Have 6 Digits");
		Assert.assertTrue(newCustomerPageObject.isPINErrorMessageDisplayed("PIN Code must have 6 Digits"));
	}
	
	@Test
	public void TC_18_PINCanNotHaveSpecialCharacter() {
		System.out.println("TC_18_PINCanNotHaveSpecialCharacter");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter special character in PIN Field");
		newCustomerPageObject.enterValueInPINField(pINNumericHasSpecialCharacterValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify PIN has special character");
		Assert.assertTrue(newCustomerPageObject.isPINErrorMessageDisplayed("Special characters are not allowed"));
	}
	
	@Test
	public void TC_19_PINCanNotHaveFirstBlankSpace() {
		System.out.println("TC_19_PINCanNotHaveFirstBlankSpace");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter first character Blank Space");
		newCustomerPageObject.enterValueInPINField(pINNumericFirstCharacterBlankValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify PIN has first blank space");
		Assert.assertTrue(newCustomerPageObject.isPINErrorMessageDisplayed("First character cannot be space"));
	}
	
	@Test
	public void TC_20_PINCanNotHaveBlankSpace() {
		System.out.println("TC_20_PINCanNotHaveBlankSpace");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter character Blank Space");
		newCustomerPageObject.enterValueInPINField(pINNumericCharacterBlankValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify PIN has blank value");
		Assert.assertTrue(newCustomerPageObject.isPINErrorMessageDisplayed("PIN cannot have space"));
	}
	
	@Test
	public void TC_21_TelephoneCanNotBeEmpty() {
		
		System.out.println("TC_21_TelephoneCanNotBeEmpty");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Do not enter a value in Telephone field");
		newCustomerPageObject.clearValueInTelephoneField();
		
		System.out.println("NEW CUSTOMER - STEP: 2. Press TAB and move next field");
		newCustomerPageObject.pressTABTelephoneAndMoveNextField();
		
		System.out.println("NEW CUSTOMER - STEP: 3. Verify error message at Telephone field");
		Assert.assertTrue(newCustomerPageObject.isTelephoneErrorMessageDisplayed("Telephone no must not be blank"));
	}
	
	@Test
	public void TC_22_TelephoneCanNotHaveFirstBlankSpace() {
		
		System.out.println("TC_22_TelephoneCanNotHaveFirstBlankSpace");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter first character Blank Space");
		newCustomerPageObject.enterValueInTelephoneField(telephoneFirstCharacterBlankValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify Telephone has first blank value");
		Assert.assertTrue(newCustomerPageObject.isTelephoneErrorMessageDisplayed("First character cannot be space"));
	}
	
	@Test
	public void TC_23_TelephoneCanNotHaveSpace() {
		
		System.out.println("TC_23_TelephoneCanNotHaveSpace");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter Blank Space in Telephone field");
		newCustomerPageObject.enterValueInTelephoneField(telephoneHaveBlankValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify Telephone has space value");
		Assert.assertTrue(newCustomerPageObject.isTelephoneErrorMessageDisplayed("Telephone cannot have be space"));
	}
	
	@Test
	public void TC_24_TelephoneCanNotHaveSpecialCharacter() {
		
		System.out.println("TC_24_TelephoneCanNotHaveSpecialCharacter");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter special character in Telephone field");
		newCustomerPageObject.enterValueInTelephoneField(telephoneHaveSpecialCharacterValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify Telephone has special character");
		Assert.assertTrue(newCustomerPageObject.isTelephoneErrorMessageDisplayed("Special characters are not allowed"));
	}
	
	@Test
	public void TC_25_EmailCanNotBeEmpty() {
		
		System.out.println("TC_25_EmailCanNotBeEmpty");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Do not enter a value in Email field");
		newCustomerPageObject.clearValueInEmailField();
		
		System.out.println("NEW CUSTOMER - STEP: 2. Press TAB and move next field");
		newCustomerPageObject.pressTABEmailAndMoveNextField();
		
		System.out.println("NEW CUSTOMER - STEP: 3. Verify error message at Email field");
		Assert.assertTrue(newCustomerPageObject.isEmailErrorMessageDisplayed("Email ID must not be blank"));
	}

	@Test
	public void TC_26_EmailMustBeCorrectFormat() {
		
		System.out.println("TC_24_TelephoneCanNotHaveSpecialCharacter");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter special character in Email field");
		newCustomerPageObject.enterValueInEmailField(emailInvalidFormatValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify Email has special character");
		Assert.assertTrue(newCustomerPageObject.isEmailErrorMessageDisplayed("Email-ID is not valid"));
	}
	
	@Test
	public void TC_27_EmailCanNotHaveFirstBlank() {
		
		System.out.println("TC_27_EmailCanNotHaveFirstBlank");
		
		System.out.println("NEW CUSTOMER - STEP: 1. Enter first character Blank Space");
		newCustomerPageObject.enterValueInEmailField(emailFirstCharacterBlankValue);
		
		System.out.println("NEW CUSTOMER - STEP: 2. Verify Email has first character Blank Space");
		Assert.assertTrue(newCustomerPageObject.isEmailErrorMessageDisplayed("First character can not have space"));
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
