package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		// step 2:create object for property
		Properties pObj = new Properties();
		
		// step 3. load the file
		
		 pObj .load(fis);
		 // 3: read the data from file
		 
		 String URL = pObj.getProperty("url");
		 String USERNAME = pObj.getProperty("username");
		 String PASS = pObj.getProperty("password");
		 String BROW = pObj.getProperty("browser");
		 System.out.println(URL);
		 System.out.println(USERNAME);
		 System.out.println(PASS);
		 System.out.println(BROW);
		 

	}

}
