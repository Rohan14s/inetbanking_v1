package com.inetbanking.utilities;

import java.io.File;   
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");// File is java class we import jave.io
		
		try {
			FileInputStream fis = new FileInputStream(src);//when you read data we use FileInputStream
		     pro=new Properties();
		     pro.load(fis);// load is the method which will load completed file of the config.properties
	    } catch (Exception e)   // file is miss here in some cases we use catch excepted method
		{
		System.out.println("Exception is "+ e.getMessage());
	   }	
	   }
	
    public String getApplicationURL() {
    	
		String url=pro.getProperty("baseURL");
		return url;	
	}
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
	}
	public String getChromePath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
    
    public String getFirefoxPath() {
    	String firefoxpath=pro.getProperty("firefoxpath");
    	return firefoxpath;
    }

    public String getEdgePath() {
    	String edgepath=pro.getProperty("edgepath");
    	return edgepath;
    }
}

    
   