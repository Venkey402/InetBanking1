package com.inetBankingV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;

	public ReadConfig()
	{
		File src = new File(System.getProperty("user.dir")+"\\Configuration\\config.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			pro = new Properties();
			pro.load(fis);
		} catch (IOException e) 
		{			
			e.printStackTrace();
		}		
	}
	
	public String getChromePath()
	{
		return pro.getProperty("chromePath");
	}
	public String getFirefoxPath()
	{
		return pro.getProperty("firefoxPath");
	}
	public String getIEPath()
	{
		return pro.getProperty("iePath");
	}
	public String getBaseUrl()
	{
		return pro.getProperty("baseUrl");
	}
	public String getUsername()
	{
		return pro.getProperty("username");
	}
	public String getPasword()
	{
		return pro.getProperty("password");
	}
	
	
}
