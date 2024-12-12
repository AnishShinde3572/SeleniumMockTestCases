package com.crm.JavaUtility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.crm.BaseClass.MockBaseClass;

public class endDate extends MockBaseClass{

	
	public void endDate10(WebElement endDateIcon, WebElement date10) throws InterruptedException
	{
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.PAGE_DOWN).keyDown(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		endDateIcon.click();
		date10.click();
	}
	
}
