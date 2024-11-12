package TestNGPgm;

import org.testng.annotations.Test;

import comCRM.generic.baseUtility.dataProviderTest;

public class PracticedDataprovider {
@Test(dataProviderClass = dataProviderTest.class,dataProvider="getData")
public void readDataTest(String name,String job)
{	
	System.out.println(name+" "+job);
}

@Test(dataProviderClass = dataProviderTest.class,dataProvider="received data")
public void readDataTest1(String name,String job)
{	
	System.out.println(name+" "+job);
}
	
}

