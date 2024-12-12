package com.crm.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsRepo {

public ContactsRepo(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsTab;
	public WebElement contactsTab()
	{
		return contactsTab;
	}

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement create_contact_icon;
	public WebElement createContact()
	{
		return create_contact_icon;
	}
	
	@FindBy(css = "input[name=\'lastname\']")
	private WebElement lastNameField;
	public WebElement lastNameField()
	{
		return lastNameField;
	}
	
	@FindBy(css = "input[value='T']")
	private WebElement assignedToRadioBtn;
	public WebElement assignedToRadioBtn()
	{
		return assignedToRadioBtn;
	}
	
	@FindBy(css = "img[id='jscal_trigger_support_start_date']")
	private WebElement startDate;
	public WebElement startDate()
	{
		return startDate;
	}
	
	@FindBy(xpath = "//tr[@class='daysrow']/td[text()='10']")
	private WebElement startdate10;
	public WebElement startdate10()
	{
		return startdate10;
	}
	
	@FindBy(css = "img[id='jscal_trigger_support_end_date']")
	private WebElement endDate;
	public WebElement endDate()
	{
		return endDate;
	}
	
	@FindBy(xpath = "//tr[@class='daysrow']/td[text()='10']")
	private WebElement enddate10;
	public WebElement enddate10()
	{
		return enddate10;
	}
	
	@FindBy(css = "input[title='Save [Alt+S]'")
	private WebElement saveButton;
	public WebElement saveButton()
	{
		return saveButton;
	}
	
	@FindBy(xpath = "//div[@class='small']/table/tbody/tr/td/span")
	private WebElement contact_header;
	public WebElement contactHeader()
	{
		return contact_header;
	}
	
//	@FindBy(id = "[id='dtlview_Support End Date']")
//	private WebElement endDateField;
//	public WebElement endDtaeField()
//	{
//		return endDateField;
//	}
}
