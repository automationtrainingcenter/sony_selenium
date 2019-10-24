package basics;
/*
1. get(String url): this method is used to navigate to a URL
specified as string argument

2. getTitle(): returns title of the current web page as a String value
retruns inner text of the <title> tag which is inside the <head> tag
inner text means the text in between opening(<tag>) and closing(</tag>) tags

3. getCurrentUrl(): returns url of the current web page as a string

4. getPageSource(): returns complete source code of the current
web page as a String value

5. getWindowHandle(): returns id of the current browser window as a String value
Note: webdriver maintains unique id for every window opened by
the driver instance.

6. getWindowHandles(): retuns a set of String type which contains ids of the
browser windows opened by the driver instance

7. findElement(By arg): returns a WebElement reference this method will
locate an element in the current web page based on the locating technique we
specified using 'By' class and stores in a WebElement reference. If no
element is present in the page with locating technique then this method will
throw NoSuchElementException

8. findElements(By arg) returns a java.util.List of WebElement type this method
will locate either zero or more elements in the current web page based on the
locating technique we specified using 'By' class and store in
List<WebElement>. if no element is present in the page with locating
technique then this method will return a List of size 0.

9. close(): is used to close the current browser window

10. quit(): is used to close all the browser windows opened by driver instance
 */

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCommands {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// get(String url) is used to navigate to a url
		driver.get("http://www.facebook.com");
		
		// getTitle() returns title of the current web page
		String title = driver.getTitle();
		System.out.println("title of the page is "+title);
		
		// getCurrentUrl() returns url of the current web page
		String currentUrl = driver.getCurrentUrl();
		System.out.println("current url of the page is "+currentUrl);
		
		// getPageSource() return complete html source code of the page
		String pageSource = driver.getPageSource();
		System.out.println("page source contains given text "+pageSource.contains("Facebook helps you connect and share with the people in your life"));

		// getWindowHandle() returns unique id of the current browser window
		String windowID = driver.getWindowHandle();
		System.out.println("window id is "+windowID);
		
		// getWindowHandles() returns Set of String values which ids of 
		// windows opened by driver instance
		Set<String> windowIDs = driver.getWindowHandles();
		System.out.println("number of windows opened by driver instance "+windowIDs.size());
		
		// findElement(By arg) locates an elemnet in the page with given information and returns a WebElement reference
//		By id = By.id("email");
//		WebElement emailElement = driver.findElement(id);
		WebElement emailElement = driver.findElement(By.id("email"));
		
		
		// findElements(By arg) locates a List of type WebElement in a page
		By aTag = By.tagName("a");
		List<WebElement> links = driver.findElements(aTag);
		System.out.println("number of links in the page are "+links.size());
		
		// close() closes the current browser window
//		driver.close();
		
		// quit() closes all the browser windows opened by driver instance
		driver.quit();
		
	}
}
