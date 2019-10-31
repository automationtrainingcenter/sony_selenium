package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
/*
 * To automate drop down list or list box selenium provide Select class
 * with several methods
 * 
 * 1. selectByVisibleText(String arg) -- selects an option
based on inner text 

2. selectByValue(String arg) -- selects an option based 
on value of the value attribute
<option value = 'bmw'>BMW</option>

Note In above option tag 'bmw' is value and BMW is 
inner text

3. selectByIndex(int arg) -- selects an option based on 
index number of the option and index number starts with 0

4. getOptions() -- List<WebElement> returns all the options
of the given select tag as list of type WebElement

5. getFirstSelectedOption() - WebElement : returns first 
selected or default selected option of a select tag

6. getAllSelectedOptions() - List<WebElement> returns 
selected options as a list of type WebElement

7. isMultiple() - returns true if given select tag is 
list box instead of dropdown list

8. deselectByIndex(int arg) -- deselects an option based on 
index number of the option

9. deselectByValue(String arg) -- deselect an option based
on the value of the value attribute

10. deselectByVisibleText(String arg) -- deselects an option
based on the inner text of the option tag

11. deselectAll() -- deselects all the selected options
 
Note: first six methods we can use on both list box and
drop down list but last 5 methods we can use only on list box
 
 */

public class DropdownListDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();

		// locate date drop down list
		WebElement dateElement = driver.findElement(By.id("day"));
		// create a Select class object
		Select dateSelect = new Select(dateElement);
		// print number of date options
		List<WebElement> dateOptions = dateSelect.getOptions();
		System.out.println("number of date options are " + dateOptions.size());
		// get the default date and print on the console
		WebElement defaultDateEle = dateSelect.getFirstSelectedOption();
		System.out.println("default date is " + defaultDateEle.getText());
		// select a date based on index
		dateSelect.selectByIndex(7);
		Thread.sleep(2000);

		// locate month drop down list
		WebElement monthElement = driver.findElement(By.id("month"));
		// create a select class object
		Select monthSelect = new Select(monthElement);
		// get the default month and print on the console
		WebElement defaultMonthEle = monthSelect.getFirstSelectedOption();
		System.out.println("default month is " + defaultMonthEle.getText());
		// select a month based on the value of value attribute
		monthSelect.selectByValue("4");
		Thread.sleep(2000);

		// locate year drop down list
		WebElement yearElement = driver.findElement(By.id("year"));
		// create a select class object
		Select yearSelect = new Select(yearElement);
		// print number of options in year
		List<WebElement> yearOptions = yearSelect.getOptions();
		System.out.println("number of year options are " + yearOptions.size());
		// get the default year and print on the console
		WebElement defaultYearEle = yearSelect.getFirstSelectedOption();
		System.out.println("default year is " + defaultYearEle.getText());
		// select on based on visible text i.e. inner text of the option
		yearSelect.selectByVisibleText("1981");
		Thread.sleep(2000);

		driver.close();
	}

}
