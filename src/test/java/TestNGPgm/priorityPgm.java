package TestNGPgm;

import org.testng.annotations.Test;

public class priorityPgm {
@Test(priority = 0)
public void createContact()
{
	System.out.println("create HDFC contact");
}
@Test(priority = 1)
public void modifyContact()
{
	System.out.println("execute query insert contact with DB ");
	System.out.println("modify contact from HDFC to ICICI");
}
@Test(priority = 2)
public void deleteContact()

{
	System.out.println("execute query insert contact with DB ");
	System.out.println("delete contact ICICI");
}
}
