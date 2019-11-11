package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHelper {

	protected static WebDriver driver;

	public static void openBrowser(String browserName, String url) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", GenericHelper.getFilePath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", GenericHelper.getFilePath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("invalid browser name");
		}
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void closeBrowser() {
		if (driver.getWindowHandles().size() > 1) {
			driver.quit();
		} else {
			driver.close();
		}
	}

	public static void sleep(long timeInMills) {
		try {
			Thread.sleep(timeInMills);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		openBrowser("chrome", "http://www.google.com");
		sleep(5000);
		closeBrowser();
	}
}
