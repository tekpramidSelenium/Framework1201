package comCRM.generic.FileUtility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
public String getDatafromJsonfile(String data) throws Throwable
{
FileReader fis=new FileReader("./src/main/resources/testData.json");
	JSONParser js=new JSONParser();
	Object obj=js.parse(fis);
	JSONObject jobj=(JSONObject)obj;
	String key=jobj.get(data).toString();
	return key;
}
}
