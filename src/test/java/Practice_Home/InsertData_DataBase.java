package Practice_Home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertData_DataBase {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		int result=0;
		try {


			Driver driver=new Driver();

			//step1: get register to the database

			DriverManager.registerDriver(driver);

			//step2: get connection to the database 

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root", "root");

			//step3: create  statement

			Statement state = conn.createStatement();
			String query = "insert into studentIFo values('monu','sonu','golu',4);";

			//step 4: update query
			 result = state.executeUpdate(query);
		}
		catch(Exception e)
		{

		}
		finally {
			if(result==1) {
				System.out.println("inserted sucessfully");

			}
			else
			{
				System.out.println("not inserted");
			}

			conn.close();
		}
	}
}


