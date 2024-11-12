package comCRM.generic.baseUtility;


import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import comCRM.business.ObjectRepository.Homepage;
import comCRM.business.ObjectRepository.Loginpage;
import comCRM.generic.DatabaseUtility.DBUtility;
import comCRM.generic.FileUtility.ExcelUtility;
import comCRM.generic.FileUtility.FileUtility;
import comCRM.generic.WebdriverUtility.JavaUtility;
import comCRM.generic.WebdriverUtility.WebdriverUtility;

public class BaseClass2 {
	// Create  Object
public DBUtility dlib=new DBUtility();
public FileUtility fu=new FileUtility();
public ExcelUtility eu=new ExcelUtility();
public JavaUtility jlib=new JavaUtility();
public WebdriverUtility wlib=new WebdriverUtility();
public WebDriver driver=null;
public static WebDriver sdriver=null;
public SoftAssert soft=new SoftAssert();

@BeforeSuite (groups= {"smokeTest","regressionTest"})
public void beforsuite() throws SQLException
{
	System.out.println("start connect to Db and report configure");
	dlib.getDBConnection();
}
@AfterSuite(groups= {"smokeTest","regressionTest"})
public void afterSuite() throws SQLException
{
	System.out.println("close DB connection and report backup");
	dlib.closeDBConnection();
}
@Parameters("Browser")
@BeforeClass(groups= {"smokeTest","regressionTest"})
public void bc(@Optional("chrome")  String browser) throws Throwable//bc(@Optional="Opera" String browser)
{
	System.out.println("launching the browser");
	//String browser=fu.getDatafromPropertyfile("Browser"); 
	
	driver=wlib.launchingBrowser( browser);
	sdriver=driver;
}
@AfterClass(groups= {"smokeTest","regressionTest"})
public void ac()
{
	System.out.println("close the browser");
	 driver.quit();
}
@BeforeMethod(groups= {"smokeTest","regressionTest"})
public void bm() throws Throwable
{
	System.out.println("login to app");
	String url=fu.getDatafromPropertyfile("URl");
	String un=fu.getDatafromPropertyfile("Username");
	String pwd=fu.getDatafromPropertyfile("Password");
	
	Loginpage lp=new Loginpage(driver);
	lp.loginToapp(url,un,pwd);
	
}
@AfterMethod(groups= {"smokeTest","regressionTest"})
public void am()
{
	System.out.println("signout the app");
	Homepage hp=new Homepage(driver);
	hp.logOut();
}

}