package basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunchDemo {
	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\softwares\\drivers\\chromedriver.exe");
//
//		// to launch chrome browser create ChromeDriver class object
//		ChromeDriver obj = new ChromeDriver();

		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\softwares\\drivers\\geckodriver.exe");
		// to launch firefox browser create FirefoxDriver class object
		FirefoxDriver fobj = new FirefoxDriver();
		
	}

}
