package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class HomePage extends TestBase{

	
	
	@FindBy(xpath= "//a[text() = 'Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath= "//a[text() = 'Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath= "//a[text() = 'Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath= "//a[text() = 'New Contact']")
	WebElement newContactLink;
	
	@FindBy(xpath= "//font[contains(text(),'User: Naveen K')]")
	WebElement userLabel;	
	
	public HomePage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}

	//Actions on Home Page
	
	//verify the Home Page Title
	public String VerifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	
	//Verify contacts link
	public void verifyContactsLink()
	{
		driver.switchTo().frame("mainpanel");
		contactsLink.click();
	}
	
	
	//Verify UserName Label
	public boolean verifyUserNameLabel()
	{
		return userLabel.isDisplayed();
	}
	
	//click on new contact under contacts link
	public void verifyNewContactLink()
	{	
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
}
