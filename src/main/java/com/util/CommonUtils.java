package com.util;

import java.util.Properties;

public class CommonUtils {

	public static String getURL()
	{
		Properties prop = ConfigReader.init_prop();
		String env = prop.getProperty("environment");
		String url = null;
		
		if(env.equals("Production")) {
			url = "https://b.socrative.com/teacher/";
		}
		else if(env.equals("QA")) {
			url = "https://my-qa.socrative.com/teacher/";
		}
		else if(env.equals("Development")) {
			url = "https://my-dev.socrative.com/teacher/";
		}
		else {
			System.out.println("Please enter correct Environment: "+env);
		}
		
		return url;
	}
}
