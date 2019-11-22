package utilities;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotHelper {
	private static String getDataTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd_MMM_yy-HH_mm_ss");
		return df.format(date);
	}

	public static void captureScreenshot(WebDriver driver, String folderName, String fileName) {
		// create TakesScreenshot object reference
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File desImg = new File(GenericHelper.getFilePath(folderName, fileName + getDataTime() + ".png"));
		try {
			FileHandler.copy(srcImg, desImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void captureScreenshot(String folderName, String fileName) {
		try {
			Robot r = new Robot();
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(dim);
			BufferedImage bi = r.createScreenCapture(rect);
			File desImg = new File(GenericHelper.getFilePath(folderName, fileName + getDataTime() + ".png"));
			ImageIO.write(bi, "png", desImg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
