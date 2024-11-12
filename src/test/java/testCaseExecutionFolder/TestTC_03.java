package testCaseExecutionFolder;

import org.openqa.selenium.WebDriver;

import comCRM.business.ObjectRepository.CreateNewLeadsPage;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.LeadsInfopage;
import comCRM.business.ObjectRepository.Leadspage;
import comCRM.business.ObjectRepository.Loginpage;
import comCRM.generic.FileUtility.ExcelUtility;
import comCRM.generic.FileUtility.FileUtility;
import comCRM.generic.WebdriverUtility.JavaUtility;
import comCRM.generic.WebdriverUtility.WebdriverUtility;

public class TestTC_03 {

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

			String L_Name=eu.getDatafromExcelfile("Leads", 7, 2)+jlib.getRandomNumber(1000);
			String C_Name=eu.getDatafromExcelfile("Leads", 7, 3)+jlib.getRandomNumber(1000);
			String PhNo=eu.getDatafromExcelfile("Leads", 7, 4);
			
			WebDriver driver=wlib.launchingBrowser( browser);	
			
	//step 1: login to app
	Loginpage lp=new Loginpage(driver);
	lp.loginToapp(url,un,pwd);
	
	//step 2: navigate to Leads module
	Homepage hp=new Homepage(driver);
	hp.getLeadsLink().click();

	// step 3: click on "create Leads" button
	Leadspage lsp=new Leadspage(driver);
	lsp.getNewLeadsBtn().click();
	
   // step 4: enter all details & create new Leads 
	CreateNewLeadsPage cnlp=new CreateNewLeadsPage(driver);
	cnlp.createLeadWithPhoneNo(L_Name, C_Name, PhNo);

	// step 5:verify phone number info
	LeadsInfopage lfip=new LeadsInfopage(driver);
		String act_PhNo = lfip.getPhoneNoInfo().getText();
		jlib.verifyInfo( act_PhNo,PhNo);
		
	//step 6: Logout
         hp.logOut();
		 driver.quit();
	}

}
