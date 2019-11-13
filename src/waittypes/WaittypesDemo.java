package waittypes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaittypesDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		/*
		 * WebDriver interface contains manage() which returns Options interface
		 * reference. In Options interface we have timeouts() which returns TimeOuts
		 * interface reference. This TimeOut interface contains different wait type
		 * methods
		 */
		
		// pageLoadTimeout()
//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		// implicitlyWait()
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.findElement(By.id("email")).sendKeys("sunshine");
//		driver.findElement(By.id("some id")).sendKeys("aljkdhkjadljf");
		
		// setScriptTimeout()
//		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("sunshine");
	
		driver.close();
	
	}

}
