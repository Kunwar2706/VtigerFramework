package hardcode_script;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Create_org_recylebin_integrationTc04 {

	public static void main(String[] args) throws Throwable, Throwable {
		Random ran= new Random();
		int random = ran.nextInt(500);
		//step1: get common data from property data
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties PObj=new Properties();
		PObj.load(fis);
		
		String URL = PObj.getProperty("url");
		String Username = PObj.getProperty("username");
		String pwd = PObj.getProperty("password");
		
		
		//step2: get common data from exel sheet
		FileInputStream fi=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		String OrgName = wb.getSheet("recyclebin").getRow(1).getCell(0).getStringCellValue()+random;
		String mail = wb.getSheet("recyclebin").getRow(1).getCell(1).getStringCellValue()+random;
		String phone = wb.getSheet("recyclebin").getRow(1).getCell(2).getStringCellValue()+random;
		
		
		//step3: launching the browser
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		
		//step 4: login credential
		driver.findElement(By.name("user_name")).sendKeys(Username,Keys.TAB,pwd,Keys.ENTER);
		
		//creating org--
		driver.findElement(By.linkText("Organizations")).click();
		//click on  creating popup
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.name("email1")).sendKeys(mail);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// delte org
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//handle mousehover
		WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(more).perform();
		driver.findElement(By.linkText("Recycle Bin")).click();
		//serch field
		driver.findElement(By.name("search_text")).sendKeys(OrgName);
		WebElement drop = driver.findElement(By.id("bas_searchfield"));
		Select s=new Select(drop);
		s.selectByValue("accountname");
	    driver.findElement(By.name("submit")).click();
	    //validation
	    Thread.sleep(3000);
	    String actual = driver.findElement(By.linkText(OrgName)).getText();
	    
	    if(OrgName.equals(actual)) {
	    	System.out.println("testcase passed");
	    }
	    else {
	    	System.out.println("testcase failed");
	    }
	  	    driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		   WebElement signout = driver.findElement(By.linkText("Sign Out"));
		   Actions act=new Actions(driver);
		   act.moveToElement(signout).perform();
		   signout.click();  //logout



}

}
