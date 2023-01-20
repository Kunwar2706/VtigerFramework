package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDatafromDataBaseTest{
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {

			Driver driver =new Driver();
			//step1: register the database

			DriverManager.registerDriver(driver);

			//step2: get connection for  the database
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root","root");
			//step3: issue create statement
			
			Statement state = con.createStatement();
			String query = "select * from studentIFo;";

			//step4: execute query
			
			ResultSet result = state.executeQuery(query);

			while(result.next())
			{
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
			}

		}
		catch(Exception e) {

		}
		finally {
			//step5: lose the database
			con.close();
			System.out.println("close the data base");
		}
	}
}
