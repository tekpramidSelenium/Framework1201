package comCRM.business.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comCRM.generic.WebdriverUtility.WebdriverUtility;

public class Loginpage extends WebdriverUtility{//rule 1: create a separate java class
	//rule 2: object creation
	//rule 3: object initialization
	WebDriver driver=null;
	public Loginpage (WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver,this);// loginpage.class instead of we use this keyword
	}
	
@FindBy(name="user_name")
private WebElement userEdt;
@FindBy(name="user_password")
private WebElement passwordEdt;
@FindBy(id="submitButton")
private WebElement loginbtn;

// rule 4: object encapsulation
public WebElement getUserEdt() {
	return userEdt;
}
public WebElement getPasswordEdt() {
	return passwordEdt;
}
public WebElement getLoginbtn() {
	return loginbtn;
}
// rule 5: provide action  or object utilization
public void loginToapp(String url,String username,String password)
{// getUserEdt.sendKeys(username);
//	getPasswordEdt.sendKeys(password);
//	getLoginbtn.click();
	driver.manage().window().maximize();
	waitforpageLoad(driver,40); 
	driver.get(url);
	userEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	loginbtn.click();
}

}
