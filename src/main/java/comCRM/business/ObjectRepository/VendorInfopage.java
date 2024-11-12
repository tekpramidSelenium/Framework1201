package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfopage {

public  VendorInfopage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 @FindBy(className ="lvtHeaderText")
 private WebElement vendorHeaderMsg;
 
 @FindBy(id="mouseArea_Vendor Name")
 private WebElement vendorNameInfo;
 
 @FindBy(id="mouseArea_Email")
 private WebElement vendorEmailInfo;
 
 @FindBy(id="mouseArea_Phone")
 private WebElement vendorPhoneInfo;

public WebElement getVendorHeaderMsg() {
	return vendorHeaderMsg;
}

public WebElement getVendorNameInfo() {
	return vendorNameInfo;
}

public WebElement getVendorEmailInfo() {
	return vendorEmailInfo;
}

public WebElement getVendorPhoneInfo() {
	return vendorPhoneInfo;
}
 
 
}
