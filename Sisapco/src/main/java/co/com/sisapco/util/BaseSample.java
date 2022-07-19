package co.com.sisapco.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseSample {
	protected static Properties loadApiSettings() throws IOException {		
		Properties prop = new Properties();
		//String propFilename = "api_settings.properties"; 
		String propFilename = "application.properties";
		InputStream inputStream = BaseSample.class.getClassLoader().getResourceAsStream(propFilename);		 
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFilename + "' not found in the classpath");
		}
		
		return prop;
	}
}