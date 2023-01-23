package Practice_Home;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnewayGoIbibo {
	public static void main (String[]arg) throws InterruptedException {
		System.setProperty("webdrive.chromedriver.driver","./driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[text()='Round-trip']")).click();
		driver.findElement(By.xpath("//p[.='Enter city or airport']/../../div/p")).click();
		//String fromcity="del";
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("del");

		driver.findElement(By.xpath("//span[contains(text(),'New Delhi, India')]")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("bom");
		driver.findElement(By.xpath("//span[contains(text(),'Mumbai, India')]")).click();

		//driver.findElement(By.xpath("//div[@aria-label='Sat Jan 28 2023']")).click();
		//driver.findElement(By.xpath("//span[.='Done']")).click();


		Date d=new Date();
		System.out.println(d);
		String[] d1= d.toString().split(" ");
		String day = d1[0];
		String mon = d1[1];
		String cdate = d1[2];
		String year = d1[5];
		String travelDate1 =day+" "+mon+" "+cdate+" "+year;
		System.out.println(travelDate1);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@aria-label='"+travelDate1+"']")).click();
		driver.findElement(By.xpath("(//p[contains(text(),'return flight')])[1]")).click();


		//driver.findElement(By.xpath("//span[.='Return']")).click();


		String rday1 ="Wed";
		String rmon = "Feb";
		String rdate = "8";
		String ryear = "2023";		
		String returnday = rday1+" "+rmon+" "+rdate+" "+ryear;
		for(;;) {

			try {
				driver.findElement(By.xpath("//div[@aria-label='"+returnday+"']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}


			driver.findElement(By.xpath("//span[.='Done']")).click();





		}}
}
