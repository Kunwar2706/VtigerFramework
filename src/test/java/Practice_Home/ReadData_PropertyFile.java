package Practice_Home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadData_PropertyFile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties Pobj=new Properties();
		String URL = Pobj.getProperty("url");
		String usn = Pobj.getProperty("usernme");
		String psd = Pobj.getProperty("pasword");
		String brows = Pobj.getProperty("browser");
		System.out.println(URL);
		System.out.println(usn);
		System.out.println(psd);
		System.out.println(brows);


	}

}
