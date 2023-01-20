package com.generic.TestCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.generic.libraries.ExelUtility;
import com.generic.libraries.FileUtility;
import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class CreateOrg_text {
	static WebDriver driver=null;
	public static void main(String[] args) throws Throwable {

		//create object for generic class
		JavaUtility jLib=new JavaUtility();
		FileUtility flib= new FileUtility();
		ExelUtility  elib= new ExelUtility();
		WebDriverUtility wLib= new WebDriverUtility();


		/*get random data*/
		int random = jLib.getRandomNo();

		/*Random ran= new Random();
		int random = ran.nextInt(500);*/

		//step1: get common data
		String Browser = flib.readDataFromPropertFile("browser");
		String URL = flib.readDataFromPropertFile("url");
		String UsrName = flib.readDataFromPropertFile("username");
		String pwd = flib.readDataFromPropertFile("password");



		// staep 2: read the data from exel sheet

		//String orgName = elib.readDataFromExel("OrganiZation", 0, 1);




		// launching chrome

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

		// to maximaxize the window


		wLib.maximizeWindow(driver);

		driver.get(URL);

		// wait for page load


		wLib.waitForPageLaod(driver);

		// login to application

		driver.findElement(By.name("user_name")).sendKeys(UsrName);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();

		// creating organisation
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		ArrayList<String> list = elib.getList("OrganiZation",0);
		int lastrow = elib.getLastRowNo("OrganiZation");
		for(int i=0;i<=lastrow;i++)
		{
			String value = elib.readDataFromExel("OrganiZation", i, 1)+random;
			driver.findElement(By.name(list.get(i))).sendKeys(value);
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actualdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String orginfo = elib.readDataFromExel("OrganiZation", 0, 1)+random;
		if(actualdata.contains(orginfo))
		{
			System.out.println(orginfo+" Organisation created");
		}
		else
		{
			System.out.println("not created");
		}
		//logout 

		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mousehover(driver, signout);
		driver.findElement(By.linkText("Sign Out")).click();


	}

}
