package TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.MockBaseClass;
import com.crm.FileUtility.AccessOrganizationNameFromXLSX;
import com.crm.POM.OrganizationRepo;

@Listeners(com.crm.Listeners.screenShotListeners.class)
public class TestCase7 extends MockBaseClass{

	@Test
	public static void script7() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String actual_title = driver.getTitle();
		assertEquals(expected_title, actual_title);
	
		AccessOrganizationNameFromXLSX org_ref = new AccessOrganizationNameFromXLSX();
		String sheetData = org_ref.orgInfo("Sheet1", 1, 2);
		String orgName = sheetData + Math.random();
		
		OrganizationRepo or = new OrganizationRepo(driver);
		
		or.organizationsTab().click();
		Thread.sleep(1000);
		
		or.createOrganization().click();
		Thread.sleep(1000);
		
		or.organizationNameTextfield().sendKeys(orgName);
		Thread.sleep(1000);
		
		Select s = new Select(or.industryDropDown());
		String dropdownValue = org_ref.orgInfo("Sheet1", 1, 3);
		s.selectByValue(dropdownValue);
		Thread.sleep(1000);
		
		or.assignedToRadioBtn().click();
		Thread.sleep(1000);
		
		or.saveButton().click();
		Thread.sleep(1000);
		
		String name_header = or.organizationHeader().getText();
		assertTrue(name_header.contains(orgName));
		
		String industryValue = or.industryTextfieldValue().getText();
		
		assertTrue(industryValue.equals(dropdownValue));
		
		System.out.println("New Organization is created");

		
	}
	
}
