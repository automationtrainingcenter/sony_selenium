package listeners_reports;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.GenericHelper;
import utilities.ScreenshotHelper;

public class ReportsDemo {
	
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	ExtentHtmlReporter reporter;
	
	
	// launch browser
	public void launchBrowser() {
		// create an ExtentTest object
		test = reports.createTest("launch browser");
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		test.log(Status.INFO, "chrome brower launched");
		driver.get("http://primusbank.qedgetech.com/");
		test.log(Status.INFO, "browser navigate to "+driver.getCurrentUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.log(Status.PASS, "test case passed");
	}
	
	// login
	public void login() {
		test = reports.createTest("login");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		test.log(Status.INFO, "located user name field and entered Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		test.log(Status.INFO, "located password field and entered Admin");
		driver.findElement(By.id("login")).click();
		test.log(Status.INFO, "located login button and clicked");
		test.log(Status.PASS, "test case passed");
	}
	
	// role creation
	public void roleCreation() throws IOException {
		test = reports.createTest("role creation");
		driver.findElement(By.cssSelector("a[href *= 'Roles']")).click();
		test.log(Status.INFO, "located roles button and clicked");
		driver.findElement(By.id("btnRoles")).click();
		test.log(Status.INFO, "located new role button and clicked");
		driver.findElement(By.id("txtRname")).sendKeys("newRoleOne");
		test.log(Status.INFO, "located role name field and entered newRoleOne");
		Select roleType = new Select(driver.findElement(By.id("lstRtypeN")));
		roleType.selectByVisibleText("E");
		test.log(Status.INFO, "located role type and selected role type as E");
		driver.findElement(By.id("btninsert")).click();
		test.log(Status.INFO, "located submit button and clicked");
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		test.log(Status.INFO, "alert came as "+alert.getText());
		alert.accept();	
		test.log(Status.INFO, "alert accepted");
		String imgPath = ScreenshotHelper.captureScreenshot(driver, "screenshots", "report");
		System.out.println(imgPath);
		test.log(Status.FAIL, test.addScreenCaptureFromPath(imgPath)+"test case failed");
		
	}
	
	// logout
	public void logout() {
		test = reports.createTest("logout");
		driver.findElement(By.cssSelector("a[href *= 'primusbank']")).click();
		test.log(Status.INFO, "located logout button and clicked");
		test.log(Status.PASS, "test case passed");
	}
	
	// close browser
	public void closeBrowser() {
		test = reports.createTest("close browser");
		driver.close();
		test.log(Status.INFO, "browser closed");
		test.log(Status.PASS, "test case passed");
	}
	
	public static void main(String[] args) throws IOException {
		ReportsDemo obj = new ReportsDemo();
		obj.reporter = new ExtentHtmlReporter(GenericHelper.getFilePath("reports", "report.html"));
		obj.reporter.config().setTheme(Theme.DARK);
		obj.reporter.config().setDocumentTitle("primus bank reports");
		
		obj.reports = new ExtentReports();
		obj.reports.attachReporter(obj.reporter);
		obj.launchBrowser();
		obj.login();
		obj.roleCreation();
		obj.logout();
		obj.closeBrowser();
		obj.reports.flush();
	}
	

}
