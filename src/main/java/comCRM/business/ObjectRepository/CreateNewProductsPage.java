package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comCRM.generic.WebdriverUtility.WebdriverUtility;

public class CreateNewProductsPage {
	public CreateNewProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="productname")
	private WebElement ProductsEdt;
	
	@FindBy(name="productcategory")
	private WebElement productCategoryDD;
	
	@FindBy(name="Edit")
	private WebElement createProductEditBtn;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement vendorNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}


	public WebElement getCreateProductEditBtn() {
		return createProductEditBtn;
	}


	public WebElement getProductsEdt() {
		return ProductsEdt;
	}


	public WebElement getProductCategoryDD() {
		return productCategoryDD;
	}
	
   public void createProduct(String P_Name)
    {
	ProductsEdt.sendKeys(P_Name);
	saveBtn.click();
    }

    public void createProductCategory(String P_Name,String P_Category)
    {
    	ProductsEdt.sendKeys(P_Name);
    	WebdriverUtility wlib=new WebdriverUtility();
        wlib.select(productCategoryDD, P_Category);
        saveBtn.click();
    }
    
    public void editVendorName()
    {
    	createProductEditBtn.click();
    	vendorNameEdt.click();
    }
}
