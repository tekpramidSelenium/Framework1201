package testCaseExecutionFolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import comCRM.business.ObjectRepository.CreateNewVendorName;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.Loginpage;
import comCRM.business.ObjectRepository.VendorInfopage;
import comCRM.business.ObjectRepository.VendorpageTest;
import comCRM.generic.FileUtility.ExcelUtility;
import comCRM.generic.FileUtility.FileUtility;
import comCRM.generic.WebdriverUtility.JavaUtility;
import comCRM.generic.WebdriverUtility.WebdriverUtility;

public class TestTC_07 {

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
				
				String V_Name=eu.getDatafromExcelfile("Vendor", 1, 2);
				String E_mail=eu.getDatafromExcelfile("Vendor", 1, 3);
				String PhoneNo=eu.getDatafromExcelfile("Vendor", 1, 4);
				
				WebDriver driver=wlib.launchingBrowser( browser);	
				
		//step 1: login to app
		Loginpage lp=new Loginpage(driver);
		lp.loginToapp(url,un,pwd);
		
		// navigate to more and select vendor link
		Homepage hp=new Homepage(driver);
		WebElement more=hp.getMoreLink();
		wlib.mousemoveOnElement(driver, more);
		hp.getVendorLink().click();
		
		//Click on create vendor button
		VendorpageTest vpt=new VendorpageTest(driver);
		vpt.getCreateVendorBtn().click();
		
		// Enter all details in vendor page
		CreateNewVendorName cnvn=new CreateNewVendorName(driver);
		cnvn.createVendor(V_Name, E_mail, PhoneNo);
		
		//verify header message, vendorName,Email,PhoneNo
		VendorInfopage vip=new VendorInfopage(driver);
		String headermsg=vip.getVendorHeaderMsg().getText();
		jlib.verifyInfo( headermsg,V_Name);
		
		String act_v_Name=vip.getVendorNameInfo().getText();
		jlib.verifyInfo( act_v_Name,V_Name);
		
	    String act_Email=vip.getVendorEmailInfo().getText();
	    jlib.verifyInfo( act_Email,E_mail);
	
	    String act_PhoneNo=vip.getVendorPhoneInfo().getText();
	    jlib.verifyInfo( act_PhoneNo,PhoneNo);
	
	    //Logout
	    hp.logOut();
	    driver.quit();
	}
	
}
