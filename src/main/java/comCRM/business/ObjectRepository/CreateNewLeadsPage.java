package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comCRM.generic.WebdriverUtility.WebdriverUtility;

public class CreateNewLeadsPage {
	public CreateNewLeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="lastname")
	private WebElement newLeadsNameEdt;
	
	@FindBy(name="company")
	private WebElement companyEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadsourceDD;
	
	@FindBy(name ="industry")
	private WebElement industryDD;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id="phone")
	private WebElement phoneEdt;
	
	public WebElement getNewLeadsNameEdt() {
		return newLeadsNameEdt;
	}

	public WebElement getCompanyEdt() {
		return companyEdt;
	}

	public WebElement getLeadsourceDD() {
		return leadsourceDD;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public void createLeads(String leadName, String companyName)
	{
		newLeadsNameEdt.sendKeys(leadName);
		companyEdt.sendKeys(companyName);;
		saveBtn.click();
	}
	
	public void createLeadsWithLeadSource(String L_Name,String C_Name,String L_Source,String industry )
	{
		newLeadsNameEdt.sendKeys(L_Name);
		companyEdt.sendKeys(C_Name); 
		WebdriverUtility wlib=new WebdriverUtility();
	    wlib.select(leadsourceDD, L_Source);
		wlib.select(industryDD, industry);
		saveBtn.click();
	}
	
	public void createLeadWithPhoneNo(String L_Name,String C_Name,String PhNo)
	{
		newLeadsNameEdt.sendKeys(L_Name);
		companyEdt.sendKeys(C_Name);
		phoneEdt.sendKeys(PhNo);
		saveBtn.click();
	}
}
