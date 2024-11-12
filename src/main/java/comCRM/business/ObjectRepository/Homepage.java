package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;
	public Homepage (WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver,this);// loginpage.class instead of we use this keyword
	}
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath ="//a[contains(text(),'Sign Out')]")
	private WebElement signOutLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getAdminImg() {
		return adminImg;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
    public WebElement getVendorLink() {
		return vendorLink;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getProductLink() {
		return productLink;
	}
	public WebElement getLeadsLink() {
		return leadsLink;
	}
	public void logOut()
	{
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutLink.click();
	}
}	

