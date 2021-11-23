package com.inetBankingV1.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV1.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig rc = new ReadConfig();	
	String BaseUrl = rc.getBaseUrl();
	String Username = rc.getUsername();
	String Password = rc.getPasword();
	String ChromePath = rc.getChromePath();
	String FirefoxPath = rc.getFirefoxPath();
	String IEPath = rc.getIEPath();
	WebDriver driver;
	Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void SetUp(String br)
	{
		  logger=Logger.getLogger("Archive.org");
		  PropertyConfigurator.configure("log4j.properties");
		  
		  if(br.equals("chrome"))
		  {
			  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ChromePath);
			  driver = new ChromeDriver();	
		  }
		  if(br.equals("firefox"))
		  {
			  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+FirefoxPath);
			  driver = new FirefoxDriver();	
		  }
		  if(br.equals("ie"))
		  {
			  System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+IEPath);
			  driver = new InternetExplorerDriver();	
		  }
		  
		  logger.info(br+" driver is intialised successfully...");
		  driver.get(BaseUrl);
		  logger.info("Url is opened successfully...");		  
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
		logger.info("Browser closed successfully...");
	}
}
