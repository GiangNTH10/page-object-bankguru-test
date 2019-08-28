package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageFactory extends AbstractPage{
	
private WebDriver driver;
	
	@FindBy(how = How.XPATH,using = "//marquee[@class='heading3']")
	private WebElement welcomeMessageText;
	
	@FindBy(how = How.XPATH,using = "//tr[@class='heading3']/child::td")
	private WebElement userIDText;
	
	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isWelcomeMessageDisplayed(String expectedText) {
		waitForElementVisible(driver, welcomeMessageText);
		String actualText = welcomeMessageText.getText().trim();
		return actualText.equals(expectedText);
	}

	public boolean isUserIDDisplayed(String userID) {
		waitForElementVisible(driver, userIDText);
		String actualText = userIDText.getText().trim();
		return actualText.contains(userID);
		
	}

	public void navigateToNewCustomerPage() {
		waitForElementVisible(driver, HomePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINK);
	}


}
