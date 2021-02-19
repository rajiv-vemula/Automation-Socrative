package com.util;

import java.util.Properties;

public class CommonUtils {
	

	public static String getURL(String person)
	{
		Properties prop = ConfigReader.init_prop();
		String env = prop.getProperty("environment");
		String url = null;
		
		switch (env){
			case "Production":
				url = "b"; break;
				
			case "QA":
				url = "my-qa"; break;
				
			case "Development":
				url = "my-dev"; break;
				
			default: 
				System.out.println("Please enter correct Environment: "+env);
		}
		
		if(person.equals("Teacher")) {
			return "https://"+url+".socrative.com/teacher/";
		}
		else if (person.equals("Student")){
			return "https://"+url+".socrative.com/student/";
		}
		else return "Invalid Person" +person +" Please enter either Teacher or Student";
	}
	
	
}
