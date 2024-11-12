package TestNGPgm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import comCRM.generic.FileUtility.ExcelUtility;

public class FlipkartDataprovider {
@Test   //(dataProvider = "getData")
public void getProductDataTest()
{
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	String BrandName="iphone";
	String ProductName="Apple iPhone 16 (256 GB) - Ultramarine";
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//search the product
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName,Keys.ENTER);
	
	//get the price of the each product
	String x="//span[.='"+ProductName+"']/../../../../div[3]/div[1]/div/div[1]/div/div[1]/a/span/span[2]";
	String price=driver.findElement(By.xpath(x)).getText();
	System.out.println(price);  
	driver.quit();
	
}

 @DataProvider
 public Object[][] getData() throws Throwable {
	 ExcelUtility elib=new ExcelUtility(); int rowcount=elib.getRowcount("AmazonProduct");
  Object [][] objArr=new Object[rowcount][2]; 
  for(int i=0;i<rowcount;i++) {
  objArr[i][0]=elib.getDatafromExcelfile("AmazonProduct", i+1, 0);
  objArr[i][1]=elib.getDatafromExcelfile("AmazonProduct", i+1, 1); }
  return
  objArr; }  
 
}
