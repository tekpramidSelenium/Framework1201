package TestNG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;




@Listeners(comCRM.listenerUtility.ListenerImplTest.class)
public class listenrPracticed extends Base {
@Test()
public void checkingScreecnshot()
{WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.in");
	String act=driver.getTitle();
Assert.assertEquals(act, "Home");
driver.quit();
	System.out.println("success");
}
@Test
public void checkingScreecnshot1()
{WebDriver driver=new EdgeDriver();
driver.get("https://www.amazon.in");
	String act=driver.getTitle();
Assert.assertEquals(act, act);
driver.quit();
	System.out.println("success");
}
}
