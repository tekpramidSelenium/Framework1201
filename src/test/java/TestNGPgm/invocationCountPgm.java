package TestNGPgm;

import org.testng.annotations.Test;

public class invocationCountPgm {
	@Test
	public void createContact()
	{
		System.out.println("create HDFC contact");
	}
	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		
		System.out.println("modify contact from HDFC to ICICI");
	}
	@Test(dependsOnMethods = "modifyContact")
	public void deleteContact()

	{
		
		System.out.println("delete contact ICICI");
	}

	/*
	 * public void abc() {
	 * 
	 * System.out.println("modify contact from HDFC to ICICI"); }
	 * 
	 * public static void xyz() {
	 * 
	 * System.out.println("modify contact from HDFC to ICICI"); }
	 * 
	 * public static void main(String[] args) { System.out.println("main start");
	 * dependsOnMethodPgm d=new dependsOnMethodPgm(); d.abc(); xyz();
	 * System.out.println("main end");
	 * 
	 * }
	 */
	
}
