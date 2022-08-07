package com.inetbanking.testCases;

import java.io.File;       
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;




 
public class BaseClass {
	//case #3
	ReadConfig readconfig=new ReadConfig();//import read utillties
	                       //now inwake the Readconfig.java contructor
	//case #1  AFTER CASE #3 mAKE CHANGE
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	//using testng annotations for setup method
	//this is the setup method and its reusable

	    //using @parameter annotations to achieve multiple browser test 
	@Parameters("browser")
	@BeforeClass
	  
	public void setup(String br) //setup()
	{
		/*
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver//chromedriver.exe");
		 driver=new ChromeDriver();*/
		
	     //Case #2
		//implemented the logger and used getlogger method to get
		logger=Logger.getLogger("ebanking");
		//using configure method to configure the log4j propertyfiles
	    PropertyConfigurator.configure("log4j.properties");
	 
	    if (br.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();          
		}else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
			driver=new EdgeDriver();	
		} 		
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//using wait statement
	    driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
		logger.info("Browser closed");
	}
     public void captureScreen(WebDriver driver,String tname) throws IOException{
    	 TakesScreenshot   ts = (TakesScreenshot) driver;
    	 File source =ts.getScreenshotAs(OutputType.FILE);
    	 File target = new  File(System.getProperty("user.dir")+ "/Screenshots/"+ tname+ ".png");
    	 FileUtils.copyFile(source, target);
    	 System.out.println("Screenshot taken");
     }

}
