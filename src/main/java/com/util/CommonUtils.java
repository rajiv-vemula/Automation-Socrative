package com.util;

import java.util.Properties;

public class CommonUtils {
	

	public static String getURL()
	{
		Properties prop = ConfigReader.init_prop();
		String env = prop.getProperty("environment");
		String url = null;
		
		if(env.equals("Production")) {
			url = "b";
		}
		else if(env.equals("QA")) {
			url = "my-qa";
		}
		else if(env.equals("Development")) {
			url = "my-dev";
		}
		else {
			System.out.println("Please enter correct Environment: "+env);
		}
		
		return "https://"+url+".socrative.com/teacher/";
	}
	
}
