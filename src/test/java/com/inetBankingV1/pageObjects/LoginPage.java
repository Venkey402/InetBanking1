package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	  @FindBy(how=How.XPATH,using="//input[@name='username']")
	  WebElement txtUsername; 

	  @FindBy(how=How.XPATH,using="//input[@name='password']")
	  WebElement txtPassword;	  

	  @FindBy(how=How.XPATH,using="//input[@name='submit-to-login']")
	  WebElement btnLogin;
	  
	  public void setUsername(String username)
	  {
		  txtUsername.sendKeys(username);
	  }
	  
	  public void setPassword(String password)
	  {
		  txtPassword.sendKeys(password);
	  }
	  
	  public void clickLogin()
	  {
		  btnLogin.click();
	  }


}
