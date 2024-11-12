package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorpageTest {
	public VendorpageTest(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//img[@title='Create Vendor...']")
	private WebElement createVendorBtn;
	
	public WebElement getCreateVendorBtn() {
		return createVendorBtn;
	}
	
	
}
