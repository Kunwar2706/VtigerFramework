package TestNGtestscript;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.objectRepo.CreateOrganizationPage;
import com.crm.objectRepo.HomePage;
import com.crm.objectRepo.LoginPage;
import com.crm.objectRepo.OrgInfoPage;
import com.crm.objectRepo.OrganizationPage;
import com.generic.libraries.BaseClass;
import com.generic.libraries.ExelUtility;
import com.generic.libraries.FileUtility;
import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class CreateOrg_test extends BaseClass {
	@Test(groups={"regression"})
	public void createOrg() throws Throwable
	{
		/*get random data*/
		int random = jLib.getRandomNo();
		String orgNameDetail = eLib.readDataFromExel("OrganiZation1", 0, 1)+random;		

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

	}

}
