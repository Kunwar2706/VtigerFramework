package hardcode_script;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreatevendorWith_product_integration_tc08 {
	public static void main(String[] args) throws Throwable {
		Random ran=new Random();
		int random = ran.nextInt(500);
		//step1: get common data
		FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String UsrName = p.getProperty("username");
		String pass = p.getProperty("password");


		//step 2: read the data from exel file
		FileInputStream fi= new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		String vendorName = wb.getSheet("vendor").getRow(1).getCell(0).getStringCellValue()+random;
		String ProductName = wb.getSheet("vendor").getRow(0).getCell(0).getStringCellValue()+random;
	
		//step3:launchiing the browser 

		WebDriver driver= new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//fill logincrendential

		driver.findElement(By.name("user_name")).sendKeys(UsrName);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();

		WebElement resourse = driver.findElement(By.linkText("More"));
		Actions a=new Actions(driver);
		a.moveToElement(resourse).perform();
		driver.findElement(By.linkText("Vendors")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();

		//vendor name filled
		driver.findElement(By.name("vendorname")).sendKeys(vendorName);
		//save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();

		// click product module
		driver.findElement(By.linkText("Products")).click();

		// click on create product lookup
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(ProductName);

		//select the existing vendor name
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();

		//child window handale
		String mainId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for( String id:allId) {
			String title = driver.switchTo().window(id).getTitle();
			String title1 = "Products&action";
			if(title.contains(title1)){
				
				break;
			}

		}
		//search contact
		driver.findElement(By.name("search_text")).sendKeys(vendorName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(vendorName)).click();


		driver.switchTo().window(mainId);

		//logout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		WebElement signout = driver.findElement(By.linkText("Sign Out"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		signout.click();




	}
}
