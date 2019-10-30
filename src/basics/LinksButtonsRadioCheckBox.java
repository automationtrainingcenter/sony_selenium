package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksButtonsRadioCheckBox {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// locate bmw radio button and click on it
		driver.findElement(By.id("bmwradio")).click();
		Thread.sleep(2000);

		// locate honda radio button and click on it
		driver.findElement(By.id("hondaradio")).click();
		Thread.sleep(2000);

		// locate benz check box and click on it
		driver.findElement(By.id("benzcheck")).click();
		Thread.sleep(2000);

		// locate honda check box and click on it
		driver.findElement(By.id("hondacheck")).click();
		Thread.sleep(2000);

		// locate hide button and click on it
		driver.findElement(By.id("hide-textbox")).click();
		Thread.sleep(2000);

		// locate login link and click on it
		driver.findElement(By.partialLinkText("Login")).click();
		Thread.sleep(2000);

		driver.close();
	}

}
