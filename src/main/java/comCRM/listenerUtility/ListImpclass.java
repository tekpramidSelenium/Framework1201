package comCRM.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import comCRM.generic.WebdriverUtility.UtilityClassObject;
import comCRM.generic.baseUtility.BaseClass;

public class ListImpclass implements ITestListener,ISuiteListener
{public ExtentReports reports;
public static  ExtentTest test;
	@Override
	public void onTestFailure(ITestResult result) {
	
		String testName=result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)BaseClass .sdriver;
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath,testName+"_"+time);
		//test.log(Status.FAIL, result.getMethod().getMethodName()+"==>Failed<==");
		test.log(Status.FAIL,result.getThrowable());	
		} 
	@Override
	public void onTestStart(ITestResult result) {
		 test=reports.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"==>Started<==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName()+"==>Completed<==");
	}

	

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.INFO, result.getThrowable()+"==>Skipped<==");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log(" onTestFailedButWithinSuccessPercentage ITestResult",true);
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("onTestFailedWithTimeout ",true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("onStart ITestContext",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("onFinish ITestContext",true);
	}

	@Override
	public void onStart(ISuite suite) {

		Reporter.log("onStart ISuite",true);
		// spark report configure
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("Crm test results");
		spark.config().setReportName("CRM");
		spark.config().setTheme(Theme.DARK);
		
		//add env information and create test
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("OS", "Windows-10");
		reports.setSystemInfo("Browser", "Chrome-130.0.06");
	} 

	@Override
	public void onFinish(ISuite suite) {

		reports.flush();
	}
}

