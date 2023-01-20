package com.generic.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.generic.libraries.ExelUtility;
import com.generic.libraries.FileUtility;
import com.generic.libraries.JavaUtility;
import com.generic.libraries.WebDriverUtility;

public class CreateLead_System {
	static WebDriver driver = null;

	public static void main(String[] args) throws Throwable {

		// create object for generic class
		JavaUtility jLib = new JavaUtility();
		FileUtility flib = new FileUtility();
		ExelUtility elib = new ExelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		// get the random no
		int random = jLib.getRandomNo();

		// read the data from poperty file
		String Browser = flib.readDataFromPropertFile("browser");
		String URL = flib.readDataFromPropertFile("url");
		String USERNAME = flib.readDataFromPropertFile("password");
		String pwd = flib.readDataFromPropertFile("password");
		// read the data from excel
		String lastName = elib.readDataFromExel("leads", 1, 0);
		String company = elib.readDataFromExel("leads", 1, 1);
		String phone = elib.readDataFromExel("leads", 1, 2);
		String mobileNO = elib.readDataFromExel("leads", 1, 3);
		// launching the browser

		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}

		// give the url
		driver.get(URL);
		// maximize the window
		wLib.maximizeWindow(driver);
		// wait for page load
		wLib.waitForPageLaod(driver);

		// step 4: login credential
		driver.findElement(By.name("user_name")).sendKeys(USERNAME, Keys.TAB, pwd, Keys.ENTER);
		// click on lead module
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		// select dropdown
		WebElement drop = driver.findElement(By.name("salutationtype"));
		wLib.select(drop, "Mr.");

	/*for (int i = 0; i < elib.getLastCellNo("leads", 0); i++) {
			String key = elib.readDataFromExel("leads", 0, i);
			String value = elib.readDataFromExel("leads", 1, i);
			driver.findElement(By.name(key)).sendKeys(value); */
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
                wLib.select(drpdown, "lastname");
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
        		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        		 wLib.mousehover(driver, signout);
        		driver.findElement(By.linkText("Sign Out")).click();
     		   
	}
}
