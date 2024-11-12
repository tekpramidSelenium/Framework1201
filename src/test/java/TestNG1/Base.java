package TestNG1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Base {

	@BeforeSuite
	public void bs()
	{
		System.out.println("@BeforeSuite");
	}
	@AfterSuite
	public void As()
	{
		System.out.println("@AfterSuite");
	}
	@BeforeTest
	public void Bf()
	{
		System.out.println("@BeforeTest");
	}
	@AfterTest
	public void At()
	{
		System.out.println("@AfterTest");
	}
	@BeforeClass
	public void BC()
	{
		System.out.println("@BeforeClass");
	}
	@AfterClass
	public void AC()
	{
		System.out.println("@AfterClass");
	}
	@BeforeMethod
	public void Bm()
	{
		System.out.println("@BeforeMethod");
	}
	@AfterMethod
	public void AM()
	{
		System.out.println("@AfterMethod");
	}
	
}
