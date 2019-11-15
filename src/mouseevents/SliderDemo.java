package mouseevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class SliderDemo extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "https://jqueryui.com/slider/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// switch to frame which contains slider elements
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0)); // driver.switchTo().frame(0)
		// now the driver focus is in frame
		// locate slider head
		WebElement sliderHead = driver.findElement(By.cssSelector(".ui-slider-handle"));
		// create Actions class object
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(sliderHead, 250, 0).build().perform();
		sleep(3000);
		actions.clickAndHold(sliderHead).moveByOffset(-150, 0).release().build().perform();
		sleep(3000);
		closeBrowser();
	}

}
