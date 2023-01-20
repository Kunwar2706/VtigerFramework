package Lead_module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.generic.libraries.ExelUtility;
import com.generic.libraries.FileUtility;
import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class Lead_edit_module {
	 static WebDriver driver=null;

	public static void main(String[] args) throws Throwable {

		//create object for generic class
		JavaUtility jLib=new JavaUtility();
		FileUtility flib= new FileUtility();
		ExelUtility  elib= new ExelUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		
	//get random no	
		
		int random = jLib.getRandomNo();
		/*Random ran=new Random();
	    ran.nextInt(500);*/
	//step1: get common data

		 String Browser = flib.readDataFromPropertFile("browser");
		 String URL = flib.readDataFromPropertFile("url");
		 String USERNAME = flib.readDataFromPropertFile("username");
		 String pass = flib.readDataFromPropertFile("password");
		 
	 /*FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties");
	Properties Pobj=new Properties();
	Pobj.load(fis);
	String URL = Pobj.getProperty("url");
	String USERNAME = Pobj.getProperty("username");
	String pass = Pobj.getProperty("password"); */
	
	
	//step 2: read the data from exel sheet
		 elib.readDataFromExel("Sh2", 0, 1);
		 
		 
	/*FileInputStream fi= new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet("Sh2");
	String leadINFO = sh.getRow(0).getCell(1).getStringCellValue()+ran;*/
	
	
	//step3: launching the browser
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
	//*WebDriver driver=new ChromeDriver();
	//give url 
	driver.get(URL);
	
	//maximixe the window
	wLib.maximizeWindow(driver);
	//driver.manage().window().maximize();
	
	//wait for page load
	wLib.waitForPageLaod(driver);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	//login with credentials
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(pass);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
	//select data from dropdown
	wLib.select(driver.findElement(By.name("salutationtype")),"Mr.");
	/* WebElement drop=driver.findElement(By.name("salutationtype"));
	 
	 Select s=new Select(drop);
	 s.selectByValue("Mr."); */
	 
	 // creating arraylist
	
	ArrayList<String> list = elib.getList("Sh2",0);
	int lastrow = elib.getLastRowNo("Sh2");
	 for(int i=0;i<=lastrow;i++)
	 {
		 String value = elib.readDataFromExel("Sh2", i, 1)+random;
		 driver.findElement(By.name(list.get(i))).sendKeys(value);
	 }
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 String actualvalue = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();  
	/* ArrayList<String> al=new ArrayList<String>();
	 al.add("firstname");
	 al.add("lastname");
	 al.add("company");
	 for(int i=0;i<=sh.getLastRowNum();i++)
			 {
		String value = sh.getRow(i).getCell(1).getStringCellValue()+ran;
		driver.findElement(By.name(al.get(i))).sendKeys(value);
			 }
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 driver.findElement(By.xpath("(//input[@title='Edit [Alt+E]'])[1]")).click();
	String actualvalue = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText(); */
	 String leadinfo = elib.readDataFromExel("Sh2", 0, 1)+random;
	if(actualvalue.contains(leadinfo))
	{
		  
			  System.out.println(" lead created");
		  }
		  else
		  {
			  System.out.println("lead not created");
			  
		  }
	//logout 
	  WebElement signout=  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	  wLib.mousehover(driver, signout);
		  driver.findElement(By.linkText("Sign Out")).click();
		  
		  // Actions act=new Actions(driver);
		  // act.moveToElement(signout).perform();
		  // signout.click();
		  
		 
		 
	}
	 
	 

	
 
	}


