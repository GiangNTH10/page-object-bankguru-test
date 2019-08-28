package commons;



import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractPage {
	
	/* Web Browser */
	
	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
	}
	
	public String getPageTile(WebDriver driver){
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	/* Web Element */
	
	public void clearValueInElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.clear();
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}
	
	public void selectItemInDropDown(WebDriver driver, String locator, String itemText) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(itemText);
	}
	
	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String allItemXpath, String expectedValueItem) throws InterruptedException {
		// Click vao dropdown cho xo het tat ca cac gia tri ra
		element = driver.findElement(By.xpath(parentXpath));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		// Cho cho tat ca cac gia tri trong dropdown duoc load thanh cong
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
		
		elements = driver.findElements(By.xpath(allItemXpath));
		
		// Duyet qua het tat ca cac phan tu cho den khi thoa man dieu kien
		for (WebElement childElement : elements) {
			System.out.println("Text moi lan get = " +childElement.getText());
			
			if (childElement.getText().contains(expectedValueItem)) {
				// Click vao item can chon
				if (childElement.isDisplayed()) {
					System.out.println("Click by Selenium = " +childElement.getText());
					childElement.click();
				}
				
				else
				{
				
					javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
					Thread.sleep(1000);
					System.out.println("Click by JS = " +childElement.getText());
					javascriptExecutor.executeScript("arguments[0].click();", element);
				}
				Thread.sleep(1000);
				break;
			}
		}
	}
	
	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}
	
	public String getTextElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	public int countElementNumber(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}
	
	public void checkToCheckbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	public boolean isControlSelected(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}
	
	public boolean isControlEnable(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	
	public void switchToChildWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				break;
			}
		}
	}
	
	public void switchToChildWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (!currentWin.equals(title)) {
				break;
			}
		}
	}
	
	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}
	
	public void hoverMouseToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		javascriptExecutor = (JavascriptExecutor) driver;
		return javascriptExecutor.executeScript(javaScript);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		javascriptExecutor = (JavascriptExecutor) driver;
		String textActual = (String) javascriptExecutor.executeScript("return document.doctumentElement.innerText.match('" +textExpected+ "')[0]");
		return textActual.equals(textExpected);
	}
	
	public boolean checkAnyImageLoaded(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) javascriptExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
		if(status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clickToElementByJS(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", element);
	}
	
	public void scrollToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollItoView(true);", element);
	}
	
	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].setAttribute('value','" + value + "')", element );
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("Windown.scrollBy(0,document.body.scrollHeight");
	}
	
	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}
	
	
	public void waitForElementPresence(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	public void waitForElementVisible(WebDriver driver, WebElement element) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		waitExplicit.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void waitForElementClickAble(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, longTimeout);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}
	
	private WebElement element;
	private List<WebElement> elements;
	private Select select;
	private JavascriptExecutor javascriptExecutor;
	private WebDriverWait waitExplicit;
	private Actions action;
	private By byLocator;
	long shortTimeout = 5;
	long longTimeout = 30;

	
	
	
	
	
	

}
