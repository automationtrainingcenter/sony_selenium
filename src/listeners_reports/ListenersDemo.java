package listeners_reports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * WebDriverEventListener is an interface which contains several methods 
 * 1. create a class which will implement this interface
 * 2. create an object of Listener class we created in first step
 * 3. EventFiringWebDriver is the class which fire the events an our listener will listen to that event
 * create an object EventFiringWebDriver class object
 * 4. register Listener class object to EventFiringWebDriver class object
 * 
 */

public class ListenersDemo {
	WebDriver driver;
	EventFiringWebDriver edriver;
	
	// launch browser
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		
		MyListener listenerObj = new MyListener();
		edriver = new EventFiringWebDriver(driver);
		edriver.register(listenerObj);
		driver = edriver;
		
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	// login
	public void login() {
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
//		System.out.println("locating an element using texuId");
//		System.out.println("entered Admin in that field");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
	}
	
	// role creation
	public void roleCreation() {
		driver.findElement(By.cssSelector("a[href *= 'Roles']")).click();
		driver.findElement(By.id("btnRoles")).click();
		driver.findElement(By.id("txtRname")).sendKeys("newRoleOne");
		Select roleType = new Select(driver.findElement(By.id("lstRtypeN")));
		roleType.selectByVisibleText("E");
		driver.findElement(By.id("btninsert")).click();
		Alert alert = edriver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();	
	}
	
	// logout
	public void logout() {
		driver.findElement(By.cssSelector("a[href *= 'primusbank']")).click();
	}
	
	// close browser
	public void closeBrowser() {
		driver.close();
	}
	
	public static void main(String[] args) {
		ListenersDemo obj = new ListenersDemo();
		obj.launchBrowser();
		obj.login();
		obj.roleCreation();
		obj.logout();
		obj.closeBrowser();
	}
	

}
