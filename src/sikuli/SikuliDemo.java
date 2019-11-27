package sikuli;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utilities.GenericHelper;

/*Sikuli is a tool to automate GUI using visual image macth. In sikuli all web elements should be
* taken as images and store in project folder.
* Download and install sikuliX from http://sikulix.com. if you are using sikuli version below or equal to
* sikuli 1.1.3
* from sikuli version 2 onwards we can directly download sikulixapi.jar file
* Associate sikulixapi.jar file to project build path.
* Capture images of elements using any snipping tool which we want to automate and stroe in project folder.
*
* Sikuli mainly provides two classes
* Screen -- is the main class which will perform all the operations like type, find, click, wait and so on.
* Pattern -- is used to store the images of elements we want to automate.
*/

public class SikuliDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://smallpdf.com/word-to-pdf");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// locate choose file link and click on it
		driver.findElement(By.xpath("//div[text() ='Choose file']")).click();
		// the above click will open a window screen
		// to automate that window screen we are going use sikulixapi

		// create Pattern class objects for each image we captured
		Pattern fileName = new Pattern(GenericHelper.getFilePath("images", "filename.PNG"));
		Pattern openBtn = new Pattern(GenericHelper.getFilePath("images", "openBtn.PNG"));

		// create Screen class object
		Screen screen = new Screen();
		
		
		// perform actions using Screen class object on Pattern class objects
		try {
			screen.find(fileName);
			screen.type(fileName, "E:\\SMIT\\Software Testing Syllabus.doc");
			screen.find(openBtn);
			screen.click(openBtn);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// close the browser
        Thread.sleep(2000);
        driver.close();
	}
}
