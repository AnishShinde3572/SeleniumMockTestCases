package com.crm.BaseClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtility.AccessURLAndBrowser;
import com.crm.POM.LoginRepo;
import com.crm.POM.LogoutRepo;

public class MockBaseClass {

	
	public static WebDriver driver = null;
	public static String expected_url = "http://localhost:8888/index.php?module=Home&action=index&parenttab=My%20Home%20Page"; 
	public static String expected_title = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
	
	@BeforeClass
	public static void preCondition() throws IOException
	{

		AccessURLAndBrowser browser = new AccessURLAndBrowser();
		String br = browser.accessData("browser");
		
		if(br.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(br.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(browser.accessData("url"));
		
	}
	
	@BeforeMethod
	public static void login() throws IOException
	{
		
		String actual_url = driver.getCurrentUrl();
		assertEquals(expected_url, actual_url);
		LoginRepo lr = new LoginRepo(driver);
		lr.login();
	}
	
	@AfterMethod
	public static void logout()
	{
		LogoutRepo lr = new LogoutRepo(driver);
		lr.logout();
	}
	
	@AfterClass
	public static void postCondition()
	{
		driver.close();
	}
	
	
}
