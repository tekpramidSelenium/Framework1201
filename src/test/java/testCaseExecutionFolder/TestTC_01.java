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

public class TestTC_01 {

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
			
		
			String L_Name=eu.getDatafromExcelfile("Leads", 1, 2)+jlib.getRandomNumber(1000);
			String C_Name=eu.getDatafromExcelfile("Leads", 1, 3)+jlib.getRandomNumber(1000);
			
			
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
	cnlp.createLeads(L_Name, C_Name);
	
	// step 5:verify header msg Expected result
	LeadsInfopage lfip=new LeadsInfopage(driver);
	String headerinfo =lfip.getLeadsheaderMsg() .getText();		
	jlib.verifyInfo(headerinfo,L_Name);
	
	//step 6:verify  LastName info 
	String act_L_Name = lfip.getLeadslastNameInfo().getText();
	jlib.verifyInfo(act_L_Name, L_Name);
	
	//step 7:verify CompanyName info 
		String act_C_Name = lfip.getCompanyInfo().getText();
		jlib.verifyInfo(act_C_Name, C_Name);
	
	//step 8: Logout
		hp.logOut();
	 driver.quit();

	}

}
