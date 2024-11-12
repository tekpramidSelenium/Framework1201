package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leadspage {
	public Leadspage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);// loginpage.class instead of we use this keyword
	}
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement newLeadsBtn;
	
	public WebElement getNewLeadsBtn() {
		return newLeadsBtn;
	}
	
}
