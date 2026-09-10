package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtilities {

	public String readDataFromPropertyFiles(String key) throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream("./src/main/resources/credentials.properties");
	    Properties properties = new Properties();
	    properties.load(fileInputStream);
		String value = properties.getProperty(key);
	    return value;
	}	
}