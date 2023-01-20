package com.generic.libraries;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.objectRepo.HomePage;
import com.crm.objectRepo.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public  static WebDriver sdriver;
	public DatabaseUtility dLib=new DatabaseUtility();
	public ExelUtility eLib=new ExelUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();

	@BeforeSuite(alwaysRun = true)

	public void configDB() throws Throwable {
		dLib.connectToDb();
		System.out.println("----connect to db--");
	}
	//@Parameters("BROWSER")//for cross browser
	@BeforeClass(alwaysRun = true)//for group execution we have to write in all annotation (alwaysRun) =true)
	//public void configBC(String BROWSER) throws Throwable {//string browser  for cross browser testing 
		public void configBC() throws Throwable { 
		String BROWSER = fLib.readDataFromPropertFile("browser");
		String URL = fLib.readDataFromPropertFile("url");

		if(BROWSER.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Me\\msedgedriver.exe");
			driver=new EdgeDriver();  

		}


		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("inavlid browser") ;
		}
		sdriver=driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageLaod(driver);
		driver.get(URL);
		System.out.println("---launch the browser------");
		
	}

	@BeforeMethod(alwaysRun = true)

	public void configBM() throws Throwable
	{
		String USERNAME = fLib.readDataFromPropertFile("username");
		String PASSWORD = fLib.readDataFromPropertFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.getLoginPage(USERNAME, PASSWORD);
		System.out.println("----login to the app---");
	}
	@AfterMethod(alwaysRun = true)  
	public void configAM()
	{
		HomePage hp=new HomePage(driver);
		hp.signOut(wLib, driver);
		System.out.println("----logout from the app-----");
	}


	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
		System.out.println("---close the browser-----");
	}
	@AfterSuite
	public void discnnecDB() throws SQLException
	{
		dLib.closeDB();
		System.out.println("-----close the databse---");
	}
}

