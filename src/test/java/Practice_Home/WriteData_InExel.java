package Practice_Home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteData_InExel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
	   wb.getSheet("Sheet2").getRow(0).getCell(1).setCellValue("pass");	
	   FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
	   wb.write(fos);
	 

	}
	
	
}
