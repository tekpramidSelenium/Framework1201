package comCRM.generic.FileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
public String getDatafromPropertyfile(String data) throws Throwable
{
	FileInputStream fis=new FileInputStream("./src/main/resources/CommonData.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String key=pobj.getProperty(data);
	return key;
}
}
