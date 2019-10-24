package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 1. to(String arg): is used to navigate to a url specified as String value
2. to(URL arg) : is used to navigate to a url specified as  a URL class object
the first to method which accept url as string argument will not verify
the url format at compile time but 2nd method will verify url format
at compile time
3. back() is used to automate back button of the browser window
4. forward() is used to automate forward button of the browser window
5. refresh() is used to automate refresh button of the browser window 
 */
public class NavigationCommands {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// create a Navigation interface reference
		Navigation nav = driver.navigate();

		// to(String url)
		nav.to("http://www.google.com");
		Thread.sleep(2000);

		// to(URL arg)
		try {
			URL urlObj = new URL("http://www.gmail.com");
			nav.to(urlObj);
		} catch (MalformedURLException e) {
			System.out.println("url is in wrong format");
		}
		Thread.sleep(2000);

		// back()
		nav.back(); // page will navigate to google page
		Thread.sleep(2000);

		// forward()
		nav.forward(); // page will navigate to gmail page
		Thread.sleep(2000);

		// refresh() // page will refresh the gmail page
		nav.refresh();
//		driver.navigate().refresh();
		Thread.sleep(2000);

		driver.close();
	}
}
