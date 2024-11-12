package comCRM.generic.baseUtility;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderTest {
@DataProvider(name="received data")
public Object[][] getData1()
{
	Object[][] Arr=new Object[3][2];
	Arr[0][0]="Arun";
	Arr[0][1]="Hr";
	
	Arr[1][0]="Ram";
	Arr[1][1]="Desiner";
	
	Arr[2][0]="Iniyan";
	Arr[2][1]="Tester";
	
	return Arr;}
@DataProvider
public Object[][] getData()
{
	Object[][] Arr=new Object[3][2];
	Arr[0][0]="Deva";
	Arr[0][1]="Hr";
	
	Arr[1][0]="Jhon";
	Arr[1][1]="Desiner";
	
	Arr[2][0]="Pavi";
	Arr[2][1]="Tester";
	
	return Arr;}
@Test(dataProvider = "received data")
public void createDataTest(String Name,String job)
{
	System.out.println(Name+" "+job);
}
@Test(dataProvider = "getData")
public void createAccountTest(String Name,String job)
{
	System.out.println(Name+" "+job);
}
}
