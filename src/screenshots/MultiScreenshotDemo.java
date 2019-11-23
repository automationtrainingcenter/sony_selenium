package screenshots;

import org.openqa.selenium.JavascriptExecutor;

import utilities.BrowserHelper;
import utilities.JavaScriptHelper;
import utilities.ScreenshotHelper;

public class MultiScreenshotDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.amazon.in");
		// create a JavascriptExecutor reference
		JavascriptExecutor js = (JavascriptExecutor)driver;
		long sh = (long) js.executeScript("return document.documentElement.scrollHeight");
		long vh = (long) js.executeScript("return document.documentElement.clientHeight");
		
		while(sh > 0) {
			ScreenshotHelper.captureScreenshot(driver, "screenshots", "multi");
			JavaScriptHelper.scrollPageBy(driver, 0, vh);
			sh -= vh;
		}
		
		closeBrowser();
	}

}
