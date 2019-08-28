package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject  extends AbstractPage{
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

	public void navigateToNewCustomerPage() {
		waitForElementVisible(driver, HomePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINK);
	}

	public void navigateToEditCustomerPage() {
		waitForElementVisible(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.EDIT_CUSTOMER_LINK);
	}

}
