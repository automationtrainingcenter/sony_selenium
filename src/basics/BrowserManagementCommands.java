package basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Window interface methods
which are used to manage browser window opened by driver instance

1. maximize(): which will maximizes the browser window
2. fullScreen(): which will full screen(F11 mode) the 
browser window
3. getSize(): returns Dimension class object i.e. the 
height and width of the browser window. 
Dimension class contains two methods getWidth() returns width
of the browser window and getHeight() returns height of the 
browser window.
4. getPosition(): returns position of the browser window
from top left corner of the screen as a Point class object.
Point class contains two methods, getX() returns x axis position 
and getY() returns Y asix position.
5. setSize(Dimestion arg): set the size of the browser window 
to the specified width and height using Dimension class object
6. setPosition(Point arg): set the position of the browser window
from the top left corner of the screen using Point class object 

 */
public class BrowserManagementCommands {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		Options manage = driver.manage();
		Window window = manage.window();
		
		// getSize() returns browser window height and width as a Dimension class object
		Dimension size = window.getSize();
		System.out.println("width = "+size.getWidth()+" height = "+size.getHeight());
		
		// getPosition() returns browser window position from the top left corner of the screen as
		// a Point class object
		Point position = window.getPosition();
		System.out.println("window at x = "+position.getX()+" and at y = "+position.getY());
		
		// maximize() which will maximizes browser window
//		driver.manage().window().maximize();
		window.maximize();
		Thread.sleep(2000);
		
		// fullScreen() which will full screen the browser window
		window.fullscreen();
		Thread.sleep(2000);
		
		// setSize(Dimension arg) which will set the browser window to the specified size
		// create Dimesion class object
		Dimension dim = new Dimension(700, 350);
		window.setSize(dim);
		Thread.sleep(2000);
		
		
		// setPosition(Point arg) which will set the browser window to the specified
		// position 
		// create Point class object
		Point pos = new Point(400, 200);
		window.setPosition(pos);
		Thread.sleep(2000);
		
		driver.close();
		
		
	}

}
