package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NONselectqueryTest {
	public static void main(String[]args) throws SQLException {
		
		Connection con=null;
		int result =0;
		try {
		Driver driver=new Driver();
		 //step1:register the database
		DriverManager.registerDriver(driver);
		
		 //step2:get connection for the database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root","root");
		
		 //step3:issue create  query statement
		
		Statement state = con.createStatement();
		
		String query = "insert into studentIFo values('surya','btm','selenium',3);";
		
		 //step4:update query
		  result=state.executeUpdate(query);
	
	}
		catch(Exception e){
			
		}
		finally {
			if(result==1)
			{
				System.out.println("data isserted sucessfully");
			}
			else 
			{
			System.out.println("data not inserted");
			}
			con.close();
		}

}
	}
