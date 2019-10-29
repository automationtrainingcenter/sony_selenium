package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * The following are the methods of By class as per the prioirty of locating 
an element. All these methods are static methods so we can call them using
class name itself. All these methods accepts string arg and returns By class
reference

1. id(String arg) : returns a By class reference
it is used to locate an element using it's id attribute value.

2. name(String arg) : it is used to locate an element using it's name 
attribute value.
Note: if an element contains a dynamic id or does not contains an id or
duplicate name attribute then we can't locate those elements using id 
or name. so we have to use below techniques.
Dynamic ids are id attribute values which will change when ever we refresh
a web page.

If we are locating a link and that link does not contains unique id or name 
attribute then we can locate those links using following techniques

3. linkText(String arg): is used to locate a link using link text
link text is the inner text of the <a> tag
inner text means the text in between opening and closing tag
linktext means the text in between <a> and </a>

4. partialLinkText(String arg): is used to locate a link using part of 
the link text instead of complete link text

To locate any element otherthan links which does not contains unique id
or name attribute we can use following techniques

5. cssSelector(String arg): is used to locate any element using any 
attribute value
syntax:
	tagName[att_name = 'att_value']

6. xpath(String arg): is also used to locate any elmenet using any attribute
value
syntax: 
	"//tagName[@att_name = 'att_value']"

The below two methods are generally used to locate multiple elements

7. className(String arg) : is used to locate either single or multiple elements using
class name of the element.


8. tagName(String arg): is used to locate either single or multiple elements using 
name of the tag.
*/

public class LocatingTechniques {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		// locating an element using id attribute
//		By id = By.id("email");
//		WebElement emailField = driver.findElement(id);
		
		
		WebElement emailField = driver.findElement(By.id("email"));
		
		// locating an element using name attribute
		By name = By.name("firstname");
		WebElement firstNameField = driver.findElement(name);
		
		// locating an element using link text
		By linkText = By.linkText("Forgotten account?");
		WebElement forgottenAccountLink = driver.findElement(linkText);
		
		// locating an element using partial link text
		By partialLinkText = By.partialLinkText("ketpla");
		WebElement marketPlaceLink = driver.findElement(partialLinkText);
		
		// locating an element using css selector
		By cssSelector = By.cssSelector("input[value='1']");
		WebElement femaleRadioBtn = driver.findElement(cssSelector);
		
		
		// locating an element using xpath
		By xpath = By.xpath("//input[@value='2']");
		WebElement maleRadioBtn = driver.findElement(xpath);
		
		// locating elements using class name
		By className = By.className("inputtext");
		List<WebElement> inputFields = driver.findElements(className);
		System.out.println("number of input fileds are "+inputFields.size());
		
		// locating elements using tag name
		By tagName = By.tagName("a");
		List<WebElement> links = driver.findElements(tagName);
		System.out.println("number of links in the page are "+links.size());
		
		driver.close();
	}
}
