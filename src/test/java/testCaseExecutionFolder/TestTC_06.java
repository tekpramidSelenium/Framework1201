 package testCaseExecutionFolder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import comCRM.business.ObjectRepository.CreateNewProductsPage;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.Loginpage;
import comCRM.business.ObjectRepository.ProductsInfopage;
import comCRM.business.ObjectRepository.Productspage;
import comCRM.business.ObjectRepository.SearchVendorNameWindow;
import comCRM.generic.FileUtility.ExcelUtility;
import comCRM.generic.FileUtility.FileUtility;
import comCRM.generic.WebdriverUtility.JavaUtility;
import comCRM.generic.WebdriverUtility.WebdriverUtility;

public class TestTC_06 {

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
					
			
	 //read test script data from Excel file
			
			String P_Name=eu.getDatafromExcelfile("Product", 7, 2)+jlib.getRandomNumber(1000);
			String P_Category=eu.getDatafromExcelfile("Product", 7, 3);
			String V_Name=eu.getDatafromExcelfile("Product", 7, 4);
			
			WebDriver driver=wlib.launchingBrowser( browser);	
			
	//step 1: login to app
	Loginpage lp=new Loginpage(driver);
	lp.loginToapp(url,un,pwd);
	
	//step 2: navigate to Product module
	Homepage hp=new Homepage(driver);
	hp.getProductLink().click();
	
	// step 3: click on "create Products" button
	Productspage pp=new Productspage(driver);
	pp.getNewProductsBtn().click();
	
   // step 4: enter all details & create new Products 
	CreateNewProductsPage cnpp=new CreateNewProductsPage(driver);
	cnpp.createProductCategory(P_Name, P_Category);
	
	// step 5: Click on edit and enter vendorname and save
	cnpp.editVendorName();
	
   //  navigate to child browser
    wlib.switchtoNewBrowserTab(driver, "module=Vendors");
    
    SearchVendorNameWindow svnw=new SearchVendorNameWindow(driver);
    svnw.searchVendor(V_Name);
    driver.findElement(By.xpath("//a[contains(.,'"+V_Name+"')]")).click();

   //navigate to Parent browser
    wlib.switchtoNewBrowserTab(driver, "index.php");
    cnpp.getSaveBtn().click();
	
	// step 6:verify header msg Expected result
    ProductsInfopage pip=new ProductsInfopage(driver);
	String headerinfo =pip.getProductsheaderMsg() .getText();		
	jlib.verifyInfo( headerinfo,P_Name);
	
	//step 7:verify  ProductName info Expected result
	String act_P_Category = pip.getProductCategoryInfo().getText();
    jlib.verifyInfo( act_P_Category,P_Category);

	
	//step 7:verify  ProductName info Expected result
	String act_V_Name = pip.getVendorNameInfo().getText();
	jlib.verifyInfo( act_V_Name,V_Name); 
		
	//step 7: Logout
		hp.logOut();
	 driver.quit();

	}

}
