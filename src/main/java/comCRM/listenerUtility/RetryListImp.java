package comCRM.listenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListImp implements IRetryAnalyzer{
int count=0;
int limitCount=2;
	@Override
	public boolean retry(ITestResult result) {
		//ITestResult r=result;
		//System.out.println(r);
		if(count<limitCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
