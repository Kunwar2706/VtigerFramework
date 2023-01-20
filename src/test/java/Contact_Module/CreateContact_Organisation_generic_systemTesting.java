package Contact_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.generic.libraries.ExelUtility;
import com.generic.libraries.FileUtility;
import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class CreateContact_Organisation_generic_systemTesting {

	static WebDriver driver=null;

	public static void main(String[] args) throws Throwable {
		//create object for the library
		FileUtility fLib =new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExelUtility eLib=new ExelUtility();
		WebDriverUtility wLIb=new WebDriverUtility();

		//get random data

		int random = jLib.getRandomNo();

		/*Random ran=new Random();
		int random = ran.nextInt(500);*/

		//step1: get common data from properties file

		String  Browser = fLib.readDataFromPropertFile("browser");
		String  URL = fLib.readDataFromPropertFile("url");
		String  USRNAME = fLib.readDataFromPropertFile("username");
		String  PWD = fLib.readDataFromPropertFile("password");



		/*FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
	Properties pOBj=new Properties();
	pOBj.load(fis);
	String URL = pOBj.getProperty("url");
	String UsrName = pOBj.getProperty("username");
	String pwd = pOBj.getProperty("password"); */


		//step2: get data from exel file

		String OrgName = eLib.readDataFromExel("contact", 1, 1)+random;
		String lastName= eLib.readDataFromExel("contact", 1, 0)+random;
		String leadSource = eLib.readDataFromExel("contact", 1, 2)+random;



		/*	FileInputStream fi=new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet("contact");
	String OrgName = sh.getRow(1).getCell(1).getStringCellValue()+random;
	String lastName = sh.getRow(1).getCell(0).getStringCellValue()+random;
	        String leadSource = sh.getRow(1).getCell(2).getStringCellValue();
		 */

		//step 3: launching the browser
		
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		/*WebDriver driver=new ChromeDriver();*/
		driver.get(URL);

		//----- to maximise window------------
		
		wLIb.maximizeWindow(driver);
		/*driver.manage().window().maximize();*/


		// wait for page load
		wLIb.waitForPageLaod(driver);
		/*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  */


		//step 4: login to the application

		driver.findElement(By.name("user_name")).sendKeys(USRNAME,Keys.TAB,PWD,Keys.ENTER);

		//click on org
		driver.findElement(By.linkText("Organizations")).click();
		//click on create org lookup
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//validation
		String actualdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualdata.contains(OrgName))
		{
			System.out.println("created org sucessful ");
		}
		else {
			System.out.println("org creatrd not sucess full");
		}

		// creating contact
		driver.findElement(By.linkText("Contacts")).click();
		//click on lookup
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		// select the existing organisation
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();

		String mainid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for(String id:allid) {
			String title = driver.switchTo().window(id).getTitle();
			String title1 = "Accounts&action";
			if(title.contains(title1));
			{
				driver.switchTo().window(id);
				System.out.println("hi");
				break;
			}
		}


		//search text
		Thread.sleep(3000);
		driver.findElement(By.id("search_txt")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("javascript:window.close();")).click();

		//select lead source
		
		WebElement source = driver.findElement(By.name("leadsource"));
		wLIb.select(source, leadSource);
		//Select s=new Select(source);
		//s.deselectByValue(leadSource);
		driver.findElement(By.name("button")).click();



		//logout 
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	
		wLIb.mousehover(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		WebElement signout = driver.findElement(By.linkText("Sign Out"));
		//Actions act=new Actions(driver);
		//act.moveToElement(signout).perform();
		signout.click();






	}
}

