package com.util;

import java.util.Properties;

import com.Factory.DriverFactory;

public class CommonUtils {
	
	protected static Properties prop = ConfigReader.init_prop();

	public static String getURL(String person)
	{	
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
	
	public static void getStudentDriver()
	{
		DriverFactory driverFactory = new DriverFactory();
		String browser = prop.getProperty("StudentBrowser");
		driverFactory.init_driver(browser);
	}
}
