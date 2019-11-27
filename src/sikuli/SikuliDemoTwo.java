package sikuli;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utilities.GenericHelper;

public class SikuliDemoTwo {
	public static void main(String[] args) {
		// create Pattern class objects
		Pattern chrome = new Pattern(GenericHelper.getFilePath("images", "chrome.PNG"));
		Pattern address = new Pattern(GenericHelper.getFilePath("images", "address.PNG"));
		Pattern search = new Pattern(GenericHelper.getFilePath("images", "search.PNG"));
		Pattern close = new Pattern(GenericHelper.getFilePath("images", "close.PNG"));
		
		// create Screen class object
		Screen screen = new Screen();
		
		try {
			screen.click(chrome);
			Thread.sleep(5000);
			screen.type(address, "google.com"+Key.ENTER);
			Thread.sleep(4000);
			screen.find(search);
			screen.type(search, "sunshine techno system"+Key.ENTER);
			Thread.sleep(4000);
			screen.click(close);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
