package practicedCleaniquePgm;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SkinCareTest {
@Test
public void fetchSkinCareDropdown() throws Throwable
{/*
	 * ChromeOptions opt=new ChromeOptions();
	 * opt.addArguments("--disable-notifications");
	 */
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.clinique.in/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	WebElement ele=driver.findElement(By.xpath("//button[@id='Skincare']/.."));
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	
	 List<WebElement> ele1 =driver.findElements(By.xpath("//a[contains(., 'All Skincare')]/.."));
	
	 for (WebElement w : ele1) {
		
			String text =w.getText();
			System.out.println(text);
	}
	
	driver.quit();
	
	
}
}
