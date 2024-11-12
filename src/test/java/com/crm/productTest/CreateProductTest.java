package com.crm.productTest;
/**
 * test class for Product module
 * @author Dilip
 */

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import comCRM.business.ObjectRepository.CreateNewProductsPage;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.ProductsInfopage;
import comCRM.business.ObjectRepository.Productspage;
import comCRM.business.ObjectRepository.SearchVendorNameWindow;
import comCRM.generic.baseUtility.BaseClass;

public class CreateProductTest extends BaseClass {
@Test (groups= {"smokeTest"})
public void createProductTest() throws Throwable
{
	String P_Name=eu.getDatafromExcelfile("Product", 1, 2)+jlib.getRandomNumber(1000);
	
	// navigate to Product module
	Homepage hp=new Homepage(driver);
	hp.getProductLink().click();
	
	// click on "create Products" button
	Productspage pp=new Productspage(driver);
	pp.getNewProductsBtn().click();
	
   // enter all details & create new Products 
	CreateNewProductsPage cnpp=new CreateNewProductsPage(driver);
	cnpp.createProduct(P_Name);
	
   // verify header msg Expected result
	ProductsInfopage pip=new ProductsInfopage(driver);
	String headerinfo =pip.getProductsheaderMsg() .getText();
	boolean status=headerinfo.contains(P_Name);
	Assert.assertEquals(status, true);
	//jlib.verifyInfo( headerinfo,P_Name);
	
   // verify  ProductName info Expected result
	String act_P_Name = pip.getProductNameInfo().getText();
	boolean status1=act_P_Name.trim().contains(P_Name);
    soft.assertEquals(status1, true);
    soft.assertAll();
	//jlib.verifyInfo( act_P_Name,P_Name);
}
@Test (groups= {"regressionTest"})
public void createProductWithCategoryTest() throws Throwable {
	String P_Name=eu.getDatafromExcelfile("Product", 4, 2)+jlib.getRandomNumber(1000);
	String P_Category=eu.getDatafromExcelfile("Product", 4, 3);

	// navigate to Product module
	Homepage hp=new Homepage(driver);
	hp.getProductLink().click();

	// click on "create Products" button
	Productspage pp=new Productspage(driver);
	pp.getNewProductsBtn().click();

	// enter all details & create new Products 
	CreateNewProductsPage cnpp=new CreateNewProductsPage(driver);
	cnpp.createProductCategory(P_Name, P_Category);

	// verify header msg Expected result
	ProductsInfopage pip=new ProductsInfopage(driver);
	String headerinfo =pip.getProductsheaderMsg() .getText();
	boolean status=headerinfo.contains(P_Name);
	Assert.assertEquals(status, true);
	//jlib.verifyInfo( headerinfo,P_Category);

	// verify  ProductName info Expected result
	String act_P_Category = pip.getProductCategoryInfo().getText();
	boolean status1=act_P_Category.trim().contains(P_Category);
    soft.assertEquals(status1, true);
    soft.assertAll();
	//jlib.verifyInfo( act_P_Category,P_Category);

}

	
@Test (groups= {"regressionTest"})
public void ceateProductWithVendorNametest() throws Throwable
{
	String P_Name=eu.getDatafromExcelfile("Product", 7, 2)+jlib.getRandomNumber(1000);
	String P_Category=eu.getDatafromExcelfile("Product", 7, 3);
	String V_Name=eu.getDatafromExcelfile("Product", 7, 4);
	
	// navigate to Product module
	Homepage hp=new Homepage(driver);
	hp.getProductLink().click();

	// click on "create Products" button
	Productspage pp=new Productspage(driver);
	pp.getNewProductsBtn().click();

	// enter all details & create new Products 
	CreateNewProductsPage cnpp=new CreateNewProductsPage(driver);
	cnpp.createProductCategory(P_Name, P_Category);

	// Click on edit and enter vendor name and save
	cnpp.editVendorName();

	// navigate to child browser
	wlib.switchtoNewBrowserTab(driver, "module=Vendors");

	SearchVendorNameWindow svnw=new SearchVendorNameWindow(driver);
	svnw.searchVendor(V_Name);
	driver.findElement(By.xpath("//a[contains(.,'"+V_Name+"')]")).click();

	// navigate to Parent browser
	wlib.switchtoNewBrowserTab(driver, "index.php");
	cnpp.getSaveBtn().click();

	// verify header msg Expected result
	ProductsInfopage pip=new ProductsInfopage(driver);
	String headerinfo =pip.getProductsheaderMsg() .getText();
	boolean status=headerinfo.contains(P_Name);
	Assert.assertEquals(status, true);
	//jlib.verifyInfo( headerinfo,P_Name);

	// verify  ProductName info Expected result
	String act_P_Category = pip.getProductCategoryInfo().getText();
	boolean status1=act_P_Category.trim().contains(P_Category);
    soft.assertEquals(status1, true);
	//jlib.verifyInfo( act_P_Category,P_Category);


	// verify  ProductName info Expected result
	String act_V_Name = pip.getVendorNameInfo().getText();
	boolean status2=act_V_Name.trim().contains(V_Name);
    soft.assertEquals(status2, true);
    soft.assertAll();
	//jlib.verifyInfo( act_V_Name,V_Name);
	
 
}
}
