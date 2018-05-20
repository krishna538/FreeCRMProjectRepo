package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class LoginPageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() throws IOException {
		super();
		
	}

	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initilization();
		
		loginPage = new LoginPage();
	}
	
	// validating the login page title
	@Test(priority=1)
	public void verifyLoginPageTitleTest()
	{
		String actualTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(actualTitle, "Free CRM software in the cloud powers sales and customer service");
	}
	
	//validating the CRM logo
	@Test(priority=2)
	public void verifyCRMLogoTest()
	{
		Assert.assertTrue(loginPage.verifyCRMLogo());
	}
	
	
	//validating signup link
	@Test(priority=3)
	public void verifySignupLinkTest()
	{
		loginPage.verifySignUpLink();
	}
	
	//validating the login functionality
	@Test(priority=4)
	public void VerifyLoginFuctionalityTest() throws IOException
	{
		loginPage.verifyLoginFuction(properties.getProperty("userid"), properties.getProperty("password"));
	}
	

	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
}
