package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// locate enter your name text field
		WebElement nameField = driver.findElement(By.id("name"));

		// enter some name in the above element
		nameField.sendKeys("sunshine");

		Thread.sleep(2000);

		// locate alert button and click on it
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);

		/*
		 * switch the driver focus from web page to alert to switch the focus in
		 * WebDriver interface we have switchTo() which returns TargetLocator interface
		 * reference in this TargetLocator interface we have alert() which return Alert
		 * interface reference.
		 */
//		TargetLocator tl = driver.switchTo();
//		Alert alert = tl.alert();
		Alert alert = driver.switchTo().alert();
		// retrieve the alert text and print on the console
		System.out.println("alert text is " + alert.getText());

		// click on OK button of the alert using accept() of Alert interface
		alert.accept();

		Thread.sleep(2000);

		// enter some other name in the enter your name text filed
		nameField.sendKeys("selenium");
		Thread.sleep(2000);

		// locate confirm button and click on it
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);

		// switch the driver focus to confirm alert and click on cancel button
		Alert confirmAlert = driver.switchTo().alert();

		// retrieve the alert text using getText() of Alert and print on the console
		System.out.println("confirm alert text is " + confirmAlert.getText());

		// click on cancel button of the alert using dismiss() of the Alert
		confirmAlert.dismiss();
		Thread.sleep(2000);

		driver.close();
	}

}
