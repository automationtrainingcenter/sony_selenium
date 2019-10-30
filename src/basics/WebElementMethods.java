package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 1. click() is used to click on an element 

2. sendKeys(CharSequence arg) is used to type some data in a text field and text
area. This method will send data character by character.

3. clear() is used to clear existing data in the text field or text area.

4. getText() returns String value which is an inner text of the given element if any

5. submit() is used to submit a form to the server if that form submit button is
implemented using <input> tag

6. getAttribute(String att_name) returns a String which is attribute value of the given 
attribute name

7. getCssValue(String css_property_name) returns a String which is value of the 
given css property name

8. getSize() returns Dimension class object which is height and width of the given element

9. getLocation() returns Point class object which is x and y coordinate values of the element
in the web page from top left cornor

10. getTagName() returns name of the tag of given element

11. findElement(By arg) returns WebElement interface reference this method will
locate an element in the GIVEN ELEMENT based on the locating technique we
specified using 'By' class and stores in a WebElement reference. If no
element is present in the page with locating technique then this method will
throw NoSuchElementException

12. findElements(By arg) returns a java.util.List of WebElement type this method
will locate either zero or more elements in the GIVEN ELEMENT based on the
locating technique we specified using 'By' class and store in
List<WebElement>. if no element is present in the page with locating
technique then this method will return a List of size 0.

13. isDisplayed() returns true if given element is displayed in the web page

14. isEnabled() returns true if given element is in active mode or enabled mode

15. isSelected() returns true if given option of either dropdown list or list box or 
radio button or check box is selected.

 */

public class WebElementMethods {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		// sendkeys() is used to type some data in a text filed
		WebElement firstNameEle = driver.findElement(By.name("firstname"));
		firstNameEle.sendKeys("sunshine");
		Thread.sleep(3000);
		
		// click() is used to click on any element
		// locate female radio button
		WebElement femaleRadioBtn = driver.findElement(By.cssSelector("input[value='1']"));
		femaleRadioBtn.click();
		Thread.sleep(3000);
		
		// clear() is used to remove the existing data in a text field
		firstNameEle.clear();
		Thread.sleep(3000);
		
		// getText() is used to retrieve the inner text of the element
		WebElement signupBtn = driver.findElement(By.name("websubmit"));
		String signUpBtnText = signupBtn.getText();
		System.out.println(signUpBtnText);

		// getAttribute() is used to retrieve the value of the given attribute of a element
		String attributeValue = firstNameEle.getAttribute("aria-label");
		System.out.println("aria-label attribute value is "+attributeValue);
		
		System.out.println("type attribute value is "+femaleRadioBtn.getAttribute("type"));
		
		// getCssValue() is used to return value of given css property
		String borderRadiusCssValue = signupBtn.getCssValue("border-radius");
		System.out.println(borderRadiusCssValue);
		
		
		// getSize() is used to return size of the element as a Dimension class object
		Dimension size = signupBtn.getSize();
		System.out.println("signup button width is "+size.getWidth()+" and height is "+size.getHeight());
		
		// getLocation() is used to return location of the element from top left corner of the page as a Point class object
		Point location = firstNameEle.getLocation();
		System.out.println("first name element is at x = "+location.getX()+" and at y = "+location.getY());
		
		// getTagName() is used to return tag name of the elmenet
		String signUpBtnTagName = signupBtn.getTagName();
		System.out.println("sign up button tag name is "+signUpBtnTagName);
		
		
		// isDiplayed() will return true if given element is visible on the web page
		boolean reenterEmailIsDisplayed = driver.findElement(By.name("reg_email_confirmation__")).isDisplayed();
		System.out.println("re enter email field is displayed "+reenterEmailIsDisplayed);
		
		
		// isEnabled() will return true if given element is in enable mode
		boolean signUpEnabled = signupBtn.isEnabled();
		System.out.println("sing up button is in enable mode "+signUpEnabled);
		
		
		// isSelected() will return true if given radio button or check box is selected
		boolean femaleRadioButtonIsSelected = femaleRadioBtn.isSelected();
		System.out.println("female radio button is selected "+femaleRadioButtonIsSelected);
		
		// submit() is used to submit a form to the server from any element in the form
		driver.findElement(By.id("email")).submit();
		Thread.sleep(3000);
		driver.close();
	}

}
