package comCRM.business.ObjectRepository;
/** contact module info
 * @author Dilip
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfopage {
	public ContactInfopage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderMsg;
	@FindBy(id = "mouseArea_Last Name")
	private WebElement ContactNameInfo;
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDateInfo;
	@FindBy(id = "dtlview_Support End Date")
	private WebElement endDateInfo;
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgNameInfo;
	
	
	public WebElement getOrgNameInfo() {
		return orgNameInfo;
	}
	public WebElement getStartDateInfo() {
		return startDateInfo;
	}
	public WebElement getEndDateInfo() {
		return endDateInfo;
	}
	public WebElement getContactHeaderMsg() {
		return contactHeaderMsg;
	}
	public WebElement getContactNameInfo() {
		return ContactNameInfo;
	}
	
	
}
