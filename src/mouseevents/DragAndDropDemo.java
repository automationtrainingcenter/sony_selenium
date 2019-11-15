package mouseevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class DragAndDropDemo extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "https://jqueryui.com/droppable/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// switch to frame which contains drag and drop elements
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		// driver focus is in frame
		// locate drag element
//		WebElement dragEle = driver.findElement(By.id("draggable"));
		WebElement dragEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
		// locate drop element
		WebElement dropEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));
		// create Actions class object
		Actions actions = new Actions(driver);
		// perform drag and drop action
//		actions.clickAndHold(dragEle).moveToElement(dropEle).release().build().perform();
		actions.dragAndDrop(dragEle, dropEle).build().perform();
		sleep(3000);
		closeBrowser();
	}

}
