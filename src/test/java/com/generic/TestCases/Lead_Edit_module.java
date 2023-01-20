package com.generic.TestCases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

public class Lead_Edit_module {
	 static WebDriver driver=null;

		public static void main(String[] args) throws Throwable {

			//create object for generic class
			JavaUtility jLib=new JavaUtility();
			FileUtility flib= new FileUtility();
			ExelUtility  elib= new ExelUtility();
			WebDriverUtility wLib= new WebDriverUtility();
			
			//get random no	
				
				int random = jLib.getRandomNo();
				
			//step1: get common data

				 String Browser = flib.readDataFromPropertFile("browser");
				 String URL = flib.readDataFromPropertFile("url");
				 String USERNAME = flib.readDataFromPropertFile("username");
				 String pass = flib.readDataFromPropertFile("password");
				 
			
			
			//step 2: read the data from excel sheet
				 elib.readDataFromExel("Sh2", 0, 1);
				 
				 
			
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
		
			driver.get(URL);
			
			//Maximize the window
			wLib.maximizeWindow(driver);
			
			
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
				  
		
				  
				 
				 
			}
			 
			 

			
}
