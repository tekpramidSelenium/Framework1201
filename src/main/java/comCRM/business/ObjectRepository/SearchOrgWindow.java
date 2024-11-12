package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchOrgWindow {

	public SearchOrgWindow(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "search_txt")
	private WebElement searchEdt;

	@FindBy(name = "search")
	private WebElement searchBtn;
	
	public void searchOrg(String orgName)
	{
		searchEdt.sendKeys(orgName);
		searchBtn.click();
	}
}
