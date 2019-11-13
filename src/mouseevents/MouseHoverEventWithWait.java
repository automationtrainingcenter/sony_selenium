package mouseevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class MouseHoverEventWithWait extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://www.firstcry.com/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if(wait.until(ExpectedConditions.urlContains("firstcry"))) {
			WebElement babyClothes = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".menu-container a[href *= 'newborn']")));
			Actions actions = new Actions(driver);
			actions.moveToElement(babyClothes).build().perform();
			WebElement babyGirl = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Baby Girl']")));
			actions.moveToElement(babyGirl).build().perform();
			WebElement partyWear = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title = 'Party Wear']")));
			actions.moveToElement(partyWear).click().build().perform();
		}
		sleep(5000);
		closeBrowser();
	}

}
