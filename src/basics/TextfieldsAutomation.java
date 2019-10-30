package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextfieldsAutomation {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		// locate first name field and type some data
//		WebElement firstnameEle = driver.findElement(By.name("firstname"));
//		firstnameEle.sendKeys("sunshine");
		driver.findElement(By.name("firstname")).sendKeys("sunshine");
		Thread.sleep(2000);
		
		// locate surname field and type some data
		driver.findElement(By.name("lastname")).sendKeys("selenium");
		Thread.sleep(2000);
		
		// locate email address and type email address
		driver.findElement(By.name("reg_email__")).sendKeys("atcsurya@gmail.com");
		Thread.sleep(2000);
		
		// locate reenter email address and type same email address as above
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("atcsurya@gmail.com");
		Thread.sleep(2000);
		
		// locate password and type some data
		driver.findElement(By.name("reg_passwd__")).sendKeys("password");
		Thread.sleep(2000);
		
		// close the browser
		driver.close();
	}

}
