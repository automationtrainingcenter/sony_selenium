package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListBoxDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// locate fruits list box
		WebElement fruitsListBox = driver.findElement(By.id("multiple-select-example"));

		// create a Select class object
		Select fruitSelect = new Select(fruitsListBox);

		// select an option based on index
		fruitSelect.selectByIndex(2);
		Thread.sleep(2000);

		// select an option based on value
		fruitSelect.selectByValue("apple");
		Thread.sleep(2000);

		// select an option based on visible text
		fruitSelect.selectByVisibleText("Orange");
		Thread.sleep(2000);

		// get all the selected options and print on the console
		List<WebElement> allSelectedOptions = fruitSelect.getAllSelectedOptions();
		for (WebElement option : allSelectedOptions) {
			System.out.println(option.getText());
		}

		// deselect all the options in one shot
//		fruitSelect.deselectAll();
//		Thread.sleep(2000);

		// deselect an option based on index
		fruitSelect.deselectByIndex(0);
		Thread.sleep(2000);

		// deselect an option based on value
		fruitSelect.deselectByValue("orange");
		Thread.sleep(2000);

		// deselect an option based on visible text
		fruitSelect.deselectByVisibleText("Peach");
		Thread.sleep(2000);

		driver.close();

	}

}
