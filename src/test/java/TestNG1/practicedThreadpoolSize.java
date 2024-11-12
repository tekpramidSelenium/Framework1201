package TestNG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class practicedThreadpoolSize {
@Test (invocationCount=4, threadPoolSize =2)
public void method()
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in");
	driver.close();
}
}
