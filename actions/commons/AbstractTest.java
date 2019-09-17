package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	private WebDriver driver;

	public WebDriver openMuiltiBrowser(String browserName) {
		String rootFolder = System.getProperty("user.dir");

		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("chromeheadless")) {
			System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("Window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else {
			System.out.println("Please choose your browser name in TestNG xml file");
		}
		System.out.println("Driver ID at Abstract Test:" + driver.toString());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/index.php");
		return driver;
	}

}
