package comCRM.generic.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;



public class DBUtility {
	Connection con=null;
public void getDBConnection(String url,String un,String pwd) throws SQLException
{
	try
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(url,un,pwd);
	}
	 catch (Exception e) {
		
	}
	}

public void getDBConnection() throws SQLException
{
	try
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	}
	 catch (Exception e) {
		
	}
	}
public void closeDBConnection() throws SQLException
{
	try
	{
		con.close();
	}
	 catch (Exception e) {
		
	}
	}
public ResultSet executeSelectquery(String query) throws SQLException
{ResultSet result=null;
	try
	{
		Statement s = con.createStatement();
		result=s.executeQuery(query);
	}
	 catch (Exception e) {
		
	}
	return result;
	}
public int executeNonSelectquery(String query) throws SQLException
{int result=0;
	try
	{
		Statement s = con.createStatement();
		result=s.executeUpdate(query);
	}
	 catch (Exception e) {
		
	}
	return result;
	}
}
