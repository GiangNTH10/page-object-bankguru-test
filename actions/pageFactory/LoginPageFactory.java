package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageFactory extends AbstractPage{
	
	private WebDriver driver;
	
	@FindBy(how = How.XPATH,using = "//input[@name='uid']")
	private WebElement userIDTextbox;
	
	@FindBy(how = How.XPATH,using = "//input[@name='password']")
	private WebElement passwordTextbox;
	
	@FindBy(how = How.XPATH,using = "//input[@name='btnLogin']")
	private WebElement loginButton;
	
	@FindBy(how = How.XPATH,using = "//a[text()='here']")
	private WebElement hereLink;
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}

	public void clickToHereLink() {
		waitForElementVisible(driver, hereLink);
		hereLink.click();
	}

	public void inputToUserIDTextbox(String username) {
		waitForElementVisible(driver, userIDTextbox);
		userIDTextbox.sendKeys(username);
		
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);	
		passwordTextbox.sendKeys(password);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, loginButton);	
		loginButton.click();
	}
}
