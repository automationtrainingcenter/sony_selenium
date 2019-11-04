package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiFramesDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/SSTS/sony/selenium_concepts/frames/framesDemo.html");
		driver.manage().window().maximize();
		
		// driver focus is in main page
		// automate frame 4 which is an inner frame of frame 3
		// so first switch the driver focus from main page to frame 3
		driver.switchTo().frame("fthree");
		// now driver focus is in frame 3
		// switch to frame 4
		driver.switchTo().frame(0);
		// now driver focus is in frame 4
		// locate custom search field and type some data
		driver.findElement(By.id("gsc-i-id2")).sendKeys("selenium");
		Thread.sleep(3000);
		
		
		// automate frame 3 which is a parent frame of frame 4
		// now driver focus is in frame 4
		// we can switch the driver focus from frame4 to frame 3 using parentFrame()
		driver.switchTo().parentFrame();
		// now driver focus is in frame 3
		// locate click here button and click on it
		driver.findElement(By.id("click")).click();
		Thread.sleep(3000);
		
		
		// automate frame 2
		// now driver focus is in frame 3
		// so first switch driver focus to main page using defaultContent()
		driver.switchTo().defaultContent();
		// switch the driver focus from main page to frame 2 using frame()
		driver.switchTo().frame("ftwo");
		// now driver focus is in frame2
		driver.findElement(By.linkText("selenium official site")).click();
		Thread.sleep(3000);
		
		
		//automate frame 1
		// now driver focus is in frame 2
		// so first switch the driver focus to main page using defaultContent()
		driver.switchTo().defaultContent();
		// now driver focus is in main page
		// switch the driver focus to frame 1
		driver.switchTo().frame("fone");
		// now driver focus is in frame1
		driver.findElement(By.xpath("//input[@placeholder='Enter name']")).sendKeys("sunshine");
		Thread.sleep(3000);
		
		
		// automate main page
		// now driver focus is in frame 1
		// switch the driver focus to main page using defaultContent()
		driver.switchTo().defaultContent();
		// now driver focus is in main page
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(5000);
		
		driver.quit();
		
	}
}
