package hardcode_script;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreatingLeads_system_tc_1 {

	public static void main(String[] args) throws Throwable {
	Random ran= new Random();
	int random = ran.nextInt(500);
	//step1: get common data from property data
	FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
	Properties PObj=new Properties();
	PObj.load(fis);

	String URL = PObj.getProperty("url");
	String Username = PObj.getProperty("username");
	String pwd = PObj.getProperty("password");


	//step2: get common data from excel sheet
	FileInputStream fi=new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fi);
	String lastName = wb.getSheet("leads").getRow(1).getCell(0).getStringCellValue()+random;
	String company = wb.getSheet("leads").getRow(1).getCell(1).getStringCellValue()+random;
	String phone = wb.getSheet("leads").getRow(1).getCell(2).getStringCellValue()+random;
	String mobileNO = wb.getSheet("leads").getRow(1).getCell(3).getStringCellValue()+random;



	//step3: launching the browser

	WebDriver driver=new ChromeDriver();
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);


	//step 4: login credential
	driver.findElement(By.name("user_name")).sendKeys(Username,Keys.TAB,pwd,Keys.ENTER);
	// click on lead module
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
	WebElement drop=driver.findElement(By.name("salutationtype"));
	Select s=new Select(drop);
	s.selectByValue("Mr.");
	driver.findElement(By.name("lastname")).sendKeys(lastName);
	driver.findElement(By.name("company")).sendKeys(company);
	driver.findElement(By.name("phone")).sendKeys(phone);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	//click on edit button
	driver.findElement(By.name("Edit")).click();
	driver.findElement(By.name("mobile")).sendKeys(mobileNO);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//once again click on lead module
	driver.findElement(By.linkText("Leads")).click();
	//handle the dropdown to select last name
	WebElement drpdown=driver.findElement(By.name("search_field"));
	Select s1=new Select(drpdown);
	s1.selectByValue("lastname");
	//search testfield
	driver.findElement(By.name("search_text")).sendKeys(lastName);
	driver.findElement(By.name("submit")).click();
Thread.sleep(2000);
	//validation
	String actualData = driver.findElement(By.linkText(lastName)).getText();
	if(actualData.equals(lastName))
	{
		System.out.println("update sucessfull");
	}
	else {
		System.out.println("not updated");
	}

	//logout
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	WebElement signout = driver.findElement(By.linkText("Sign Out"));
	Actions act=new Actions(driver);
	act.moveToElement(signout).perform();
	signout.click();

}
}
