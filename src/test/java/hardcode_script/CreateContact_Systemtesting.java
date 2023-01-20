package hardcode_script;

import java.io.FileInputStream;
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
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContact_Systemtesting {
	public static void main(String[] args) throws Throwable {
		Random ran=new Random();
		int random = ran.nextInt(500);
		//step1: get common data from properties file

		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties pOBj=new Properties();
		pOBj.load(fis);
		String URL = pOBj.getProperty("url");
		String UsrName = pOBj.getProperty("username");
		String pwd = pOBj.getProperty("password");


		//step2: get data from exel file
		FileInputStream fi=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("contact");
		String OrgName = sh.getRow(1).getCell(1).getStringCellValue()+random;
		String lastName = sh.getRow(1).getCell(0).getStringCellValue()+random;
		String leadSource = sh.getRow(1).getCell(2).getStringCellValue();

		//step 3: launching the browser
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//step 4: login to the application

		driver.findElement(By.name("user_name")).sendKeys(UsrName,Keys.TAB,pwd,Keys.ENTER);

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

		//String mainid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for(String id:allid) {
			String title = driver.switchTo().window(id).getTitle();
			String title1 = "Accounts&action";
			if(title.contains(title1));
			{
				// driver.switchTo().window(id);
				System.out.println("hi");
				break;
			}

		}
	}
}

