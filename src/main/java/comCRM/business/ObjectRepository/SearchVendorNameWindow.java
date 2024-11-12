package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchVendorNameWindow {

	public SearchVendorNameWindow(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "search_txt")
	private WebElement searchEdt;

	@FindBy(name = "search")
	private WebElement searchBtn;
	
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public void searchVendor(String vendorName)
	{
		searchEdt.sendKeys(vendorName);
		searchBtn.click();
	}
}
