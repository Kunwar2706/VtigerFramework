package Practice_package;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TestScript1 {

		// TODO Auto-generated method stub
		static {
			System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		}
		public static void main(String[] args) throws InterruptedException{
	
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://192.168.0.182:8888/");
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			 WebElement resourse = driver.findElement(By.linkText("More"));
			Actions a=new Actions(driver);
			
			a.moveToElement(resourse).perform();
			driver.findElement(By.linkText("Vendors")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
			driver.findElement(By.name("vendorname")).sendKeys("Amazon206",Keys.TAB,Keys.TAB,"amazon@gmail.com",Keys.TAB,"9019817929");
			driver.findElement(By.id("city")).sendKeys("bengaluru",Keys.TAB,"karnataka",Keys.TAB,"57006",Keys.TAB,"india");
			driver.findElement(By.name("description"));
			driver.findElement(By.name("button")).click();
			
			
	

	

}
}
