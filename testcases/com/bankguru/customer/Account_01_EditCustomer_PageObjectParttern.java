package com.bankguru.customer;

import org.testng.annotations.Test;

import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_01_EditCustomer_PageObjectParttern {
	WebDriver driver;
	String email, username, password, loginPageUrl;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	EditCustomerPageObject editCustomerPageObject;
	NewCustomerPageObject newCustomerPageObject;
	
	public String customerID;
	String customerIDNotNumeric, customerIDSpecialCharactersValue;
	String customerName, dateOfBirth, address, city, state, pIN, mobileNumber, emailCustomer, passwordCustomer;
	String cityNumericEdit, citySpecialCharacterEdit, stateNumericEdit, stateSpecialCharacterEdit, pINCharacterEdit;
	String pINLessThan6DigitsEdit, pINHaveSpecialCharacterEdit, telephoneHaveSpecialCharacterEdit;
	String emailInvalidFormatEdit1, emailInvalidFormatEdit2;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		email = "automation10" + randomDataTest() + "@gmail.com";
		
		customerName = "Nguyen A";
		dateOfBirth = "01/01/1990";
		address = "Address 1";
		city = "Da Nang";
		state = "DN";
		pIN = "123456";
		mobileNumber = "1234567890";
		emailCustomer = "customer" + randomDataTest() + "@gmail.com";
		passwordCustomer = "123";
		
		cityNumericEdit = "1234";
		citySpecialCharacterEdit = "City!@#";
		stateNumericEdit = "1234";
		stateSpecialCharacterEdit = "!@#";
		pINCharacterEdit = "1234AB";
		pINLessThan6DigitsEdit = "123";
		pINHaveSpecialCharacterEdit = "!@#";
		telephoneHaveSpecialCharacterEdit = "!@#";
		emailInvalidFormatEdit1 = "customer" + randomDataTest() + "@gmail";
		emailInvalidFormatEdit2 = "customer" + randomDataTest() + "@gmail.";

		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
		homePage = new HomePageObject(driver);
		editCustomerPageObject = new EditCustomerPageObject(driver);
		newCustomerPageObject = new NewCustomerPageObject(driver);
		
		
		
		customerIDNotNumeric = "1234Acc";
		customerIDSpecialCharactersValue = "123!@#";

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		System.out.println("PRE CONDITION - STEP: 1. Open Bank Guruu Application");
		driver.get("http://demo.guru99.com/v4/index.php");
		System.out.println("PRE CONDITION - STEP: 2. 	Get Login Url");
		loginPageUrl = loginPage.getCurrentPageUrl();

		System.out.println("PRE CONDITION - STEP: 3. Click to 'Here' link");
		loginPage.clickToHereLink();

		System.out.println("PRE CONDITION - STEP: 4. Input to Email ID textbox");
		registerPage.inputToEmailTextbox(email);

		System.out.println("PRE CONDITION - STEP: 5. Click to SUBMIT button");
		registerPage.clickToSubmitButton();

		System.out.println("PRE CONDITION - STEP: 6. Get Username / Password infor");
		username = registerPage.getUserNameInformation();
		password = registerPage.getPasswordInformation();
		
		System.out.println("PRE CONDITION - STEP: 7. Open Login page");
		registerPage.openLoginPage(loginPageUrl);

		System.out.println("PRE CONDITION - STEP: 8. Input to UserID / Password textbox");
		loginPage.inputToUserIDTextbox(username);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("PRE CONDITION - STEP: 9. Click to LOGIN button");
		loginPage.clickToLoginButton();

		System.out.println("PRE CONDITION - STEP: 10. Verify Welcome Message displayed");
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));
		
		System.out.println("PRE CONDITION - STEP: 11. Verify UserID displayed");
		Assert.assertTrue(homePage.isUserIDDisplayed(username));
		
		customerID = createNewCustomer ();
	}

	@Test
	public void TC_01_CustomerIDCanNotBeEmpty() {
		
		System.out.println("TC_01_CustomerIDCanNotBeEmpty");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Do not enter a value in Customer ID field");
		editCustomerPageObject.clearValueInCustomerIDField();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Press TAB and move next field");
		editCustomerPageObject.pressTABNameAndMoveNextField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Verify error message at Customer ID field");
		Assert.assertTrue(editCustomerPageObject.isCustomerIDErrorMessageDisplayed("Customer ID is required"));
	}
	
	@Test
	public void TC_02_CustomerIDCanNotBeNumeric() {
		
		System.out.println("TC_02_CustomerIDCanNotBeNumeric");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter Numeric value in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerIDNotNumeric);
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Verify error message at Customer ID field");
		Assert.assertTrue(editCustomerPageObject.isCustomerIDErrorMessageDisplayed("Characters are not allowed"));
	}
	
	@Test
	public void TC_03_CustomerIDCanNotHaveSpecialCharacters() {
		
		System.out.println("TC_03_CustomerIDCanNotHaveSpecialCharacters");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter Special Character in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerIDSpecialCharactersValue);
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Verify error message at Customer ID field");
		Assert.assertTrue(editCustomerPageObject.isCustomerIDErrorMessageDisplayed("Special characters are not allowed"));	
	}

	@Test
	public void TC_04_ValidCustomerID() {
		
		System.out.println("TC_04_ValidCustomerID");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);

		System.out.println("EDIT CUSTOMER - STEP: 3. Click Submit button");
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Verify redirect to Edit Customer page");
		Assert.assertTrue(editCustomerPageObject.isEditCustomerPageDisplayed("Customer Name"));
	}
	
	@Test
	public void TC_05_AddressCanNotEmpty() {
		System.out.println("TC_05_AddressCanNotEmpty");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Do not enter a value in Address field");
		editCustomerPageObject.clearValueInAddressField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Press TAB and move next field");
		editCustomerPageObject.pressTABAddressAndMoveNextField();
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at Address field");
		Assert.assertTrue(editCustomerPageObject.isAddressErrorMessageDisplayed("ADDRESS cannot be empty"));
	}
	
	@Test
	public void TC_06_CityCanNotEmpty() {
		System.out.println("TC_06_CityCanNotEmpty");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Do not enter a value in City field");
		editCustomerPageObject.clearValueInCityField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Press TAB and move next field");
		editCustomerPageObject.pressTABCityAndMoveNextField();
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at City field");
		Assert.assertTrue(editCustomerPageObject.isCityErrorMessageDisplayed("CITY cannot be empty"));
	}
	
	@Test
	public void TC_07_CityCanNotBeNumeric() {
		System.out.println("TC_07_CityCanNotBeNumeric");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in City field");
		editCustomerPageObject.clearValueInCityField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Enter numeric value in City field");
		editCustomerPageObject.enterValueInCityField(cityNumericEdit);
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at City field");
		Assert.assertTrue(editCustomerPageObject.isCityErrorMessageDisplayed("City cannot contain Number"));
	}
	
	@Test
	public void TC_08_CityCanNotHaveSpecialCharacter() {
		System.out.println("TC_08_CityCanNotHaveSpecialCharacter");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in City field");
		editCustomerPageObject.clearValueInCityField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Enter numeric value in City field");
		editCustomerPageObject.enterValueInCityField(citySpecialCharacterEdit);
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at City field");
		Assert.assertTrue(editCustomerPageObject.isCityErrorMessageDisplayed("City cannot contain Special Characters"));
	}
	
	@Test
	
	public void TC_09_StateCanNotEmpty() {
		System.out.println("TC_09_StateCanNotEmpty");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Do not enter a value in State field");
		editCustomerPageObject.clearValueInStateField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Press TAB and move next field");
		editCustomerPageObject.pressTABStateAndMoveNextField();
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at State field");
		Assert.assertTrue(editCustomerPageObject.isStateErrorMessageDisplayed("STATE cannot be empty"));
	}
	
	@Test
	public void TC_10_StateCanNotBeNumeric() {
		System.out.println("TC_10_StateCanNotBeNumeric");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in State field");
		editCustomerPageObject.clearValueInStateField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Enter numeric value in State field");
		editCustomerPageObject.enterValueInStateField(stateNumericEdit);
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at State field");
		Assert.assertTrue(editCustomerPageObject.isStateErrorMessageDisplayed("Numbers are not allowed"));
	}
	
	@Test
	public void TC_11_StateCanNotHaveSpecialCharacter() {
		System.out.println("TC_11_StateCanNotHaveSpecialCharacter");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in State field");
		editCustomerPageObject.clearValueInStateField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Enter numeric value in State field");
		editCustomerPageObject.enterValueInStateField(stateSpecialCharacterEdit);
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at State field");
		Assert.assertTrue(editCustomerPageObject.isStateErrorMessageDisplayed("City cannot contain Special Characters"));
	}
	
	@Test
	public void TC_12_PINMustBeNumeric() {
		System.out.println("TC_12_PINMustBeNumeric");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in PIN field");
		editCustomerPageObject.clearValueInPINField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Enter numeric value in PIN field");
		editCustomerPageObject.enterValueInPINField(pINCharacterEdit);
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at PIN field");
		Assert.assertTrue(editCustomerPageObject.isPINErrorMessageDisplayed("PIN cannot contain character"));
	}
	
	@Test
	public void TC_13_PINCanNotBeEmpty() {
		
		System.out.println("TC_13_PINCanNotBeEmpty");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in PIN field");
		editCustomerPageObject.clearValueInPINField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Press TAB and move next field");
		editCustomerPageObject.pressTABPINAndMoveNextField();
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at PIN field");
		Assert.assertTrue(editCustomerPageObject.isPINErrorMessageDisplayed("PIN cannot be empty"));
	}

	@Test
	public void TC_14_PINMustHave6Digits() {
		System.out.println("TC_14_PINMustHave6Digits");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in PIN field");
		editCustomerPageObject.clearValueInPINField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Enter numeric value in PIN field");
		editCustomerPageObject.enterValueInPINField(pINLessThan6DigitsEdit);
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at PIN field");
		Assert.assertTrue(editCustomerPageObject.isPINErrorMessageDisplayed("PIN must contain 6 digit"));
	}
	
	@Test
	public void TC_15_PINCanNotHaveSpecialCharacter() {
		System.out.println("TC_15_PINCanNotHaveSpecialCharacter");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in PIN field");
		editCustomerPageObject.clearValueInPINField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Enter numeric value in PIN field");
		editCustomerPageObject.enterValueInPINField(pINHaveSpecialCharacterEdit);
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at PIN field");
		Assert.assertTrue(editCustomerPageObject.isPINErrorMessageDisplayed("PIN cannot contain Special Characters"));
	}
	
	@Test
	public void TC_16_TelephoneCanNotBeEmpty() {
		
		System.out.println("TC_16_TelephoneCanNotBeEmpty");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in Telephone field");
		editCustomerPageObject.clearValueInTelephoneField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Press TAB and move next field");
		editCustomerPageObject.pressTABTelephoneAndMoveNextField();
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at Telephone field");
		Assert.assertTrue(editCustomerPageObject.isTelephoneErrorMessageDisplayed("Telephone cannot be empty"));
	}
	
	@Test
	public void TC_17_TelephoneCanNotHaveSpecialCharacter() {
		System.out.println("TC_17_TelephoneCanNotHaveSpecialCharacter");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in Telephone field");
		editCustomerPageObject.clearValueInTelephoneField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Enter numeric value in Telephone field");
		editCustomerPageObject.enterValueInTelephoneField(telephoneHaveSpecialCharacterEdit);
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at PIN field");
		Assert.assertTrue(editCustomerPageObject.isTelephoneErrorMessageDisplayed("Telephone cannot contain Special Characters"));
	}
	
	@Test
	public void TC_18_EmailCanNotBeEmpty() {
		
		System.out.println("TC_18_EmailCanNotBeEmpty");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in Email field");
		editCustomerPageObject.clearValueInEmailField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Press TAB and move next field");
		editCustomerPageObject.pressTABEmailAndMoveNextField();
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at Email field");
		Assert.assertTrue(editCustomerPageObject.isEmailErrorMessageDisplayed("Email cannot be empty"));
	}
	
	@Test
	public void TC_19_EmailMustBeInFormat() {
		
		System.out.println("TC_19_EmailMustBeInFormat");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in Email field");
		editCustomerPageObject.clearValueInEmailField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Enter numeric value in Email field");
		editCustomerPageObject.enterValueInEmailField(emailInvalidFormatEdit1);
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at Email field");
		Assert.assertTrue(editCustomerPageObject.isEmailErrorMessageDisplayed("Email must be in format example@example.com"));
	}
	
	@Test
	public void TC_20_EmailMustBeInFormat() {
		
		System.out.println("TC_20_EmailMustBeInFormat");
		
		System.out.println("EDIT CUSTOMER - STEP: 1. Navigate to Edit Customer Page");
		homePage.navigateToEditCustomerPage();
		
		System.out.println("EDIT CUSTOMER - STEP: 2. Enter valid in Customer ID field");
		editCustomerPageObject.enterValueInCustomerIDField(customerID);
		editCustomerPageObject.clickToSubmitButton();
		
		System.out.println("EDIT CUSTOMER - STEP: 3. Clear a value in Email field");
		editCustomerPageObject.clearValueInEmailField();
		
		System.out.println("EDIT CUSTOMER - STEP: 4. Enter numeric value in Email field");
		editCustomerPageObject.enterValueInEmailField(emailInvalidFormatEdit2);
		
		System.out.println("EDIT CUSTOMER - STEP: 5. Verify error message at Email field");
		Assert.assertTrue(editCustomerPageObject.isEmailErrorMessageDisplayed("Email must be in format Example@example.com"));
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//driver.quit();
	}

	public int randomDataTest() {
		Random random = new Random();
		return random.nextInt(99999);
	}
	
	public String createNewCustomer () {
		homePage.navigateToNewCustomerPage();
		newCustomerPageObject.enterValueInNameField(customerName);
		newCustomerPageObject.enterValueInDateOfBirthField(dateOfBirth);
		newCustomerPageObject.enterValueInAddressField(address);
		newCustomerPageObject.enterValueInCityField(city);
		newCustomerPageObject.enterValueInStateField(state);
		newCustomerPageObject.enterValueInPINField(pIN);
		newCustomerPageObject.enterValueInMobileNumberInField(mobileNumber);
		newCustomerPageObject.enterValueInEmailField(emailCustomer);
		newCustomerPageObject.enterValueInPasswordField(passwordCustomer);
		newCustomerPageObject.clickToSubmitButton();
		return newCustomerPageObject.getCustomerID();
		 
	}

}
