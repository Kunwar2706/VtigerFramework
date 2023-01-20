package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Rmg_server {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		int result=0;
		try {
		
			Driver driver=new Driver();
			//step1:register the database
			DriverManager.registerDriver(driver);
			//step2:get connection for the database
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			//step:create issue statement
			Statement state = con.createStatement();
			String query = "insert into project values('TY_project_206','amit','21-1-2022','vtiger','crated',4);";

			//update query
			result = state.executeUpdate(query);


		}
		catch(Exception e) {

		}
		finally {
			if(result==1) {
				System.out.println("data isserted sucessfully");
			}
			else {
				System.out.println("data not isserted");
			}
			con.close();
		}

	}
}
