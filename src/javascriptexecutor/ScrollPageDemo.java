package javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;

import utilities.BrowserHelper;

public class ScrollPageDemo extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");

		// create JavascriptExecutor interface reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.documentElement.scrollBy(0, arguments[0])", 500);
		sleep(3000);

		js.executeScript("document.documentElement.scrollBy(0, arguments[0])", -200);
		sleep(3000);

		/*
		 * document.documentElement.scrollHeight will return the scroll height of the
		 * web page document.documentElement.clientHeight will return the view height of
		 * the web page
		 */
		closeBrowser();

	}

}
