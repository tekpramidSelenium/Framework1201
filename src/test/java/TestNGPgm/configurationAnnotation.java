package TestNGPgm;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class configurationAnnotation {
@BeforeSuite
public void beforsuite()
{
	System.out.println("start connect to Db and report configure");
}

@BeforeClass
public void bc()
{
	System.out.println("launching the browser");
}
@AfterClass
public void ac()
{
	System.out.println("close the browser");
}
@BeforeMethod
public void bm()
{
	System.out.println("login to app");
}
@AfterMethod
public void am()
{
	System.out.println("signout the app");
}

@Test
public void createContactTest()
{
	System.out.println(" create contact");
}

@Test
public void createOrgTest()
{
	System.out.println("create orgnaize");
}
@AfterSuite
public void aftersuite()
{
	System.out.println("close connection to Db and report backup");
}
}
