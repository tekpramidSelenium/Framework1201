package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productspage {
	public Productspage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);// loginpage.class instead of we use this keyword
	}
	@FindBy(xpath ="//img[@title='Create Product...']")
	private WebElement newProductsBtn;
	
	public WebElement getNewProductsBtn() {
		return newProductsBtn;
	}
	
}
