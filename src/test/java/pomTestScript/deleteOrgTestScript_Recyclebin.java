package pomTestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.objectRepo.CreateOrganizationPage;
import com.crm.objectRepo.DelelteOrg_EditOrg;
import com.crm.objectRepo.HomePage;
import com.crm.objectRepo.LoginPage;
import com.crm.objectRepo.OrganizationPage;
import com.crm.objectRepo.ProductForFaqPages;
import com.crm.objectRepo.RecyclebinPage;
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

	String orgNameDetail = eLib.readDataFromExel("OrganiZation1", 0, 1)+jLib.getRandomNo();
    String orgDrop = eLib.readDataFromExel("OrganiZation1", 6, 0);
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
	 

	 //click on create org lokup button
	 OrganizationPage op=new OrganizationPage(driver);
			 op.createOrgPopup();
	 
	 //fill org information
			 CreateOrganizationPage orgInfo=new CreateOrganizationPage(driver);
			 orgInfo.getOrganizationInfo(orgNameDetail, "Education", "Customer", jLib, wLib);
			 
	// for delete operation
			 DelelteOrg_EditOrg del=new DelelteOrg_EditOrg(driver);
		
         	del.clickOndelete(wLib, driver);
       
         	//click on more
         	hp.more();
         	hp.recyclebin();
         	
         	//
         	RecyclebinPage rp=new RecyclebinPage(driver);
         	rp.searchTextField(orgNameDetail);
         	rp.dropDwonIn(wLib, orgDrop);
         	Thread.sleep(2000);
          rp.clickOnSearchNowBtn();
            driver.findElement(By.partialLinkText("testyantra")).click();
         	
        //validation
  	    Thread.sleep(2000);
  	    boolean actual = driver.findElement(By.xpath("//center[contains(.,'deleted')]")).isDisplayed();
  	    
  	    if(actual=true) {
  	    	System.out.println(actual);
  	    	System.out.println("testcase passed");
  	    }
  	    else {
  	    	System.out.println("testcase failed");
  	    }
        
    	
  		hp.signOut(wLib, driver);
  		
}
}
