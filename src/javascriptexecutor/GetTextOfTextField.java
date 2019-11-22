package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class GetTextOfTextField extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		// locate enter your name text field
		WebElement nameField = driver.findElement(By.id("name"));
		// type some data into the name field
		nameField.sendKeys("sunshine");
		sleep(3000);
		
		// create a JavascriptExecutor interface reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// retrieve the data inside the enter your name text field
		String nameFieldValue = js.executeScript("return arguments[0].value", nameField).toString();
		System.out.println("name filed value is "+nameFieldValue);
		
		
		// locate hide or show text field
		WebElement hideOrShow = driver.findElement(By.id("displayed-text"));
		
		// type some data into the hide or show text filed using JavascriptExecutor 
		js.executeScript("arguments[0].value = arguments[1]", hideOrShow, "selenium");
		sleep(3000);
		
		// retrieve the data inside the hide or show text field
		String hideOrShowValue = js.executeScript("return arguments[0].value", hideOrShow).toString();
		System.out.println("hide or show text field value is "+hideOrShowValue);
		closeBrowser();
	}

}
