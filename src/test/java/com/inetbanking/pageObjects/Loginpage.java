package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;    
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

    
    
   /*	Loginpage(WebDriver d){
		//this.driver=driver;
		driver=d;
		PageFactory.initElements(d,this);//additional method
	}
	*/
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText = "Log out")
	@CacheLookup
	WebElement InkLogout;
	
	
	// is called action method 
	public void setUserName(String name)
	{
		txtUserName.sendKeys(name);
	}
	
	
	public void setPassword(String Password) {
		txtPassword.sendKeys(Password);
	}
	
	public void clicksubmit() {
		btnLogin.click();
	}
	public void ClickLogout()
	{
		InkLogout.click();
	}
}

