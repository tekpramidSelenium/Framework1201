package com.crm.leadsTest;
/**
 * test class for Leads module
 * @author Dilip
 */

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comCRM.business.ObjectRepository.CreateNewLeadsPage;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.LeadsInfopage;
import comCRM.business.ObjectRepository.Leadspage;
import comCRM.generic.baseUtility.BaseClass;
import comCRM.listenerUtility.ListImpclass;

//@Listeners(ListImpclass.class)
public class CreateLeadsTest extends BaseClass{
	
@Test(groups= {"smokeTest"},retryAnalyzer = comCRM.listenerUtility.RetryListImp.class)
public void createLeadsNameTest() throws Throwable
{
	String L_Name=eu.getDatafromExcelfile("Leads", 1, 2)+jlib.getRandomNumber(1000);
	String C_Name=eu.getDatafromExcelfile("Leads", 1, 3)+jlib.getRandomNumber(1000);

// navigate to Leads module
Homepage hp=new Homepage(driver);
hp.getLeadsLink().click();

// click on "create Leads" button
Leadspage lsp=new Leadspage(driver);
lsp.getNewLeadsBtn().click();

// enter all details & create new Leads 
CreateNewLeadsPage cnlp=new CreateNewLeadsPage(driver);
cnlp.createLeads(L_Name, C_Name);

// verify header msg Expected result
LeadsInfopage lfip=new LeadsInfopage(driver);
String headerinfo =lfip.getLeadsheaderMsg() .getText();	
boolean status=headerinfo.contains(L_Name);
Assert.assertEquals(status, true);
//jlib.verifyInfo(headerinfo,L_Name);

// verify  LastName info 
String act_L_Name = lfip.getLeadslastNameInfo().getText();
boolean status1=act_L_Name.trim().contains(L_Name);
soft.assertEquals(status1, true);
//jlib.verifyInfo(act_L_Name, L_Name);

// verify CompanyName info 
String act_C_Name = lfip.getCompanyInfo().getText();
boolean status2=act_C_Name.trim().contains(C_Name);
soft.assertEquals(status2, true);//soft.assertTrue(status2)
soft.assertAll();

//jlib.verifyInfo(act_C_Name, C_Name);

}

@Test (groups= {"regressionTest"})
public void createLeadWithIndustryTest() throws Throwable
{
	// read test script data from Excel file
	String L_Name=eu.getDatafromExcelfile("Leads", 4, 2)+jlib.getRandomNumber(1000);
	String C_Name=eu.getDatafromExcelfile("Leads", 4, 3)+jlib.getRandomNumber(1000);
	String L_Source=eu.getDatafromExcelfile("Leads", 4, 4);
	String industry=eu.getDatafromExcelfile("Leads", 4, 5);
				
   // navigate to Leads module
	Homepage hp=new Homepage(driver);
	hp.getLeadsLink().click();

   // step 3: click on "create Leads" button
	Leadspage lsp=new Leadspage(driver);
	lsp.getNewLeadsBtn().click();
		
   // enter all details & create new Leads 
	CreateNewLeadsPage cnlp=new CreateNewLeadsPage(driver);
	cnlp.createLeadsWithLeadSource(L_Name, C_Name, L_Source, industry);
		
   // verify the industries and Lead source info
    LeadsInfopage lfip=new LeadsInfopage(driver);
	String act_industries = lfip.getIndustryInfo().getText();
	boolean status=act_industries.trim().contains(industry);
	soft.assertEquals(status, true);
	//jlib.verifyInfo( act_industries,industry);
			
	String act_L_Source = lfip.getLeadSourceInfo().getText();
	boolean status1=act_L_Source.trim().contains(L_Source);
	soft.assertEquals(status1, true);
	soft.assertAll();
	//jlib.verifyInfo( act_L_Source,L_Source);
}

@Test (groups= {"regressionTest"})
public void createLeadsWithPhoneNoTest() throws Throwable 
{
// read test script data from Excel file
	String L_Name=eu.getDatafromExcelfile("Leads", 7, 2)+jlib.getRandomNumber(1000);
	String C_Name=eu.getDatafromExcelfile("Leads", 7, 3)+jlib.getRandomNumber(1000);
	String PhNo=eu.getDatafromExcelfile("Leads", 7, 4);

// navigate to Leads module
Homepage hp=new Homepage(driver);
hp.getLeadsLink().click();

// step 3: click on "create Leads" button
Leadspage lsp=new Leadspage(driver);
lsp.getNewLeadsBtn().click();

// enter all details & create new Leads 
CreateNewLeadsPage cnlp=new CreateNewLeadsPage(driver);
cnlp.createLeadWithPhoneNo(L_Name, C_Name, PhNo);

// verify phone number info
LeadsInfopage lfip=new LeadsInfopage(driver);
String act_PhNo = lfip.getPhoneNoInfo().getText();
boolean status1=act_PhNo.trim().contains(PhNo);
soft.assertEquals(status1, true);
soft.assertAll();
//jlib.verifyInfo( act_PhNo,PhNo);
	
}

}





