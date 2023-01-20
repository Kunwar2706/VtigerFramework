package Oppurtunities_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOpportunities_With_Org_CampaignSystemtesting {

	public static void main(String[] args) throws Throwable {
//step1:get common data from property file
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties pOBj=new Properties();
		pOBj.load(fis);
		String URL = pOBj.getProperty("url");
		String UsrName = pOBj.getProperty("username");
		String pwd = pOBj.getProperty("password");
		
		//step2: get data from exel sheet
		FileInputStream fi=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fi);
		String OppInfo = wb.getSheet("Opportunities").getRow(0).getCell(0).getStringCellValue();
		
		
		
		//step3:launching the browser
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

}
