package com.inetbanking.testCases;

import java.io.IOException; 

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.Loginpage;
import com.inetbanking.utilities.XLUtils;


public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		Loginpage lg=new Loginpage(driver);
		lg.setUserName(user);
		logger.info("user name provided");
		lg.setPassword(pwd);
		logger.info("password provided");
		lg.clicksubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Loging failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.warn("Login passed");
			lg.ClickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
	}

public boolean isAlertPresent()// user defind method created to check alert is present or not
{
	try {
		driver.switchTo().alert();
		return true;
	}
	catch(NoAlertPresentException e)
	{
		return false;
		
	}
}

   @DataProvider(name="LoginData")
   String [][]getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int noofrows=XLUtils.getRowCount(path, "Sheet1");
		int columscount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String [noofrows][columscount];
		   
		   for(int i=1;i<=noofrows;i++)
		   {
			   for(int j=0;j<columscount;j++)
			   {
				   logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//1 0
			   }
		   }
			return logindata;	 //return type 
		}

}
