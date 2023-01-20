package hardcode_script;

import java.io.FileInputStream;
import java.io.IOException;
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

public class CreateOrganisationModule_integration {

	public static void main(String[] args) throws IOException {
		Random ran= new Random();
		int random = ran.nextInt(500);
		
		//step1: get common data
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties objP=new Properties();
		objP.load(fis);
		String URL = objP.getProperty("url");
		String UsrName = objP.getProperty("username");
		String pwd = objP.getProperty("password");
	
		
		// staep 2: read the data from exel sheet	
		FileInputStream  fi =new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("OrganiZation");
		
		 String orgName = sh.getRow(0).getCell(1).getStringCellValue()+random;
		 
		     
		 
		 
		 WebDriver driver =new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(URL);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 // login to appliction
		 driver.findElement(By.name("user_name")).sendKeys(UsrName);
		 driver.findElement(By.name("user_password")).sendKeys(pwd);
		 driver.findElement(By.id("submitButton")).click();
		 
		 // creating organisation
		 driver.findElement(By.linkText("Organizations")).click();
		 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 ArrayList<String> list =new ArrayList<String>() ;
		 list.add("accountname");
		 list.add("website");
		 list.add("tickersymbol");
		 list.add("phone");
		 for(int i=0;i<sh.getLastRowNum();i++)
		 {
			 String value = sh.getRow(i).getCell(1).getStringCellValue()+ran;
			 driver.findElement(By.name(list.get(i))).sendKeys(value);
			 
		 }
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  String actualdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  if(actualdata.contains(orgName))
		  {
			  System.out.println(orgName+" Organisation created");
		  }
		  else
		  {
			  System.out.println("Organistion not created");
		  }
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		   WebElement signout = driver.findElement(By.linkText("Sign Out"));
		   Actions act=new Actions(driver);
		   act.moveToElement(signout).perform();
		   signout.click();
		  
		 
		 
		 
		 



		

	}

}



