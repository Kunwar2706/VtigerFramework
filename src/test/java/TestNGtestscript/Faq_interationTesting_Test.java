package TestNGtestscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.objectRepo.CreateNewFaqPage;
import com.crm.objectRepo.Faqpage;
import com.crm.objectRepo.HomePage;
import com.crm.objectRepo.LoginPage;
import com.crm.objectRepo.ProductForFaqPages;
import com.generic.libraries.BaseClass;
import com.generic.libraries.ExelUtility;
import com.generic.libraries.FileUtility;
import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class Faq_interationTesting_Test extends BaseClass {
	@Test(groups={"regression"})
public void searchproduct() throws Throwable {

	//read data from excel sheet//
	String pname = eLib.readDataFromExel("faq_pom", 1, 0);
	String faqStatus = eLib.readDataFromExel("faq_pom", 1, 1);
	String produtDrop = eLib.readDataFromExel("faq_pom", 0, 0);
	String faqQuestion = eLib.readDataFromExel("faq_pom", 1, 2);
	String faqAnswer = eLib.readDataFromExel("faq_pom", 1, 3);
	
	

	//click on more
	 HomePage hp=new  HomePage(driver);
	 hp.more();
	 hp.clicKOnFaq();
	 
	 //click on plusicon
	 Faqpage fp=new Faqpage(driver);
	 fp.clickOnCreateFaqlookUp();
	 
	 CreateNewFaqPage cnf = new CreateNewFaqPage(driver);
	 
	 cnf.getLookup().click();
	 wLib.switchToWindow(driver, "Product");
	 
	 //
	 ProductForFaqPages pp=new ProductForFaqPages(driver);
	 pp.searchTextField(pname);
	 pp.producType(wLib, produtDrop);
	 pp.getSearchNow().click();
	 
	 wLib.waitForPageLaod(driver);
	 driver.findElement(By.linkText(pname)).click();
	 wLib.switchToWindow(driver, "faq");
	 
	 cnf.selectStatus(wLib, faqStatus);
	 cnf.getQuestion().sendKeys(faqQuestion);
	 cnf.getFaq_answer().sendKeys(faqAnswer);
	 cnf.getSavebtn().click();
	 
	
	// hp.signOut(wLib, driver);
}
}
