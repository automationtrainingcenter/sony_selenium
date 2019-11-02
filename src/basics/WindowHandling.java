package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// locate open window button and click on it
//		driver.findElement(By.id("openwindow")).click();
		
		// locate open tab button and click on it
		driver.findElement(By.id("opentab")).click();
		Thread.sleep(4000);

		// the above click will open another new window
		// get all the window ids using getWindowHandles() of WebDriver interface
		Set<String> windowHandles = driver.getWindowHandles();
		/*
		 * the above set contains windows IDs of every window opened by driver instance
		 * Set does not maintain any order so to recognize windows we have to convert 
		 * Set to List
		 */
		List<String> windowIds = new ArrayList<>(windowHandles);
		/*
		 * the above contains all window ids, in List index 0 we have Parent window or main window
		 * in index 1 we have first child window, in index 2 we have 2nd child window and so on
		 * 
		 *  to automate child windows we have to switch the driver focus from main window to child
		 *  window using switchTo() of WebDriver interface which returns TargetLocator interface
		 *  reference and this interface contains window(String windowId) 
		 */
		// now the driver focus is in main window or parent window
		// we have to switch the driver focus to child window
		driver.switchTo().window(windowIds.get(1));
		
		// now the driver focus is in child window
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Thread.sleep(2000);
		
		// now switch driver focus back to the main window
		driver.switchTo().window(windowIds.get(0));
		
		// now the driver focus is in main window
		driver.findElement(By.id("name")).sendKeys("selenium");
		Thread.sleep(2000);
		
		// close browser
		driver.quit();
	}

}
