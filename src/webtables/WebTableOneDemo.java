package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class WebTableOneDemo extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (wait.until(ExpectedConditions.titleContains("Practice"))) {
			// locate table body
			WebElement tbody = driver.findElement(By.cssSelector("#product>tbody"));
			// locate all the rows inside the table body using tr tag
			List<WebElement> rows = tbody.findElements(By.tagName("tr"));
			// iterate over every row which contains actual table data
			for (int i = 1; i < rows.size(); i++) {
				// locate all the cells inside the every tr tag using td tag
				List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
				// iterate over the cells which contains table data and automate them
				for (int j = 0; j < cells.size(); j++) {
					// get the inner text of the every cell and print on the console
					String text = cells.get(j).getText();
					System.out.print(text+"\t");
				}
				System.out.println();
			}
			
			closeBrowser();
			

		}
	}

}
