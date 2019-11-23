package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class NSEIndiaDemoTwo extends BrowserHelper {

	public static void main(String[] args) {
		String companyCode = "TITAN";
		openBrowser("chrome",
				"https://www.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		// create a JavascriptExecutor interface reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// locate table body
		WebElement tbody = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#preOpenNiftyTab>tbody")));
		// locate all the rows inside the table body
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		// iterate over the rows which contains table data
		for (int i = 2; i < rows.size(); i++) {
			// locate all the cells inside every row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			// get the inner text of the first cell which contains company code
			if (cells.get(0).getText().equals(companyCode)) {
				// locate a link inside that cell and click on it
				WebElement comLink = cells.get(0).findElement(By.tagName("a"));
				js.executeScript("arguments[0].scrollIntoView()", comLink);
				sleep(4000);
				comLink.click();
				sleep(4000);
				break;
			}
		}
		closeBrowser();

	}

	

}
