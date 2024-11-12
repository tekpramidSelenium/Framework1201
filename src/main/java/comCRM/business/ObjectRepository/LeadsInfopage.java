package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfopage {
	public LeadsInfopage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement leadsheaderMsg;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement leadslastNameInfo;
	
	@FindBy(id = "dtlview_Company")
	private WebElement companyInfo;

	@FindBy(id = "mouseArea_Lead Source")
	private WebElement leadSourceInfo;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryInfo;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phoneNoInfo;
	
	public WebElement getLeadsheaderMsg() {
		return leadsheaderMsg;
	}

	public WebElement getLeadslastNameInfo() {
		return leadslastNameInfo;
	}

	public WebElement getCompanyInfo() {
		return companyInfo;
	}

	public WebElement getLeadSourceInfo() {
		return leadSourceInfo;
	}

	public WebElement getIndustryInfo() {
		return industryInfo;
	}

	public WebElement getPhoneNoInfo() {
		return phoneNoInfo;
	}
	
	
	
	
	
}
