package Practice_Home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData_Exel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("OrganiZation");
		int count = sh.getLastRowNum();
		int count1 =sh.getRow(count).getLastCellNum();
		for(int i=0;i<=count;i++){
			for(int j=0;j<count1;j++) {
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+"");
			}
			System.out.println();



		}


	}
}

