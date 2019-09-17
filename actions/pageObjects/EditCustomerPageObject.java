package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.EditCustomerPageUI;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void clearValueInCustomerIDField() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		clearValueInElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
	}

	public void pressTABNameAndMoveNextField() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, Keys.TAB);
	}

	public boolean isCustomerIDErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_ERROR_MESSAGE);
		String actualText = getTextElement(driver, EditCustomerPageUI.CUSTOMER_ID_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void enterValueInCustomerIDField(String customerIDNotNumeric) {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendkeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerIDNotNumeric);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, EditCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);
	}

	public boolean isEditCustomerPageDisplayed(String expectedText) {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_NAME_LABEL);
		String actualText = getTextElement(driver, EditCustomerPageUI.CUSTOMER_NAME_LABEL);
		return actualText.equals(expectedText);
	}

	public void clearValueInAddressField() {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTBOX);
		clearValueInElement(driver, EditCustomerPageUI.ADDRESS_TEXTBOX);
	}

	public boolean isAddressErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_ERROR_MESSAGE);
		String actualText = getTextElement(driver, EditCustomerPageUI.ADDRESS_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void pressTABAddressAndMoveNextField() {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.ADDRESS_TEXTBOX, Keys.TAB);
	}

	public void clearValueInCityField() {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		clearValueInElement(driver, EditCustomerPageUI.CITY_TEXTBOX);
	}

	public void pressTABCityAndMoveNextField() {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, Keys.TAB);
	}

	public boolean isCityErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_ERROR_MESSAGE);
		String actualText = getTextElement(driver, EditCustomerPageUI.CITY_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void enterValueInCityField(String cityNumericEdit) {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, cityNumericEdit);
	}

	public void clearValueInStateField() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		clearValueInElement(driver, EditCustomerPageUI.STATE_TEXTBOX);
	}

	public void pressTABStateAndMoveNextField() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, Keys.TAB);
	}

	public boolean isStateErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_ERROR_MESSAGE);
		String actualText = getTextElement(driver, EditCustomerPageUI.STATE_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void enterValueInStateField(String stateNumericEdit) {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		sendkeyToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, stateNumericEdit);
	}

	public void clearValueInPINField() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		clearValueInElement(driver, EditCustomerPageUI.PIN_TEXTBOX);
	}

	public void enterValueInPINField(String pINNumericEdit) {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		sendkeyToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, pINNumericEdit);
	}

	public boolean isPINErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_ERROR_MESSAGE);
		String actualText = getTextElement(driver, EditCustomerPageUI.PIN_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void pressTABPINAndMoveNextField() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, Keys.TAB);
	}

	public void clearValueInTelephoneField() {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		clearValueInElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
	}

	public void pressTABTelephoneAndMoveNextField() {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX, Keys.TAB);
	}

	public boolean isTelephoneErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_ERROR_MESSAGE);
		String actualText = getTextElement(driver, EditCustomerPageUI.MOBILE_NUMBER_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void enterValueInTelephoneField(String telephoneHaveSpecialCharacterEdit) {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX, telephoneHaveSpecialCharacterEdit);
	}

	public void clearValueInEmailField() {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		clearValueInElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
	}

	public void pressTABEmailAndMoveNextField() {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyboardToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, Keys.TAB);
	}

	public boolean isEmailErrorMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_ERROR_MESSAGE);
		String actualText = getTextElement(driver, EditCustomerPageUI.EMAIL_ERROR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void enterValueInEmailField(String emailInvalidFormatEdit1) {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, emailInvalidFormatEdit1);
	}

	public HomePageObject navigateToHomePage() {
		waitForElementVisible(driver, EditCustomerPageUI.MANAGER_LINK);
		clickToElement(driver, EditCustomerPageUI.MANAGER_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

}
