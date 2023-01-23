package Practice_Home;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Spicejet_round_trip {

	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		String fromcity="del";
		WebElement from = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		from.sendKeys(fromcity);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("BOM");
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-January-2023']//div[text()='28']"));


	}
}
