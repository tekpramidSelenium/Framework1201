package comCRM.business.ObjectRepository;
/**contact page  webelement and business method
 * @author Dilip
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath ="//input[@name='lastname']")
	private WebElement newContactEdt;
	
	@FindBy(name="support_start_date")
	private WebElement startDateEdt;
	
	@FindBy(name="support_end_date")
	private WebElement requiredDateEdt;
	
	@FindBy(xpath ="//input[@name='account_name']/following-sibling::img")
	private WebElement OrgNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getRequiredDateEdt() {
		return requiredDateEdt;
	}

	public WebElement getNewContactEdt() {
		return newContactEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createContact(String ContactName)
	{
		newContactEdt.sendKeys(ContactName);
		saveBtn.click();
	}
	
	
	/**
	 * contains create contact with support date
	 * @param ContactName
	 * @param startDate
	 * @param endDate
	 */
	public void createContactWithSupportDate(String ContactName,String startDate,String endDate)
	{
		newContactEdt.sendKeys(ContactName);
		WebElement ele1 =startDateEdt;
		ele1.clear();
		ele1.sendKeys(startDate);
		
		WebElement ele2 =requiredDateEdt;
		ele2.clear();
		ele2.sendKeys(endDate);
		saveBtn.click();
	}
	
	/**
	 * contains create contact with org 
	 * @param ContactName
	 */
	public void createContactWithOrg(String ContactName)
	{
		newContactEdt.sendKeys(ContactName);
		OrgNameEdt.click();
	}
}
