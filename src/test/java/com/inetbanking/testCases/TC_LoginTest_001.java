package com.inetbanking.testCases;
import java.io.IOException; 
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.Loginpage;



public class TC_LoginTest_001 extends BaseClass    //using extents keyword is to inherit the Baseclass
                                                 //we can access the baseclass methods from here
{
	
	
	@Test
	public void LoginTest() throws IOException
	{
		//remove here  use in baseclass
		//driver.get(baseURL);
		driver.manage().window().maximize();
	
		logger.info("URL is Opened");

		//creating the object Loginpage =lg parameter as a driver

		Loginpage lg=new Loginpage(driver);  // using set method
		
		
	
		lg.setUserName(username);
		logger.info("Entered username");
		lg.setPassword(password);
		logger.info("Entered Password");
		lg.clicksubmit();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		   //using assert to verify the element on the page or not

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			//using logger to check the test
			logger.info("Login Test Passed");
		}
		else {
			//calling the screenshot capture method from baseclass
			captureScreen(driver,"LoginTest");
			
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
