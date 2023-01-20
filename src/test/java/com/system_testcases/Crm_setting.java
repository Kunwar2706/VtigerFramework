package com.system_testcases;

import java.awt.Window;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Crm_setting {

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
		//handling mouse hover
		WebElement resource = driver.findElement(By.xpath("//img[@src='themes/softed/images/mainSettings.PNG']"));
	Actions a=new Actions(driver);
	a.moveToElement(resource).perform();
	driver.findElement(By.linkText("CRM Settings")).click();
	//handling dropdown
	JavascriptExecutor j= (JavascriptExecutor)driver;
	WebElement workflow = driver.findElement(By.linkText("Workflows"));
	j.executeScript("arguments[0].scrollIntoView();", workflow);
	workflow.click();
	//click on new workflow
	driver.findElement(By.id("new_workflow")).click();
	String mainId = driver.getWindowHandle();
	Set<String> allId = driver.getWindowHandles();
	for( String id:allId) {
	String title = driver.switchTo().window(id).getTitle();
	String title1 = "Create workflow";
	if(title.contains(title1)) {
		break;
	}
		
	}
				
		
	}

}
