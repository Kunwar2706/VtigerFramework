package Practice_Home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMUltipleData_exe {
	public static void mailn(String[]args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet("Sheet2");
		String[] st= {"amit","pradeep","vinit"};
		for(int i=0;i<sh.getLastRowNum();i++)
		{
			for(int j=0;j<st.length;j++) {
				sh.createRow(i).createCell(j).setCellValue(st[i]);
				
				FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
				wb.write(fos);
				System.out.println("done");
			

			}
			
		}
	
	

	}

}

