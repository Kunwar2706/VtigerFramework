package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData_ExelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		//step 2. 
		Workbook wb = WorkbookFactory.create(fis);
		//step3:
	 String cell = wb.getSheet("OrganiZation").getRow(1).getCell(0).getStringCellValue();
	 System.out.println(cell);

	}

}
