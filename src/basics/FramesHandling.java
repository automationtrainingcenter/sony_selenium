package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		// locate hide/show text field
		WebElement hideShowField = driver.findElement(By.id("displayed-text"));
		
		// enter some data in that field
		hideShowField.sendKeys("sunshine");
		Thread.sleep(4000);
		
		// now driver focus is in main page
		// switch the driver focus to frame which we want to automate
		driver.switchTo().frame("courses-iframe");
		
		// after the above line driver focus is in frame
		// locate search courses text filed and search for ruby
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Thread.sleep(4000);
		
		// now driver focus is in frame 
		// switch the driver focus from frame to main page
		driver.switchTo().defaultContent();
		
		// after the above line driver focus is in main page
		// clear the content of the hide and show field which we entered previously
		hideShowField.clear();
		Thread.sleep(4000);
		
		driver.close();
		
	}

}
