package testCaseExecutionFolder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import comCRM.business.ObjectRepository.ContactInfopage;
import comCRM.business.ObjectRepository.ContactPage;
import comCRM.business.ObjectRepository.CreateNewContactPage;
import comCRM.business.ObjectRepository.CreateNewOrganizationPage;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.Loginpage;
import comCRM.business.ObjectRepository.OrganizationInfopage;
import comCRM.business.ObjectRepository.Organizationpage;
import comCRM.business.ObjectRepository.SearchOrgWindow;
import comCRM.generic.FileUtility.ExcelUtility;
import comCRM.generic.FileUtility.FileUtility;
import comCRM.generic.WebdriverUtility.JavaUtility;
import comCRM.generic.WebdriverUtility.WebdriverUtility;

public class PracticeTC_06ContactwithOrg {

	public static void main(String[] args) throws Throwable {
		// Create  Object
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebdriverUtility wlib=new WebdriverUtility();
		 //  read common Data from Properties File
	    
			String browser=fu.getDatafromPropertyfile("Browser");
			String url=fu.getDatafromPropertyfile("URl");
			String un=fu.getDatafromPropertyfile("Username");
			String pwd=fu.getDatafromPropertyfile("Password");
	
		
		//read testscript data from Excel file
		
		String OrgName=eu.getDatafromExcelfile("Contact", 7, 2)+jlib.getRandomNumber(1000);
		String ContactName=eu.getDatafromExcelfile("Contact", 7, 3);
		
		WebDriver driver=wlib.launchingBrowser( browser);	
		
//step 1: login to app
Loginpage lp=new Loginpage(driver);
lp.loginToapp(url,un,pwd);

//step 2: navigate to organization module
Homepage hp=new Homepage(driver);
hp.getOrgLink().click();

// step 3: click on "create Organization" button
Organizationpage op=new Organizationpage(driver);
op.getNewOrgIcon().click();

// step 4: enter all details & create new organization 
CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
cnop.createOrg(OrgName);

//step 5:verify header msg Expected result
		OrganizationInfopage oip=new OrganizationInfopage(driver);
		String actOrgName=oip.getOrgNameInfo().getText();
		jlib.verifyInfo( actOrgName,OrgName);
//step 6:navigate to contact module
		hp.getContactLink().click();

// step 7: click on "create Contact" button
		ContactPage cco=new ContactPage(driver);
		cco.getNewContcactBtn().click();	

// step 8:enter all details and click to  save
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createContactWithOrg(ContactName);
 
//  navigate to child browser
wlib.switchtoNewBrowserTab(driver, "module=Accounts");

SearchOrgWindow sow=new SearchOrgWindow(driver);
sow.searchOrg(OrgName);
driver.findElement(By.xpath("//a[contains(.,'"+OrgName+"')]")).click();

// navigate to Parent browser
wlib.switchtoNewBrowserTab(driver, "module=Contacts");

cncp.getSaveBtn().click();

// verify header msg info
ContactInfopage cip=new ContactInfopage(driver);
 String header = cip.getContactNameInfo().getText();
 jlib.verifyInfo( header,ContactName);
 
// verify ContactOrgName info
 String ac_OrgName=cip.getOrgNameInfo().getText();
 jlib.verifyInfo( ac_OrgName,OrgName);
 
 //step 9:Logout
    hp.logOut();
	driver.quit();
 
	}
	
}
