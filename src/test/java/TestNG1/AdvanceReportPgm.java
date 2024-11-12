package TestNG1;

import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AdvanceReportPgm {
	public ExtentReports reports;
@BeforeSuite
public void configureBs()
{  // spark report configure
	ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
	spark.config().setDocumentTitle("Crm test results");
	spark.config().setReportName("CRM");
	spark.config().setTheme(Theme.DARK);
	
	//add env information and create test
	 reports=new ExtentReports();
	reports.attachReporter(spark);
	reports.setSystemInfo("OS", "Windows-10");
	reports.setSystemInfo("Browser", "Chrome-130.0.06");
	
}
@AfterSuite
public void configureAS() {
	reports.flush();
}

@Test
public void createContactTest(Method m)
{WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.in");
	String mName=m.getName();
	ExtentTest test=reports.createTest(mName);
	test.log(Status.INFO, "login to app");
	test.log(Status.INFO, "login to app");
	test.log(Status.INFO, "login to app");
	if("HDFC".equals("HDFC"))
		test.log(Status.PASS, "contact is created");
	else
		test.log(Status.FAIL, "contact is not created");
				
}

@Test
public void createContactWithPhoneTest(Method m)
{WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.in");
	String mName=m.getName();
	ExtentTest test=reports.createTest(mName);
	test.log(Status.INFO, "login to app");
	test.log(Status.INFO, "login to app");
	test.log(Status.INFO, "login to app");
	TakesScreenshot ts=(TakesScreenshot) driver;
	String filepath=ts.getScreenshotAs(OutputType.BASE64);
	
	if("HDFC".equals("HFC"))
		test.log(Status.PASS, "contact phone is created");
	else
	{
		test.addScreenCaptureFromBase64String(filepath,"error file");
	test.log(Status.FAIL, "contact phone is not created");
	}	
				
}

}
