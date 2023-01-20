package Practice_Home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class ReadData_Database {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
Driver driver=new Driver();

//step1:register to the data base
DriverManager.registerDriver(driver);

//step2: get connection for the data base;
 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");

//step3: issue create a statement
Statement state = conn.createStatement();
String query = "select * from studentIFo;";

//step4: excute query
         ResultSet result = state.executeQuery(query);
         while(result.next())
         {
        	 System.out.println(result.getString(1)+" "+result.getString(2)+"  "+result.getString(3));
         }
         
         
         
}
		catch(Exception e) {
			
		}
		conn.close();
		

}
}

