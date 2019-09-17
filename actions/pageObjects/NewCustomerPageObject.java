package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage {

	WebDriver driver;

	public NewCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void clearValueInNameField() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		clearValueInElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
	}

	public void pressTABNameAndMoveNextField() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);
	}

	public boolean isCustomerNameErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
		String actualText = getTextElement(driver, NewCustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void enterValueInNameField(String customerNameNumericValue) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerNameNumericValue);
	}

	public void clearValueInAddressField() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		clearValueInElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
	}

	public boolean isAddressErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_ERROR_MESSAGE);
		String actualText = getTextElement(driver, NewCustomerPageUI.ADDRESS_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void pressTABAddressAndMoveNextField() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyboardToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, Keys.TAB);
	}

	public void enterValueInAddressField(String addressFirstCharacterAsSpaceValue) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendkeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, addressFirstCharacterAsSpaceValue);
	}

	public void clearValueInCityField() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		clearValueInElement(driver, NewCustomerPageUI.CITY_TEXTBOX);

	}

	public void pressTABCityAndMoveNextField() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, Keys.TAB);

	}

	public boolean isCityErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_ERROR_MESSAGE);
		String actualText = getTextElement(driver, NewCustomerPageUI.CITY_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void enterValueInCityField(String customerCityNumericValue) {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, customerCityNumericValue);
	}

	public void clearValueInStateField() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		clearValueInElement(driver, NewCustomerPageUI.STATE_TEXTBOX);
	}

	public void pressTABStateAndMoveNextField() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, Keys.TAB);
	}

	public boolean isStateErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_ERROR_MESSAGE);
		String actualText = getTextElement(driver, NewCustomerPageUI.STATE_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void enterValueInStateField(String customerStateNumericValue) {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, customerStateNumericValue);
	}

	public void enterValueInPINField(String pINNumericValue) {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, pINNumericValue);
	}

	public boolean isPINErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_ERROR_MESSAGE);
		String actualText = getTextElement(driver, NewCustomerPageUI.PIN_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void clearValueInPINField() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		clearValueInElement(driver, NewCustomerPageUI.PIN_TEXTBOX);
	}

	public void pressTABPINAndMoveNextField() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, Keys.TAB);
	}

	public void enterValueInDateOfBirthField(String dateOfBirthValue) {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirthValue);
	}

	public void enterValueInMobileNumberInField(String mobileNumber) {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, mobileNumber);
	}

	public void enterValueInEmailField(String emailCustomer) {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, emailCustomer);
	}

	public void enterValueInPasswordField(String passwordCustomer) {
		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, passwordCustomer);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
	}

	public String getCustomerID() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_ID_LABEL);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_ID_LABEL);
	}

	public void clearValueInTelephoneField() {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		clearValueInElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
	}

	public void pressTABTelephoneAndMoveNextField() {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, Keys.TAB);
	}

	public boolean isTelephoneErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_ERROR_MESSAGE);
		String actualText = getTextElement(driver, NewCustomerPageUI.MOBILE_NUMBER_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void enterValueInTelephoneField(String telephoneFirstCharacterBlankValue) {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, telephoneFirstCharacterBlankValue);
	}

	public void clearValueInEmailField() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		clearValueInElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
	}

	public void pressTABEmailAndMoveNextField() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, Keys.TAB);
	}

	public boolean isEmailErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_ERROR_MESSAGE);
		String actualText = getTextElement(driver, NewCustomerPageUI.EMAIL_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public EditCustomerPageObject navigateToEditCustomerPage() {
		waitForElementVisible(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		return PageGeneratorManager.getEditCustomerPage(driver);
	}

}
