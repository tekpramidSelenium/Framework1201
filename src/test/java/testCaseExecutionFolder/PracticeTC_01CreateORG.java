package testCaseExecutionFolder;

import org.openqa.selenium.WebDriver;

import comCRM.business.ObjectRepository.CreateNewOrganizationPage;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.Loginpage;
import comCRM.business.ObjectRepository.OrganizationInfopage;
import comCRM.business.ObjectRepository.Organizationpage;
import comCRM.generic.FileUtility.ExcelUtility;
import comCRM.generic.FileUtility.FileUtility;
import comCRM.generic.WebdriverUtility.JavaUtility;
import comCRM.generic.WebdriverUtility.WebdriverUtility;

public class PracticeTC_01CreateORG {

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
			
				String OrgName=eu.getDatafromExcelfile("Org", 1, 2)+jlib.getRandomNumber(1000);
				
				
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
		
		// step 5:verify header msg and OrgName
		OrganizationInfopage oip=new OrganizationInfopage(driver);
		String header=oip.getHeaderMsg().getText();
		jlib.verifyInfo( header,OrgName);
		String actOrgName=oip.getOrgNameInfo().getText();
		jlib.verifyInfo( actOrgName,OrgName);
		
		//step 7: Logout
		hp.logOut();
		 driver.quit();
	}

}
