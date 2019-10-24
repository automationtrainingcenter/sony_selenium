package basics;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiBrowserDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver obj=null;
		System.out.println("enter browser name either chrome or firefox");
		Scanner sc = new Scanner(System.in);
		String browserName = sc.next();
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			// to launch chrome browser create ChromeDriver class object
			obj = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			obj = new FirefoxDriver();
		}else {
			System.out.println("invalid browser name");
		}
		obj.get("http://www.facebook.com");
		Thread.sleep(3000);
		obj.close();
	}

}
