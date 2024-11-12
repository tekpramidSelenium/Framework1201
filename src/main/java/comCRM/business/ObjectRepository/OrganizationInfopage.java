package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfopage {
	public OrganizationInfopage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgNameInfo;
	@FindBy(id = "dtlview_Industry")
	private WebElement industryInfo;
	@FindBy(id = "dtlview_Type")
	private WebElement typeInfo;
	@FindBy(id = "dtlview_Phone")
	private WebElement phoneNoInfo;
	
	public WebElement getPhoneNoInfo() {
		return phoneNoInfo;
	}
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	public WebElement getOrgNameInfo() {
		return orgNameInfo;
	}
	public WebElement getIndustryInfo() {
		return industryInfo;
	}
	public WebElement getTypeInfo() {
		return typeInfo;
	}
	
}
