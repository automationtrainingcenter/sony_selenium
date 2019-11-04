package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("E:/SSTS/sony/selenium_concepts/frames/framesDemo.html");
		driver.manage().window().maximize();

		// locate open windows button and click on it in main window
		driver.findElement(By.id("opentWin")).click();
		Thread.sleep(5000);

		// the above click will open multiple windows and get all the window ids using
		// getWindowHandles()
		Set<String> windowHandles = driver.getWindowHandles();
		// convert the above set to List so that we can recognize windows based on index
		// numbers
		List<String> windowIds = new ArrayList<String>(windowHandles);

		// now first automate google page
		driver.switchTo().window(windowIds.get(3));
		// now driver focus is in google window
		// locate search field and type some data and click enter
		driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
		Thread.sleep(3000);

		// now automate youtube window
		driver.switchTo().window(windowIds.get(2));
		// now driver focus is in youtube window
		// locate search field and type some data and click enter
		driver.findElement(By.id("search")).sendKeys("testng framework" + Keys.ENTER);
		Thread.sleep(3000);

		// now automate facebook page
		// switch the driver focus to facebook window
		driver.switchTo().window(windowIds.get(1));
		// now driver focus is in facebook window
		// locate email field and enter some data
		driver.findElement(By.id("email")).sendKeys("sunshine");
		// locate password field and type some data
		driver.findElement(By.id("pass")).sendKeys("password");
		Thread.sleep(3000);
		// locate signin button and click on it
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		Thread.sleep(3000);

		// now automate main window
		// switch the driver focus to main window
		driver.switchTo().window(windowIds.get(0));
		// now driver focus is in main window
		// locate open tabs button and click on it
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(5000);
		
		driver.quit();
	}

}
