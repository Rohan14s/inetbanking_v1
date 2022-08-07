package com.inetbanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.Loginpage;

public class TC_AddCustomerTest_003 extends BaseClass{
    @Test
	public void AddNewCustomer() throws InterruptedException, IOException
	{   
    	logger.info("URL is opened");
    	//creating driver object parameter as driver
		Loginpage lg=new Loginpage(driver);
		lg.setUserName(username);
		logger.info("User name is provided");
	    lg.setPassword(password);
	    logger.info("password is provided");
	    lg.clicksubmit();
	    
	    Thread.sleep(3000);
	    
	  //creating object for add customer page 
	    AddCustomerPage addcust=new AddCustomerPage(driver);
	    addcust.clickAddNewCustomer();
	
	    logger.info("providing customer details....");
	  //using implicit wait to handle the test failure 
	  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	
	  //objectname.pageobject.values
     	addcust.custName("rohan");
		addcust.custgender("male");
		addcust.custdob("14","07","1997");
		Thread.sleep(3000);
		addcust.custaddress("Amman street");
		addcust.custcity("Chennai");
		addcust.custstate("Tamilnadu");
		addcust.custpinno("624704");
		addcust.custtelephoneno("9876543211");
		//every time login required unique gmail id so method inside the baseclass for reuse
		//here we used random string generate method to generate the random gmail for multiple login
		String email=randomestring()+"@gmail.com";
		//objectname.pageobject(email as a parameter);
		addcust.custemailid(email);
		addcust.custpassword("rohan");
		addcust.custsubmit();
	
	    Thread.sleep(3000);
	    logger.info("validation started");
	  //after created the new customer we have to check the page heading 
	  		//so we used this boolean for verify res object
	
	    boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	    if(res==true)
	    {
	    	Assert.assertTrue(true);
	    	logger.info("Add customer test case passed....");
	    	
	    }else {
	    	logger.info("Add customer test case failed....");
	    	captureScreen(driver, "AddNewCustomer");
	    	Assert.assertTrue(false);
	    }
	    
	}

	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
		}
     public static String randomNum() {
    	 String generatedstring2=RandomStringUtils.randomNumeric(5);
		return generatedstring2;
    	 
     }
	
	
}
