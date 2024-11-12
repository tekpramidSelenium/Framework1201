package ScreenshotPgm;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenShot1 {
@Test
public void methods1() throws IOException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in");
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst=new File("./Screenshots/test1.png");
FileHandler.copy(src, dst);//FileUtils.copyFile(src, dst);
driver.quit();
}	
/*
 * @Test public void methods2() throws IOException { WebDriver driver=new
 * ChromeDriver(); driver.get("https://www.amazon.in"); //( Below
 *( EventFiringWebDriver only working for below 4.12.0 version selenium )
 * EventFiringWebDriver edriver=new EventFiringWebDriver(driver); File src =
 * edriver.getScreenshotAs(OutputType.FILE); File dst=new
 * File("./Screenshots/test2.png"); FileUtils.copyFile(src, dst); driver.quit();
 * }
 */
}		