   package comCRM.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
public String getDatafromExcelfile(String sheetname,int row,int cell) throws Throwable
{
	FileInputStream fis=new FileInputStream("./testData/Practice.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	wb.close(); 
	return data;
	
}
public int getRowcount(String sheetname) throws Throwable
{
	FileInputStream fis=new FileInputStream("./testData/Practice.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	int rowcount=wb.getSheet(sheetname).getLastRowNum();
	wb.close();
	return rowcount;
}
public void setDataintoExcelfile(String sheetname,int row,int cell,String data) throws Throwable
{
	FileInputStream fis=new FileInputStream("./testData/Practice.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	wb.getSheet(sheetname).getRow(row).createCell(cell,CellType.STRING).setCellValue(data);
	FileOutputStream fo=new FileOutputStream("./src/test/resources/Practice.xlsx");
	wb.write(fo);
	wb.close();
	
}


}