package Practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MakeMytrip {
	static {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	}

	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifictions");
WebDriver driver= new ChromeDriver(opt);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("https://www.makemytrip.com/");
driver.findElement(By.xpath("//li[@data-cy='account']")).click();
driver.findElement(By.xpath("//li[@data-cy='menu_Buses']/div/a")).click();
driver.findElement(By.xpath("//input[@placeholder='From']")).click();
driver.findElement(By.id("fromCity")).sendKeys("mumbai");

	}

}
