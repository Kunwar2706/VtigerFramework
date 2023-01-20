package com.generic.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.generic.libraries.ExelUtility;
import com.generic.libraries.FileUtility;
import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class CreatingVndorWithProduct_Integration {
	 static WebDriver driver=null;
	public static void main(String[] args) throws Throwable {

		//create object for generic class
		JavaUtility jLib=new JavaUtility();
		FileUtility flib= new FileUtility();
		ExelUtility  elib= new ExelUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		//get random no
		int random = jLib.getRandomNo();
		
		//read common data from propert file
		
		 String Browser = flib.readDataFromPropertFile("browser");
		 String URL = flib.readDataFromPropertFile("url");
		 String USERNAME = flib.readDataFromPropertFile("username");
		 String PWD = flib.readDataFromPropertFile("password");
		 //READ DATA FROM EXEL FILE
		 
		 String vendorName = elib.readDataFromExel("vendor", 1, 0);
		 String ProductName = elib.readDataFromExel("vendor", 0, 0);

			//step3:launchiing the browser 
if(Browser.equals("chrome")) {
driver=new ChromeDriver();

}
else if(Browser.equals("firefox")) {
	driver=new ChromeDriver();
	
}
else {
	System.out.println("invalid browser");
}
// give the url
driver.get(URL);
//maximise the window
wLib.maximizeWindow(driver);

// wait for the page loading
wLib.waitForPageLaod(driver);

//fill logincrendential

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();

		WebElement more = driver.findElement(By.linkText("More"));
		wLib.mousehover(driver, more);
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
      wLib.switchToWindow(driver, "Vendors&action");
  	//search contact
		driver.findElement(By.name("search_text")).sendKeys(vendorName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(vendorName)).click();

		wLib.switchToWindow(driver, "Products&action");

		//logout 
		//logout
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wLib.mousehover(driver, signout);
		 driver.findElement(By.linkText("Sign Out")).click();
		 
		
		 
		 
	}

}
