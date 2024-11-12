package TestNGPgm;

import org.testng.Assert;
import org.testng.annotations.Test;

import comCRM.business.ObjectRepository.ContactInfopage;
import comCRM.business.ObjectRepository.ContactPage;
import comCRM.business.ObjectRepository.CreateNewContactPage;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.generic.baseUtility.BaseClass2;

public class RetryAnalyzerPgm extends BaseClass2 {



	@Test(groups= {"smokeTest"}, retryAnalyzer = comCRM.listenerUtility.RetryListImp.class)
	public void createContactTest() throws Throwable
	{
	
	// read test script data from Excel file
	String ContactName=eu.getDatafromExcelfile("Contact", 1, 2)+jlib.getRandomNumber(1000);
	Homepage hp=new Homepage(driver);
	hp.getContactLink().click();
	
	//  click on "create Contact" button
	ContactPage cco=new ContactPage(driver);
	cco.getNewContcactBtn().click();	
	
	// enter all details and click to  save
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	cncp.createContact(ContactName);
	
	// verify the contactName and  Header msg info
	ContactInfopage cip=new ContactInfopage(driver);
	String headerInfo=cip.getContactHeaderMsg().getText();
	boolean status=headerInfo.contains(ContactName);
	Assert.assertEquals(status, false);
	//jlib.verifyInfo( headerInfo,ContactName);
	
    String act_ContactName=cip.getContactNameInfo().getText();
    boolean status1=act_ContactName.trim().contains(ContactName);
    soft.assertEquals(status1, true);
   //jlib.verifyInfo( act_ContactName,ContactName);
	
	}
}

