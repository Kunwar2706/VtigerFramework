package Practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleData_exel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		FileInputStream fis= new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("OrganiZation");
		String[] st= {"monu","sonu","pratap"};
		for(int i =0;i<sh.getLastRowNum();i++) {
			for(int j=0;j<st.length;j++) {
				sh.createRow(i).createCell(j).setCellValue(st[i]);
			}
		}
		FileOutputStream fos =new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		System.out.println("done");
	}

}
