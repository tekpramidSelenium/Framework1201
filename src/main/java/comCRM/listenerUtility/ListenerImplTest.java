package comCRM.listenerUtility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplTest implements ISuiteListener,ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("onTestStart ITestResult");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(" onTestSucces ITestResult");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(" onTestFailure of  ITestListener ITestResult ");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped ITestResult");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(" onTestFailedButWithinSuccessPercentage ITestResult");
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout ");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart ITestContext");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish ITestContext");
	}

	@Override
	public void onStart(ISuite suite) {

		System.out.println("onStart ISuite");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish  ISuite");
	}

}
