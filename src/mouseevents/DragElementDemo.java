package mouseevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class DragElementDemo extends BrowserHelper {

	public static void main(String[] args) {
		openBrowser("chrome", "https://jqueryui.com/draggable/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		// now driver is in frame
		WebElement dragEle = driver.findElement(By.id("draggable"));
		// create Actions class object
		Actions actions = new Actions(driver);
		// automate dragging of element
//		actions.clickAndHold(dragEle).moveByOffset(100, 100).release().build().perform();
		actions.dragAndDropBy(dragEle, 100, 100).build().perform();
		sleep(3000);
		closeBrowser();
	}

}
