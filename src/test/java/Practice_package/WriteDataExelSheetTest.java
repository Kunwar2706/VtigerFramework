package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataExelSheetTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh=wb.getSheet("OrganiZation");
		 sh.createRow(2).createCell(0).setCellValue("sanjay");
		 FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
		 wb.write(fos);
	}

}
