package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class AddingDataInrmg_Verfyindatabase {

	
	static {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException, SQLException{
		ChromeOptions opt= new ChromeOptions();
		WebDriver driver=new ChromeDriver(opt);
		driver.get("http:rmgtestingserver:8084");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputpassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		//click on project
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		//click on create project
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		//project name
		driver.findElement(By.name("projectname")).sendKeys("vtiger");
		//project manager
		driver.findElement(By.name("createdBy")).sendKeys("deepak");
		//project status 
		WebElement status = driver.findElement(By.name("status"));
		Select s=new Select(status);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		
	Connection con=null;
	try {
		
	Driver driver1 =new Driver();
	//step1: register the database
	
	DriverManager.registerDriver(driver1);
	
	//step2: get connection for  the database
	con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%","root");
	//step3: issue create statement	
	Statement state = con.createStatement();
	String query = "select * from project where project_name='vtiger';";
	
	//step4: execute query
	ResultSet result = state.executeQuery(query);	
	while(result.next())
			
	{
		if(result.getString(4).equals("vtiger")) {
			System.out.println("project created");
		}
		else {
			System.out.println("project not created");
			
		}
			
		
	}
	}

		
	catch(Exception e) {
		
	}
	finally {		
		//step5: close the database
	}
		con.close();
		System.out.println("close the data base");
		
				

	}

}
