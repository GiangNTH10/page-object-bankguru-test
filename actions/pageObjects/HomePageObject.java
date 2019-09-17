package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;

	public HomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public boolean isWelcomeMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
		String actualText = getTextElement(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
		return actualText.equals(expectedText);
	}

	public boolean isUserIDDisplayed(String userID) {
		waitForElementVisible(driver, HomePageUI.USERID_TEXT);
		String actualText = getTextElement(driver, HomePageUI.USERID_TEXT);
		return actualText.contains(userID);

	}

	public NewCustomerPageObject navigateToNewCustomerPage() {
		waitForElementVisible(driver, HomePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINK);
		return PageGeneratorManager.getNewCustomerPage(driver);
	}

	public EditCustomerPageObject navigateToEditCustomerPage() {
		waitForElementVisible(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		return PageGeneratorManager.getEditCustomerPage(driver);
	}

	public Object openNewCustomerPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
