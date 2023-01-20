package Practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
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

public class InsertDtaINApiDataBase_verifyInApiServer {

	public static void main(String[] args) throws Throwable {

		Connection conn = null;
		int result=0;
		try {

			Driver driver=new Driver();
			//step1: get register to the data base
			DriverManager.registerDriver(driver);

			//step2: get connection to the database
			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%","root");

			//step 3: issue create statement

			Statement state = conn.createStatement();
			String query = "insert into project values('TY_project_210','ak'.21/12/2022','vtiger','created',4);";

			//step4: update query
			result = state.executeUpdate(query);
		}


		catch(Exception e) {

		}
		finally {
			if(result==1) {
				System.out.println("inserted sucessfully");
			}
			else {
				System.out.println("failed to insert");
			}

		}

		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeOptions opt= new ChromeOptions();
		WebDriver driver=new ChromeDriver(opt);
		driver.get("http:rmgtestingserver:8084");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputpassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		//click on project
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		/*
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
		*/
		WebElement pro = driver.findElement(By.xpath("/td[.='vtiger'"));
		String pp = pro.getText();
		if(pp.equals("vtiger")) {
			System.out.println("createsd");
		}
		else {
			System.out.println("not created");
		}
			
		









	}

}
