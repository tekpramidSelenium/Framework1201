package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInfopage {
	public ProductsInfopage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productsheaderMsg;
	
	@FindBy(id="mouseArea_Product Name")
	private WebElement productNameInfo;
	
	@FindBy(id="mouseArea_Product Category")
	private WebElement productCategoryInfo;
	
	@FindBy(id="mouseArea_Vendor Name")
	private WebElement vendorNameInfo;

	public WebElement getProductsheaderMsg() {
		return productsheaderMsg;
	}

	public WebElement getProductNameInfo() {
		return productNameInfo;
	}

	public WebElement getProductCategoryInfo() {
		return productCategoryInfo;
	}

	public WebElement getVendorNameInfo() {
		return vendorNameInfo;
	}
	
	
	
	
}
