package comCRM.generic.WebdriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
public void waitforpageLoad(WebDriver driver,int t)
{
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(t));
}
public void waitforElementPresent(WebDriver driver,WebElement ele)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(ele));
}
public void switchtoNewBrowserTab(WebDriver driver,String partialurl)
{
	 Set<String> ele = driver.getWindowHandles();
	 Iterator<String> it = ele.iterator();
	 while(it.hasNext())
	 {
		String windowId= it.next();
		driver.switchTo().window(windowId);
		String P_url=driver.getCurrentUrl();
		if(P_url.contains(partialurl))
		{
			break;
		}
	 }
}
public void switchtoTabOnTitle(WebDriver driver,String partialTitle)
{
	 Set<String> ele = driver.getWindowHandles();
	 Iterator<String> it = ele.iterator();
	 while(it.hasNext())
	 {
		String windowId= it.next();
		driver.switchTo().window(windowId);
		String title=driver.getTitle();
		if(title.contains(partialTitle))
		{
			break;
		}
	 }
}

public void switchtoFrame(WebDriver driver,int index) 
{
	driver.switchTo().frame(index);
}

public void switchtoFrame(WebDriver driver,String nameId) 
{
	driver.switchTo().frame(nameId);
}

public void switchtoFrame(WebDriver driver,WebElement ele) 
{
	driver.switchTo().frame(ele);
}

public void switchtoAlertandAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
public void switchtoAlertandCancel(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

public void select(WebElement ele,int index)
{
	Select sel=new Select(ele);
	sel.selectByIndex(index);
}
public void select(WebElement ele,String text)
{
	Select sel=new Select(ele);
	sel.selectByVisibleText(text);
}
public void selectvalue(WebElement ele,String text)
{
	Select sel=new Select(ele);
	sel.selectByValue(text);
}

public void mousemoveOnElement(WebDriver driver,WebElement ele)
{
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
}
public void doubleclick(WebDriver driver,WebElement ele)
{
	Actions act=new Actions(driver);
	act.doubleClick(ele).perform();
}
public void rightClick(WebDriver driver,WebElement ele) {
	Actions act=new Actions(driver);
	act.contextClick(ele).perform();
}
public void leftClick(WebDriver driver,WebElement ele) {
	Actions act=new Actions(driver);
	act.click(ele).perform();
}
public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst) {
	Actions act=new Actions(driver);
	act.dragAndDrop(src,dst).perform();
}


public void screenshotOnBrowser(WebDriver driver) throws IOException
{
	Date d=new Date();
	String s=d.toString();
	s.replaceAll(":", "-");
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dst=new File("./photo/"+s+".jpeg");
	FileHandler.copy(src, dst);
}
public void screenshotOnElement(WebElement ele) throws IOException
{
	Date d=new Date();
	String s=d.toString();
	s.replaceAll(":", "-");
	File src=ele.getScreenshotAs(OutputType.FILE);
	File dst=new File("./photo/"+s+".jpeg");
	FileHandler.copy(src, dst);
}
public WebDriver launchingBrowser(String browser) {
	WebDriver driver=null;
	
	if(browser.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if (browser.equals("firefox")) {
		driver =new FirefoxDriver();
	}
	else if(browser.equals("edge"))
	{
		driver =new EdgeDriver();
	}
	
	return driver;
}
public void navigateAction(WebDriver driver,String act)
{
	
	if (act.contains("refresh")) {
		driver.navigate().refresh();
	}
	else if (act.contains("back")) {
		driver.navigate().back();
	}
	else if (act.contains("forward")) {
		driver.navigate().forward();
	}
	else
	{
		driver.manage().window().maximize();
	}
}
public void sendDatatoDisbledElement(WebDriver driver,String data,String id)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("document.getElementById('"+id+"').value='"+data+"'");
}
public void scrollByElement(WebDriver driver,int x,int y)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy("+x+","+y+")");
}

public void zoominAndzoomOut(WebDriver driver,int x) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("document.body.style.zoom='"+x+"%'");
}

public void closeTab(WebDriver driver)
{
	driver.close();
}
public void closeTabAll(WebDriver driver)
{
	driver.quit();
}

}
