package com.crm.contactTest;
/**
 * test class for contact module
 * @author Dilip
 */

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comCRM.business.ObjectRepository.ContactInfopage;
import comCRM.business.ObjectRepository.ContactPage;
import comCRM.business.ObjectRepository.CreateNewContactPage;
import comCRM.business.ObjectRepository.CreateNewOrganizationPage;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.OrganizationInfopage;
import comCRM.business.ObjectRepository.Organizationpage;
import comCRM.business.ObjectRepository.SearchOrgWindow;
import comCRM.generic.WebdriverUtility.UtilityClassObject;
import comCRM.generic.baseUtility.BaseClass;
import comCRM.listenerUtility.ListImpclass;
@Listeners(ListImpclass.class)

public class CreateContactTest extends BaseClass
{

	@Test(groups= {"smokeTest"})
	public void createContactTest() throws Throwable
	{
	
	/* read test script data from Excel file */
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
	String ContactName=eu.getDatafromExcelfile("Contact", 1, 3)+jlib.getRandomNumber(1000);
	Homepage hp=new Homepage(driver);
	hp.getContactLink().click();
	
	/*  click on "create Contact" button */
	UtilityClassObject.getTest().log(Status.INFO, "navigate to contact");
	ContactPage cco=new ContactPage(driver);
	cco.getNewContcactBtn().click();	
	
	/* enter all details and click to  save */
	UtilityClassObject.getTest().log(Status.INFO, "Navigate to Create contact page");
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	cncp.createContact(ContactName);
	UtilityClassObject.getTest().log(Status.INFO, ContactName+"create contact");
	
	/* verify the contactName and  Header msg info */
	ContactInfopage cip=new ContactInfopage(driver);
	String headerInfo=cip.getContactHeaderMsg().getText();
	boolean status=headerInfo.contains(ContactName);
	Assert.assertEquals(status, true);
	/*jlib.verifyInfo( headerInfo,ContactName);*/
	
    String act_ContactName=cip.getContactNameInfo().getText();
    boolean status1=act_ContactName.trim().contains(ContactName);
    soft.assertEquals(status1, true);
    soft.assertAll();
    /*lib.verifyInfo( act_ContactName,ContactName); */
	
	}
	
	@Test(groups= {"regressionTest"})
	public void createContactWithSupportDateTest() throws Throwable
	{
		 /* read testscript data from Excel file */
		String ContactName=eu.getDatafromExcelfile("Contact", 1, 2)+jlib.getRandomNumber(1000);
				
		
		 /* navigate to Contact module  */
		Homepage hp=new Homepage(driver);
		hp.getContactLink().click();
		
		 /* click on "create Contact" button */
		ContactPage cco=new ContactPage(driver);
		cco.getNewContcactBtn().click();	
		
		 /* enter all details and click to  save */
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		String startDate=jlib.getSystemDateYYYYMMDD();
		String endDate=jlib.getRequiredDateYYYYDDMM(30);
		cncp.createContactWithSupportDate(ContactName, startDate, endDate);
		
		 /* verify the StartDate & EndDate info */
		ContactInfopage cip=new ContactInfopage(driver);
		String act_StartDate=cip.getStartDateInfo().getText();
		soft.assertEquals(act_StartDate, startDate);
		 /*jlib.verifyInfo( act_StartDate,startDate); */
		
		String act_EndDate=cip.getEndDateInfo().getText();
		soft.assertEquals(act_EndDate, endDate);
		soft.assertAll();
		 /*jlib.verifyInfo( act_EndDate,endDate); */
		
	}
	@Test (groups= {"regressionTest"})
	public void createContactWithOrgTest() throws Throwable
	{
		String OrgName=eu.getDatafromExcelfile("Contact", 7, 2)+jlib.getRandomNumber(1000);
		String ContactName=eu.getDatafromExcelfile("Contact", 7, 3);
		
		 /* navigate to organization module */
		Homepage hp=new Homepage(driver);
		hp.getOrgLink().click();

		 /* click on "create Organization" button */
		Organizationpage op=new Organizationpage(driver);
		op.getNewOrgIcon().click();

		 /* enter all details & create new organization  */
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrg(OrgName);

		 /* verify header msg Expected result */
				OrganizationInfopage oip=new OrganizationInfopage(driver);
				String actOrgName=oip.getOrgNameInfo().getText();
				boolean status=actOrgName.contains(OrgName);
				Assert.assertEquals(status, true);
				 /*jlib.verifyInfo( actOrgName,OrgName); */
				 /* navigate to contact module */
				hp.getContactLink().click();

	     /* click on "create Contact" button */
				ContactPage cco=new ContactPage(driver);
				cco.getNewContcactBtn().click();	

	     /* enter all details and click to  save */
				CreateNewContactPage cncp=new CreateNewContactPage(driver);
				cncp.createContactWithOrg(ContactName);
		 
				 /*  navigate to child browser */
		wlib.switchtoNewBrowserTab(driver, "module=Accounts");

		SearchOrgWindow sow=new SearchOrgWindow(driver);
		sow.searchOrg(OrgName);
		driver.findElement(By.xpath("//a[contains(.,'"+OrgName+"')]")).click();

		 /* navigate to Parent browser */
		wlib.switchtoNewBrowserTab(driver, "module=Contacts");

		cncp.getSaveBtn().click();

		 /* verify header msg info */
		ContactInfopage cip=new ContactInfopage(driver);
		 String header = cip.getContactNameInfo().getText();
		 boolean status1=header.contains(ContactName);
			Assert.assertEquals(status1, true);
			 /*jlib.verifyInfo( header,ContactName); */
		 
			 /* verify ContactOrgName info */
		 String ac_OrgName=cip.getOrgNameInfo().getText();
		 boolean status2=ac_OrgName.trim().contains(OrgName);
			soft.assertEquals(status2, true);
			soft.assertAll();
			 /* jlib.verifyInfo( ac_OrgName,OrgName); */
	}
}
