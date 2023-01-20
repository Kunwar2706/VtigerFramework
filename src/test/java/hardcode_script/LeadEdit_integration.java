package hardcode_script;

import java.io.FileInputStream;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LeadEdit_integration {


	public static void main(String[] args) throws Throwable {
	Random ran=new Random();
	int randomNum = ran.nextInt(500);
	//step1: get common data
	FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties");
	Properties Pobj=new Properties();
	Pobj.load(fis);
	String URL = Pobj.getProperty("url");
	String USERNAME = Pobj.getProperty("username");
	String pass = Pobj.getProperty("password");
	
	
	//step 2: read the data from exel sheet
	
	FileInputStream fi= new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet("Sh2");
	String leadINFO = sh.getRow(0).getCell(1).getStringCellValue();
	
	
	//step3: launching the browser
	WebDriver driver=new ChromeDriver();
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//login with credentials
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(pass);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
	 WebElement drop=driver.findElement(By.name("salutationtype"));
	 Select s=new Select(drop);
	 s.selectByValue("Mr.");
	 
	 // creating arraylist
	 ArrayList<String> al=new ArrayList<String>();
	 al.add("firstname");
	 al.add("lastname");
	 al.add("company");
	 for(int i=0;i<=sh.getLastRowNum();i++)
			 {
		String value = sh.getRow(i).getCell(1).getStringCellValue()+randomNum;
		driver.findElement(By.name(al.get(i))).sendKeys(value);
			 }
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 driver.findElement(By.xpath("(//input[@title='Edit [Alt+E]'])[1]")).click();
	String actualvalue = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	if(actualvalue.contains(leadINFO))
	{
		  
			  System.out.println(" lead created");
		  }
		  else
		  {
			  System.out.println("lead not created");
			  
		  }
	//logout 
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		   WebElement signout = driver.findElement(By.linkText("Sign Out"));
		   Actions act=new Actions(driver);
		   act.moveToElement(signout).perform();
		   signout.click();
		  
		 
		 
	}
}
