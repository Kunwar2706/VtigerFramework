package TestNGtestscript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.*;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.objectRepo.CreatingNewLeadPage;
import com.crm.objectRepo.HomePage;
import com.crm.objectRepo.LeadsPage;
import com.crm.objectRepo.LoginPage;
import com.crm.objectRepo.VerifyLeadInfoPage;
import com.generic.libraries.BaseClass;
import com.generic.libraries.ExelUtility;
import com.generic.libraries.FileUtility;
import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

@Listeners(com.generic.libraries.ListenerImplimentionClass.class)
public class createLeadTest extends BaseClass{
	//(retryAnalyzer = com.generic.libraries.RetryImplementationClass.class)
	@Test
	public void createLead() throws Throwable {
		jLib.getRandomNo();


		// READ DATA FROM EXEL
		String salute = eLib.readDataFromExel("LEADPOM", 1, 0);
		String fName = eLib.readDataFromExel("LEADPOM", 1, 1);
		String LName = eLib.readDataFromExel("LEADPOM", 1, 2);
		String Com = eLib.readDataFromExel("LEADPOM", 1, 3);
		String leadsource = eLib.readDataFromExel("LEADPOM", 1, 4);
		String industry = eLib.readDataFromExel("LEADPOM", 1, 5);

		// click on lead module
		HomePage hp=new HomePage(driver);
		hp.clickOnLeads();
		


		// Click on create lead lookup
		LeadsPage lp1=new LeadsPage(driver);
		lp1.getCreateLead();
		Assert.fail();
	

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
		
	}
//	@Test
//	public void sample1() {
//		System.out.println("---sample 1---");//for regresion execution
//	}
//	@Test
//	public void sample2() {
//		System.out.println("---sample 2---");
//	}
	
}


