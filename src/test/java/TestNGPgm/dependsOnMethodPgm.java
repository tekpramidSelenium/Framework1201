package TestNGPgm;

import org.testng.annotations.Test;

public class dependsOnMethodPgm {
	@Test (invocationCount = 3)
	public void createContact()
	{
		System.out.println("create HDFC contact");
	}
@Test(enabled = false)
	public void modifyContact()
	{
		
		System.out.println("modify contact from HDFC to ICICI");
	}
	@Test(enabled = false)
	public void deleteContact()

	{
		
		System.out.println("delete contact ICICI");
	}

	
}
