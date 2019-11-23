package screenshots;

import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

public class TestMultipleScreenshotHelper extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		ScreenshotHelper.captureMultipleScreenshots(driver, "screenshots", "kodeit");
		closeBrowser();
	}

}
