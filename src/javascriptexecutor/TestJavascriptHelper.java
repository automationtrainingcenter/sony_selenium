package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;
import utilities.JavaScriptHelper;

public class TestJavascriptHelper extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		// locate enter your name text filed and type some data
		WebElement nameField = driver.findElement(By.id("name"));
		nameField.sendKeys("sunshine");
		sleep(3000);
		
		// getElementText()
		String nameFieldValue = JavaScriptHelper.getElementText(driver, nameField);
		System.out.println("name field value is "+nameFieldValue);
		
		// bringElementToView()
		// locate mouse hover element
		WebElement mouseHoverEle = driver.findElement(By.id("mousehover"));
		JavaScriptHelper.bringElementToView(driver, mouseHoverEle);
		sleep(4000);
		
		// scrollPageBy()
		JavaScriptHelper.scrollPageBy(driver, 0, -100);
		sleep(4000);
		
		closeBrowser();
	}

}
