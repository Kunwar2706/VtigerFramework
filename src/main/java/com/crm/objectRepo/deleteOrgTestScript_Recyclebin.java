package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.generic.libraries.ExelUtility;
import com.generic.libraries.FileUtility;
import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class deleteOrgTestScript_Recyclebin {
	static WebDriver driver=null;
	public static void main(String[] args) throws Throwable {
	WebDriverUtility wLib=new WebDriverUtility();
	ExelUtility eLib=new ExelUtility();
	FileUtility fLib=new FileUtility();
	JavaUtility jLib=new JavaUtility();
	
	//read data from properties file//
	String URL = fLib.readDataFromPropertFile("url");
	String USERNAME = fLib.readDataFromPropertFile("username");
	String PASSWORD = fLib.readDataFromPropertFile("password");

	String orgNameDetail = eLib.readDataFromExel("OrganiZation1", 0, 1);
	//launch the browser//
	WebDriver driver=new ChromeDriver();
	wLib.maximizeWindow(driver);
	wLib.waitForPageLaod(driver);
	driver.get(URL);
	// to maximaxize the window
	/* driver.manage().window().maximize();*/
	
	 wLib.maximizeWindow(driver);
	
	 driver.get(URL);
	 
	 //login page
	 LoginPage lp=new LoginPage(driver);
	 lp.getLoginPage(USERNAME,PASSWORD);
	 
	 
	 //click on org module
	 HomePage hp=new HomePage(driver);
	 hp.clickOnOrganisation();
	 
	
}
}
