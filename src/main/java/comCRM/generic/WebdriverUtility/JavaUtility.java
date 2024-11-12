package comCRM.generic.WebdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber(int limit)
	{
		Random r=new Random();
		int rcount=r.nextInt(limit);
		return rcount;
	}
	
	public String getSystemDateYYYYMMDD()
	{
	    Date dobj=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String date=sd.format(dobj);
		return date;
	}
	public String getRequiredDateYYYYDDMM(int days)
	{
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		Calendar c=Calendar.getInstance();
	    c.add(Calendar.DAY_OF_MONTH,days);
		String enddate=sd.format(c.getTime());
		return enddate;
	}
	public void verifyInfo(String actData,String data)
	{
		if(actData.trim().contains(data))
		{
			System.out.println(data+" information is verified===Pass");
		}
		else
		{
			System.out.println(data+" information is not verified===Fail");
		}
	}
}
