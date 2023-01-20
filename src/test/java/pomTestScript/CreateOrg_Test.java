 package pomTestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.objectRepo.CreateOrganizationPage;
import com.crm.objectRepo.HomePage;
import com.crm.objectRepo.LoginPage;
import com.crm.objectRepo.OrgInfoPage;
import com.crm.objectRepo.OrganizationPage;
import com.generic.libraries.ExelUtility;
import com.generic.libraries.FileUtility;
import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class CreateOrg_Test {
	static WebDriver driver=null;
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		//create object for generic class
		JavaUtility jLib=new JavaUtility();
		FileUtility flib= new FileUtility();
		ExelUtility  elib= new ExelUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		
		
		/*get random data*/
		int random = jLib.getRandomNo();
		
		/*Random ran= new Random();
		int random = ran.nextInt(500);*/
		
		//step1: get common data
		String Browser = flib.readDataFromPropertFile("browser");
		String URL = flib.readDataFromPropertFile("url");
		String UserName = flib.readDataFromPropertFile("username");
		String password = flib.readDataFromPropertFile("password");
		
		
		
		String orgNameDetail = elib.readDataFromExel("OrganiZation1", 0, 1);
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
		
		// to maximaxize the window
		/* driver.manage().window().maximize();*/
		
		 wLib.maximizeWindow(driver);
		
		 driver.get(URL);
		 
		 //login page
		 LoginPage lp=new LoginPage(driver);
		 lp.getLoginPage(UserName,password);
		 
		 
		 //click on org module
		 HomePage hp=new HomePage(driver);
		 hp.clickOnOrganisation();
		 
		 //clic on create org lokup button
		 OrganizationPage op=new OrganizationPage(driver);
				 op.createOrgPopup();
		 
		 //fill org information
				 CreateOrganizationPage orgInfo=new CreateOrganizationPage(driver);
				 orgInfo.getOrganizationInfo(orgNameDetail, "Education", "Customer", jLib, wLib);
		 
		 
				 //verify
				 OrgInfoPage verifyOInfoP=new OrgInfoPage(driver);
				//Thread.sleep(2000);
				 wLib.waitForPageLaod(driver);
				 String actulmsg = verifyOInfoP.getOrgHeaderInfo();
				if(actulmsg.contains(orgNameDetail))
				{
					System.out.println("SUCESSFUL");
				}
				else {
					System.out.println("not created");
				}
		 
				// logout
				hp.signOut(wLib, driver);
		 //close browser
		 //driver.close();
		 

		
	
	
	}

}
