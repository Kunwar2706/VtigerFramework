package com.crm.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.generic.libraries.ExelUtility;
import com.generic.libraries.FileUtility;
import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class creatingLead_testScript {
	static WebDriver driver=null;
	public static void main(String[] args) throws Throwable {
	//creating object utility
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	ExelUtility eLib=new ExelUtility();
	FileUtility fLib=new FileUtility();
	
	//get random no;
	
	jLib.getRandomNo();
	
	//get common data from property file
	String Browser = fLib.readDataFromPropertFile("browser");
	String URL = fLib.readDataFromPropertFile("url");
	String  USERNAME= fLib.readDataFromPropertFile("username");
	String PASSWORD = fLib.readDataFromPropertFile("password");
	
	
	// READ DATA FROM EXEL
	String salute = eLib.readDataFromExel("LEADPOM", 1, 0);
	String fName = eLib.readDataFromExel("LEADPOM", 1, 1);
	  String LName = eLib.readDataFromExel("LEADPOM", 1, 2);
	 String Com = eLib.readDataFromExel("LEADPOM", 1, 3);
	 String leadsource = eLib.readDataFromExel("LEADPOM", 1, 4);
	 String industry = eLib.readDataFromExel("LEADPOM", 1, 5);
	 // launch the browser
	 
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("ie")) {
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("invalid browser");
		}
	 //get the 

	 driver.get(URL);
	 
	 //Maximize the window
	 wLib.maximizeWindow(driver);
	 
	 //wait for page load
	 wLib.waitForPageLaod(driver);
	 
	 // login
	 LoginPage lp=new LoginPage(driver);
	 lp.getLoginPage(USERNAME, PASSWORD);
	 
	 // click on lead module
	 HomePage hp=new HomePage(driver);
	 hp.clickOnLeads();
	 
// Click on create lead lookup
	 LeadsPage lp1=new LeadsPage(driver);
	 lp1.getCreateLead();
	 
	 //fill necessary detail
	 CreatingNewLeadPage createLeadPg=new CreatingNewLeadPage(driver);
	 createLeadPg.getLeadInfo(wLib,salute, fName, LName, Com, jLib, leadsource, industry);
	 
	 // verify
	 VerifyLeadInfoPage vrfyleadInfo= new VerifyLeadInfoPage(driver);
	 Thread.sleep(2000);
	 String actualmsg = vrfyleadInfo.getLeadHeaderInfo();
	 if(actualmsg.contains(fName)) {
		 System.out.println("sucessfull");
		 
	 }
	 else {
		 System.out.println("not created");
	 }
	 
	 hp.signOut(wLib, driver);
}
}
