package screenshots;

import org.openqa.selenium.By;

import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

public class TestScreenshotHelper extends BrowserHelper {

	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");

		// normal screen capture without alert
//		ScreenshotHelper.captureScreenshot(driver, "screenshots", "practice");

		// screen capture with alert
		driver.findElement(By.id("alertbtn")).click();
		sleep(2000);
		ScreenshotHelper.captureScreenshot("screenshots", "alert");
		driver.switchTo().alert().accept();

		closeBrowser();

	}

}
