package ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestwithPOM {
	@FindBy(name="user_name")
	WebElement ele1;
	@FindBy(name="user_password")
	WebElement ele2;
	@FindBy(id="submitButton")
	WebElement ele3;
	@Test
	public void SampleTest() throws Throwable
	{
	 WebDriver driver=new ChromeDriver();
	 
	 driver.get("http://localhost:8888");
	Thread.sleep(1000);
	SampleTestwithPOM s = PageFactory.initElements(driver,SampleTestwithPOM.class);
	System.out.println(s.ele1);
	s.ele1.sendKeys("admin");
	 s.ele2.sendKeys("manager");
		
		 driver.navigate().refresh();
		System.out.println(s.ele1);
		s.ele1.sendKeys("admin"); 
		s.ele2.sendKeys("manager");
		s.ele3.click();
		 driver.quit();
		 
	}

}
