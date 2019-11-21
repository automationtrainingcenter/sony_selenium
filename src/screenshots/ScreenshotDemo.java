package screenshots;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class ScreenshotDemo extends BrowserHelper {

	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (wait.until(ExpectedConditions.titleContains("Practice"))) {
			/*
			 * to take a screenshot selenium provides getScreenshotAs() in TakesScreenshot
			 * interface. Convert WebDriver object reference to the TakesScreenshot
			 * interface object reference.
			 */
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcImg = ts.getScreenshotAs(OutputType.FILE);
			File desImg = new File(".\\screenshots\\image3.png");
			// saving images using ImageIO class
//			try {
//				BufferedImage bi = ImageIO.read(srcImg);
//				ImageIO.write(bi, "png", desImg);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}


			// saving images using commons.io package and FileUtils class
			try {
				FileUtils.copyFile(srcImg, desImg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		closeBrowser();
	}

}
