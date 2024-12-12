package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.MockBaseClass;
import com.crm.FileUtility.AccessContactData;
import com.crm.JavaUtility.endDate;
import com.crm.POM.ContactsRepo;

@Listeners(com.crm.Listeners.screenShotListeners.class)
public class TestCase8 extends MockBaseClass{

	@Test
	public void script8() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String actual_title = driver.getTitle();
		assertTrue(expected_title.equals(actual_title));
		
		AccessContactData ref = new AccessContactData();

		ContactsRepo cr = new ContactsRepo(driver);
		
		cr.contactsTab().click();
		Thread.sleep(1000);
		
		cr.createContact().click();
		Thread.sleep(1000);
		
		String data = ref.contactInfo("Sheet1", 1, 1);
		String lastName = data + Math.random();
		
		cr.lastNameField().sendKeys(lastName);
		Thread.sleep(1000);
		
		cr.assignedToRadioBtn().click();
		Thread.sleep(1000);
				
		endDate ed = new endDate();
		ed.endDate10(cr.endDate(), cr.enddate10());
		
		Thread.sleep(1000);
		cr.saveButton().click();
		
		String headerInfo = cr.contactHeader().getText();
		assertTrue(headerInfo.contains(lastName));
		
		System.out.println("New Contact is created");
		
	}
}
