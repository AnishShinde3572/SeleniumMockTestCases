package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutRepo {

	public LogoutRepo(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "html/body/table/tbody/tr/td[3]/table/tbody/tr/td[2]")
	private WebElement logout_icon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement logout;
	

	
	public void logout()
	{
		logout_icon.click();
		logout.click();
	}
	
}
