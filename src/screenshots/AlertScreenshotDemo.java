package screenshots;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class AlertScreenshotDemo extends BrowserHelper {

	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (wait.until(ExpectedConditions.titleContains("Practice"))) {

			// locate alert button which will open an alert and click on it
			driver.findElement(By.id("alertbtn")).click();

			// to capture the screenshot of alerts we have to use java Robot class
			// create an object Robot class
			try {
				Robot r = new Robot();
				// createScreenCapture()
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				Rectangle rect = new Rectangle(dim);
				BufferedImage bi = r.createScreenCapture(rect);
				File desImg = new File(".\\screenshots\\alertimage.png");
				ImageIO.write(bi, "png", desImg);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		driver.switchTo().alert().accept();
		closeBrowser();
	}

}
