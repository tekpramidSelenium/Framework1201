package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationpage {
	public Organizationpage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);// loginpage.class instead of we use this keyword
	}
	@FindBy(xpath ="//img[@title='Create Organization...']")
	private WebElement newOrgIcon;
	
	public WebElement getNewOrgIcon() {
		return newOrgIcon;
	}
	
}
