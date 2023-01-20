package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData_Exel {

	public static void main(String[] args) throws Throwable {
    FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
    Workbook wb=WorkbookFactory.create(fis);
   Sheet sh = wb.getSheet("OrganiZation");
   for(int i=0;i<=sh.getLastRowNum();i++)
   {
    Row row = sh.getRow(i);
    for(int j=0;j<row.getLastCellNum();j++)
    {
    	String value=row.getCell(j).getStringCellValue();
    	System.out.print(value+" ");
    }
    System.out.println();
    }
    
	}
   

}
