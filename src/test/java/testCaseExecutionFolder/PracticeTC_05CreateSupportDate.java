package testCaseExecutionFolder;

import org.openqa.selenium.WebDriver;

import comCRM.business.ObjectRepository.ContactInfopage;
import comCRM.business.ObjectRepository.ContactPage;
import comCRM.business.ObjectRepository.CreateNewContactPage;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.Loginpage;
import comCRM.generic.FileUtility.ExcelUtility;
import comCRM.generic.FileUtility.FileUtility;
import comCRM.generic.WebdriverUtility.JavaUtility;
import comCRM.generic.WebdriverUtility.WebdriverUtility;

public class PracticeTC_05CreateSupportDate {

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
			String ContactName=eu.getDatafromExcelfile("Contact", 1, 2)+jlib.getRandomNumber(1000);
			
			WebDriver driver=wlib.launchingBrowser( browser);	
			
	//step 1: login to app
	Loginpage lp=new Loginpage(driver);
	lp.loginToapp(url,un,pwd);
	
	//step 2: navigate to Contact module
	Homepage hp=new Homepage(driver);
	hp.getContactLink().click();
	
	// step 3: click on "create Contact" button
	ContactPage cco=new ContactPage(driver);
	cco.getNewContcactBtn().click();	
	
	// step 4:enter all details and click to  save
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	String startDate=jlib.getSystemDateYYYYMMDD();
	String endDate=jlib.getRequiredDateYYYYDDMM(30);
	cncp.createContactWithSupportDate(ContactName, startDate, endDate);
	
	//step 5: verify the StartDate & EndDate info
	ContactInfopage cip=new ContactInfopage(driver);
	String act_StartDate=cip.getStartDateInfo().getText();
	jlib.verifyInfo( act_StartDate,startDate);
	
	String act_EndDate=cip.getEndDateInfo().getText();
	jlib.verifyInfo( act_EndDate,endDate);
	
	// logout
	hp.logOut();
    driver.quit();
	}

}
