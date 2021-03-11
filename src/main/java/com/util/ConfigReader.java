package com.util;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private ConfigReader()
	{
		throw new IllegalStateException("Config Reader class");
	}
	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties object
	 */
	public static Properties initProp() {

		Properties prop = new Properties();
		
		try(FileInputStream ip = new FileInputStream("./src/java/resources/config/Config.properties")){
			prop.load(ip);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return prop;
	}
}
