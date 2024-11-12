package testCaseExecutionFolder;

import java.util.Random;

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

public class PracticeTC_04CreateContact {

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
			
			//use random class
			Random r1=new Random();
			int rcount=r1.nextInt(1000);
			
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
	cncp.createContact(ContactName);
	
	//step 5: verify the contactName and  Header msg info
	ContactInfopage cip=new ContactInfopage(driver);
	String headerInfo=cip.getContactHeaderMsg().getText();
	jlib.verifyInfo( headerInfo,ContactName);
	
    String act_ContactName=cip.getContactNameInfo().getText();
    jlib.verifyInfo( act_ContactName,ContactName);
	
	// step 6:logout
		hp.logOut();
		 driver.quit();
	
	}

}
