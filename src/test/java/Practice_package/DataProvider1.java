package Practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	@Test(dataProvider ="data")
public void travel(String src,String dst,int price ) {
	System.out.println("from "+src+"--->"+"to "+dst+price);
}



@DataProvider
public  Object[][] data(){
	

Object [][] objarr=new Object[3][3];
objarr[0][0]="banglore";
objarr[0][1]="mysore";
objarr[0][2]=100;

objarr[1][0]="mysore";
objarr[1][1]="banglore";
objarr[1][2]=200;

objarr[2][0]="patna";
objarr[2][1]="bth";
objarr[2][2]=300;
return objarr;
}
}
