package com.crm.qa.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	public HomePageTest() throws IOException {
		super();
		
		
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initilization();
		loginPage = new LoginPage();
		homePage = 	loginPage.verifyLoginFuction(properties.getProperty("userid"), properties.getProperty("password"));
		
	}
	
	//validating the home page title
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homeActualTitle = homePage.VerifyHomePageTitle();
		
		Assert.assertEquals(homeActualTitle,"CRMPRO");
		
	}
	
	//Validating the user label value
	@Test(priority=2)
	public void verifyUserLabelTest()
	{	
		driver.switchTo().frame("mainpanel");
		Assert.assertTrue(homePage.verifyUserNameLabel());
	}
	
	@Test(priority=3)
	public void verifyContactLinkTest()
	{
		homePage.verifyContactsLink();
	}
	

	
	//validating new contacts link under contacts
	@Test(priority=4)
	public void verifyNewContactLinkTest()
	{	
		homePage.verifyNewContactLink();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	

}
