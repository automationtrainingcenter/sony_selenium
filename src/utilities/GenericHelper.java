package utilities;

import java.io.File;

public class GenericHelper {

	public static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir")+File.separator+folderName+File.separator+fileName;
	}

}