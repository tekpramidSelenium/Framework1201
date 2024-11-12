package TestNG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import comCRM.generic.baseUtility.BaseClass;

public class Batch4 extends BaseClass{
	@Parameters("browser")
	@Test
	public void createLeadsNameTest(@Optional("Chrome")String browser) throws Throwable
	{
		WebDriver driver=null;
		if(browser.contains("Chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if(browser.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		
	}

}
