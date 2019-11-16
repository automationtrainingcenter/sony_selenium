package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class CalendarDemoOne extends BrowserHelper {
	public static void selectDate(WebElement tbody, String date) {
		// locate table rows
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		boolean status = false;
		for (int i = 0; i < rows.size(); i++) {
			// locate cells inside every row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			// iterate over every cell
			for (WebElement dateEle : cells) {
				// get the text of every date element and compare it with your date
				if (dateEle.getText().contains(date)) {
					// locate button tag inside the date element and click on it
					dateEle.findElement(By.tagName("button")).click();
					status = true;
					break; // cells loop
				}
			}
			if (status) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		openBrowser("chrome", "https://www.expedia.co.in/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// locate check-in date element and click on it
		driver.findElement(By.id("hotel-checkin-hp-hotel")).click();
		// the above click will open calendars, so locate calendar table body which we
		// want to autoate
		WebElement citbody = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//tbody[@class = 'datepicker-cal-dates'])[2]")));
		selectDate(citbody, "5");
		sleep(3000);

		// locate check-out date element and click on it
		driver.findElement(By.id("hotel-checkout-hp-hotel")).click();
		// the above click will open check out calendars, so locate calendar table body
		// which we want to automate
		WebElement cotbody = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tbody[@class='datepicker-cal-dates'])[2]")));
		selectDate(cotbody, "10");

		sleep(4000);
		closeBrowser();
	}

}
