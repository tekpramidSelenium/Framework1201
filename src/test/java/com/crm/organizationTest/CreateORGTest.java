package com.crm.organizationTest;
/**
 * test class for Organization module
 * @author Dilip
 */

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comCRM.business.ObjectRepository.CreateNewOrganizationPage;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.OrganizationInfopage;
import comCRM.business.ObjectRepository.Organizationpage;
import comCRM.generic.WebdriverUtility.UtilityClassObject;
import comCRM.generic.baseUtility.BaseClass;
import comCRM.listenerUtility.ListImpclass;

@Listeners(ListImpclass.class)
public class CreateORGTest extends BaseClass {

	@Test (groups= {"smokeTest"})
	public void createOrgTest() throws Throwable
	{
		// read test script data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");	
		String OrgName=eu.getDatafromExcelfile("Org", 1, 2)+jlib.getRandomNumber(2000);
		
		// navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization");
		Homepage hp=new Homepage(driver);
		hp.getOrgLink().click();
		
		// click on "create Organization" button
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Create organization page");
		Organizationpage op=new Organizationpage(driver);
		op.getNewOrgIcon().click();
		
        // enter all details & create new organization 
		UtilityClassObject.getTest().log(Status.INFO, OrgName+"create organization");
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrg(OrgName);
		
		// verify header msg and OrgName
		OrganizationInfopage oip=new OrganizationInfopage(driver);
		String header=oip.getHeaderMsg().getText();
		boolean status=header.trim().contains(OrgName);
		Assert.assertEquals(status, true);
		//jlib.verifyInfo( header,OrgName);
		String actOrgName=oip.getOrgNameInfo().getText();
		boolean status1=actOrgName.trim().contains(OrgName);
		soft.assertEquals(status1, true);
		soft.assertAll();
		//jlib.verifyInfo( actOrgName,OrgName);
	}
	@Test (groups= {"regressionTest"})
	public void createOrgWithIndstryTest() throws Throwable
	{	UtilityClassObject.getTest().log(Status.INFO, "read data from excel");	
		String OrgName=eu.getDatafromExcelfile("Org", 4, 2)+jlib.getRandomNumber(1000);
		String industry=eu.getDatafromExcelfile("Org", 4, 3);
		String Type=eu.getDatafromExcelfile("Org", 4, 4);
		
       // navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization");
		Homepage hp=new Homepage(driver);
		hp.getOrgLink().click();

	   //  click on "create Organization" button
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Create organization page");
		Organizationpage op=new Organizationpage(driver);
		op.getNewOrgIcon().click();
		
		//  enter all details & create new organization 
		UtilityClassObject.getTest().log(Status.INFO, "create organization");
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrgWithIndustry(OrgName, industry, Type);
		UtilityClassObject.getTest().log(Status.INFO, OrgName+industry+Type+"create organization");

		// verify the industries and type info
		OrganizationInfopage oip=new OrganizationInfopage(driver);
		String actIndustryInfo=oip.getIndustryInfo().getText();
		boolean status=actIndustryInfo.trim().contains(industry);
		soft.assertEquals(status, true);
		//jlib.verifyInfo( actIndustryInfo,industry);

		String actType=oip.getTypeInfo().getText();
		boolean status1=actType.trim().contains(Type);
		soft.assertEquals(status1, true);
		soft.assertAll();
		//jlib.verifyInfo( actType,Type);

	}
	
	@Test (groups= {"regressionTest"})
	public void createOrgWithPhoneNoTest() throws Throwable
	{
		String OrgName=eu.getDatafromExcelfile("Org", 7, 2)+jlib.getRandomNumber(1000);
		String PhNo=eu.getDatafromExcelfile("Org", 7, 3);

		// navigate to organization module
			Homepage hp=new Homepage(driver);
			hp.getOrgLink().click();
			
		// click on "create Organization" button
			Organizationpage op=new Organizationpage(driver);
			op.getNewOrgIcon().click();
			
		// enter all details & create new organization 
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.createOrgWithPhoneNo(OrgName,PhNo);

		// verify phone number info
		    OrganizationInfopage oip=new OrganizationInfopage(driver);
		    String actPhoneInfo=oip.getPhoneNoInfo().getText();
		    boolean status1=actPhoneInfo.trim().contains(PhNo);
		    soft.assertEquals(status1, true);
		    soft.assertAll();
		   // jlib.verifyInfo( actPhoneInfo,PhNo);
      

	}

}
