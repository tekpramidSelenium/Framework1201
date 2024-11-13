package com.crm.vendorTest;

/**
 * test class for Vendor module
 * @author Dilip
 */

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import comCRM.business.ObjectRepository.CreateNewVendorName;
import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.VendorInfopage;
import comCRM.business.ObjectRepository.VendorpageTest;
import comCRM.generic.baseUtility.BaseClass;

public class CreateVendorTest extends BaseClass {

	@Test(groups = { "smokeTest" })
	public void createVendorTest() throws Throwable {
		String V_Name = eu.getDatafromExcelfile("Vendor", 1, 2);
		String E_mail = eu.getDatafromExcelfile("Vendor", 1, 3);
		String PhoneNo = eu.getDatafromExcelfile("Vendor", 1, 4);

// navigate to more and select vendor link
		Homepage hp = new Homepage(driver);
		WebElement more = hp.getMoreLink();
		wlib.mousemoveOnElement(driver, more);
		hp.getVendorLink().click();

// Click on create vendor button
		VendorpageTest vpt = new VendorpageTest(driver);
		vpt.getCreateVendorBtn().click();

// Enter all details in vendor page
		CreateNewVendorName cnvn = new CreateNewVendorName(driver);
		cnvn.createVendor(V_Name, E_mail, PhoneNo);

// verify header message, vendorName,Email,PhoneNo
		VendorInfopage vip = new VendorInfopage(driver);
		String headermsg = vip.getVendorHeaderMsg().getText();
		boolean status = headermsg.contains(V_Name);
		Assert.assertEquals(status, true);
//jlib.verifyInfo( headermsg,V_Name);

		String act_v_Name = vip.getVendorNameInfo().getText();
		boolean status1 = act_v_Name.trim().contains(V_Name);
		soft.assertEquals(status1, true);
//jlib.verifyInfo( act_v_Name,V_Name);

		String act_Email = vip.getVendorEmailInfo().getText();
		boolean status2 = act_Email.trim().contains(E_mail);
		soft.assertEquals(status2, true);
//jlib.verifyInfo( act_Email,E_mail);

		String act_PhoneNo = vip.getVendorPhoneInfo().getText();
		boolean status3 = act_PhoneNo.trim().contains(PhoneNo);
		soft.assertEquals(status3, true);
		soft.assertAll();
//jlib.verifyInfo( act_PhoneNo,PhoneNo);
	}
}
