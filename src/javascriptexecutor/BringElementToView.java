package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class BringElementToView extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.amazon.in");
		
		// locate back to top link
		WebElement navToTopLink = driver.findElement(By.id("navBackToTop"));
		
		// create a JavascriptExecutor object reference
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", navToTopLink);
		
		sleep(4000);
		js.executeScript("document.documentElement.scrollBy(0, -150)");
		sleep(4000);
		navToTopLink.click();
		sleep(3000);
		
		closeBrowser();
	}

}
