package TestNG1;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import comCRM.business.ObjectRepository.ContactInfopage;
import comCRM.business.ObjectRepository.ContactPage;
import comCRM.business.ObjectRepository.CreateNewContactPage;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.generic.baseUtility.BaseClass;

public class Batch3 extends BaseClass {
	@Test  (groups= {"smokeTest"})
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
	Assert.assertEquals(status, true);
	//jlib.verifyInfo( headerInfo,ContactName);
	
    String act_ContactName=cip.getContactNameInfo().getText();
    SoftAssert soft=new SoftAssert();
    soft.assertEquals(act_ContactName, ContactName);
    //jlib.verifyInfo( act_ContactName,ContactName);
	
	}
	
	@Test(groups= {"regressionTest"})
	public void createContactWithSupportDateTest() throws Throwable
	{
		// read testscript data from Excel file
		String ContactName=eu.getDatafromExcelfile("Contact", 1, 2)+jlib.getRandomNumber(1000);
				
		
		// navigate to Contact module
		Homepage hp=new Homepage(driver);
		hp.getContactLink().click();
		
		// click on "create Contact" button
		ContactPage cco=new ContactPage(driver);
		cco.getNewContcactBtn().click();	
		
		// enter all details and click to  save
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		String startDate=jlib.getSystemDateYYYYMMDD();
		String endDate=jlib.getRequiredDateYYYYDDMM(30);
		cncp.createContactWithSupportDate(ContactName, startDate, endDate);
		
		// verify the StartDate & EndDate info
		ContactInfopage cip=new ContactInfopage(driver);
		String act_StartDate=cip.getStartDateInfo().getText();
		jlib.verifyInfo( act_StartDate,startDate);
		
		String act_EndDate=cip.getEndDateInfo().getText();
		jlib.verifyInfo( act_EndDate,endDate);
		
	}

}
