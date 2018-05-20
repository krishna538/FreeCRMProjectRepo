package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class LoginPage extends TestBase{ 
	
	
//Object repository

	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passWord;	
	
	@FindBy(xpath="//input[@type='submit'][@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[@class='btn'][contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[@class='img-responsive'][@alt='free crm logo']")
	WebElement crmLogo;
	
	
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions on login page
	
	
	
	//verifying the page title
	public String verifyLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	//verifying the CRM logo
	public boolean verifyCRMLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	//Verifying the signup link
	public void verifySignUpLink()
	{
		System.out.println(signUpBtn.getText());
		signUpBtn.click();
	}
	
	//verifying the login functionality
	
	public HomePage verifyLoginFuction(String uname, String pass) throws IOException
	{
			userName.sendKeys(uname);
			passWord.sendKeys(pass);
			loginBtn.click();
			
			return new HomePage();
	}
	
	
}
