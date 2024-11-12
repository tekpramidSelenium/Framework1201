package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorName {
	public CreateNewVendorName(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="vendorname")
	private WebElement vendorNameBtn;
	
	@FindBy(name="email")
	private WebElement vendorEmailBtn;
	
	@FindBy(name="phone")
	private WebElement vendorPhoneNoBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getVendorNameBtn() {
		return vendorNameBtn;
	}

	public WebElement getVendorEmailBtn() {
		return vendorEmailBtn;
	}

	public WebElement getVendorPhoneNoBtn() {
		return vendorPhoneNoBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createVendor(String V_Name,String E_mail,String PhoneNo)
	{
		vendorNameBtn.sendKeys(V_Name);
		vendorEmailBtn.sendKeys(E_mail);
		vendorPhoneNoBtn.sendKeys(PhoneNo);
		saveBtn.click();
	}
	
}
