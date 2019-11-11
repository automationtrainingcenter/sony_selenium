package mouseevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

public class MouseHoverEvent extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "https://www.firstcry.com/");
		sleep(3000);
		WebElement babyClothes = driver.findElement(By.cssSelector(".menu-container a[href *= 'newborn']"));
		WebElement babyGirl = driver.findElement(By.cssSelector("a[title='Baby Girl']"));

		/*
		 * to perform any mouse events selenium provides Actions class with several
		 * methods we can combine multiple actions together and create a composite
		 * action using build() then we can perform that composite using perform()
		 */

		// create an object of Actions class
		Actions actions = new Actions(driver);

		// to perform mousehover even we have to use moveToElement() of Actions class
		actions.moveToElement(babyClothes).build().perform();
		sleep(2000);

		actions.moveToElement(babyGirl).build().perform();
		sleep(2000);

		WebElement partyWear = driver.findElement(By.cssSelector("a[title = 'Ethnic Wear']"));
		actions.moveToElement(partyWear).click().build().perform();
		sleep(5000);

		closeBrowser();
	}

}
