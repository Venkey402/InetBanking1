package com.inetBankingV1.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import com.inetBankingV1.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass 
{	
  @Test
  public void Login() throws IOException 
  {  
	  LoginPage lp =  new LoginPage(driver);	  
	  lp.setUsername(Username);
	  logger.info("Username is provided successfully...");
	  lp.setPassword(Password);
	  logger.info("Password is provided successfully...");
	  lp.clickLogin();		
	  logger.info("Clicked on the login button successfully...");	
	  	  
	  if(driver.getTitle().equals("Log in to the Internet Archiveasdfsdfsdfa"))
	  {
		  Assert.assertTrue(true);
		  logger.info("Page title is correct...");		
	  }
	  else
	  {
		  Assert.assertTrue(false);
		  logger.info("Page title is not correct...");	
		  TakesScreenshot tss = ((TakesScreenshot)driver);		  
		  File src = tss.getScreenshotAs(OutputType.FILE);		  
		  File dest = new File("C:\\Users\\venkatm\\eclipse-workspace\\inetBankingV1\\Screenshots\\Fail.png");
		  FileUtils.copyFile(src, dest);
	  }
	  
  }
}
