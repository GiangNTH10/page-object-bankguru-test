package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageFactory extends AbstractPage{
	
private WebDriver driver;
	
	@FindBy(how = How.XPATH,using = "//input[@name='emailid']")
	private WebElement emailTextbox;
	
	@FindBy(how = How.XPATH,using = "//input[@name='btnLogin']")
	private WebElement submitButton;
	
	@FindBy(how = How.XPATH,using = "//td[text()='User ID :']/following-sibling::td")
	private WebElement userIDText;
	
	@FindBy(how = How.XPATH,using = "//td[text()='Password :']/following-sibling::td")
	private WebElement passwordText;

	public RegisterPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		emailTextbox.sendKeys(email);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, submitButton);
		submitButton.click();	
	}

	public String getUserNameInformation() {
		waitForElementVisible(driver, userIDText);
		return userIDText.getText();
	}

	public String getPasswordInformation() {
		waitForElementVisible(driver, passwordText);
		return passwordText.getText();
	}

	public void openLoginPage(String loginPageUrl) {
		openUrl(driver, loginPageUrl);		
	}
}
