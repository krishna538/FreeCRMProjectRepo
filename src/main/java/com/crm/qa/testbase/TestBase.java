package com.crm.qa.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	FileInputStream f1;
	
	public TestBase() throws IOException
	{
		f1 = new FileInputStream ("C:\\Users\\krishna\\workspace\\FreeCRMAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		properties = new Properties();
		properties.load(f1);
	}
	
	
	public void initilization()
	{
		if (properties.getProperty("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\krishna\\workspace\\FreeCRMAutomation\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//navigate to free CRM application site.
			driver.get(properties.getProperty("url"));
		}
		
		else if(properties.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\krishna\\workspace\\FreeCRMAutomation\\Drivers\\chromedriver.exe");
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
			
			//navigate to free CRM application site.
			driver.get(properties.getProperty("url"));
		}
	}
	
	

}
