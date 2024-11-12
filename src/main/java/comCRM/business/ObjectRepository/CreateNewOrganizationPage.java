package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comCRM.generic.WebdriverUtility.WebdriverUtility;

public class CreateNewOrganizationPage {
public CreateNewOrganizationPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
@FindBy(name="accountname")
private WebElement newOrgName;

@FindBy(name="industry")
private WebElement industryDD;

@FindBy(name="accounttype")
private WebElement typeDD;


@FindBy(name="phone")
private WebElement phoneNoEdt;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

public WebElement getNewOrgName() {
	return newOrgName;
}
public WebElement getSaveBtn() {
	return saveBtn;
}

public WebElement getIndustryDD() {
	return industryDD;
}
public WebElement getTypeDD() {
	return typeDD;
}

public WebElement getPhoneNoEdt() {
	return phoneNoEdt;
}
public void createOrg(String OrgName)
{
	newOrgName.sendKeys(OrgName);
	saveBtn.click();
}
public void createOrgWithPhoneNo(String OrgName,String PhNo)
{
	newOrgName.sendKeys(OrgName);
	phoneNoEdt.sendKeys(PhNo);
	saveBtn.click();
}

public void createOrgWithIndustry(String OrgName,String industry,String type)
{
	newOrgName.sendKeys(OrgName);
	WebdriverUtility wlib=new WebdriverUtility();
	wlib.select(industryDD,industry);
	wlib.select(typeDD, type);
	saveBtn.click();
}
}










