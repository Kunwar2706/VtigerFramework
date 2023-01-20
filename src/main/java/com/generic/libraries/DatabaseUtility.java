package com.generic.libraries;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con=null;

	public void connectToDb() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//con = DriverManager.getConnection(IpathConstants.DBURL,IpathConstants.DBUSERNAME,IpathConstants.DBPASSWORD);
		con = DriverManager.getConnection(IpathConstants.DBURLMYSQL,IpathConstants.DBUSERNAMEMYSQL,IpathConstants.DBPASSWORDMYSQL);
	}
	public String executeQueryAndgetData(String query,int columnINdex,String expData) throws Throwable {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) 
		{
			String data=result.getString(columnINdex);
			if(data.equalsIgnoreCase(expData)) {
				flag=true;
				break;

			}


		}
		if(flag)
		{
			System.out.println(expData+"project is createed");
			return expData;

		}


		else
		{

			System.out.println("project not created");
			return " ";
		}
	}
	public void closeDB() throws SQLException
	{
		con.close();
	}




}


 