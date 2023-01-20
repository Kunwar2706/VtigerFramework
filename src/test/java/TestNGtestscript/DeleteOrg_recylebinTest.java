package TestNGtestscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.objectRepo.CreateOrganizationPage;
import com.crm.objectRepo.DelelteOrg_EditOrg;
import com.crm.objectRepo.HomePage;
import com.crm.objectRepo.LoginPage;
import com.crm.objectRepo.OrganizationPage;
import com.crm.objectRepo.RecyclebinPage;
import com.generic.libraries.BaseClass;
import com.generic.libraries.ExelUtility;
import com.generic.libraries.FileUtility;
import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class DeleteOrg_recylebinTest extends BaseClass {
	@Test(groups= {"smoke","regression"})
public void deleteOrgrecyle() throws Throwable
{

	String orgNameDetail = eLib.readDataFromExel("OrganiZation1", 0, 1)+jLib.getRandomNo();
    String orgDrop = eLib.readDataFromExel("OrganiZation1", 6, 0);
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
        
    	
  		//hp.signOut(wLib, driver);
  		
}
}
