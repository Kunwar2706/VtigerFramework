package com.generic.libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this method is used to read data from excel
 * @author Me
 *
 */
public class ExelUtility extends JavaUtility{
	public String readDataFromExel(String SheetName,int RowNO,int ColumnNo) throws Throwable {
		FileInputStream fi=new FileInputStream(IpathConstants.ExelPath);
		Workbook wb=WorkbookFactory.create(fi);
		String value=wb.getSheet(SheetName).getRow(RowNO).getCell(ColumnNo).getStringCellValue();
		return value;

	}
/**
 * 
 * @param SheetName
 * @param RowName
 * @param ColumnName
 * @param Data
 * @throws Throwable
 */

	public void writeDataIntoExel( String SheetName,int RowName,int ColumnName,String Data) throws Throwable {
		FileInputStream fi=new FileInputStream(IpathConstants.ExelPath);
		Workbook wb=WorkbookFactory.create(fi);
		wb.createSheet(SheetName).createRow(RowName).createCell(ColumnName).setCellValue(Data);
		FileOutputStream fos=new FileOutputStream(IpathConstants.ExelPath);
		wb.write(fos);
	}
/** this method is used write data into  excel
 * this method is used to get the last value
 * @param Sheetnae
 * @return
 */
	public int getLastRowNo(String SheetName )throws Throwable{
		FileInputStream fi=new FileInputStream(IpathConstants.ExelPath);
		Workbook wb=WorkbookFactory.create(fi);
		int count = wb.getSheet(SheetName).getLastRowNum();
		return count;
		

	}
	public int getLastCellNo(String SheetName,int row )throws Throwable{
		FileInputStream fi=new FileInputStream(IpathConstants.ExelPath);
		Workbook wb=WorkbookFactory.create(fi);
		int count = wb.getSheet(SheetName).getRow(row).getLastCellNum();
		return count;
		

	}
	public Map<String , String> getlist( String SheetName,int keyCell,int valueCell) throws Throwable{
		FileInputStream fi=new FileInputStream(IpathConstants.ExelPath);
		Workbook wb=WorkbookFactory.create(fi);

		org.apache.poi.ss.usermodel.Sheet sh= wb.getSheet(SheetName);
		int count = sh.getLastRowNum();

		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<=count;i++) {
			String key=sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value=sh.getRow(i).getCell(valueCell).getStringCellValue();
			map.put(key, value);
		}
	
	
		return map;

	}
	public ArrayList<String> getList(String SheetName,int cellNo) throws Throwable{
		FileInputStream fis=new FileInputStream(IpathConstants.ExelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastrow = sh.getLastRowNum();
		ArrayList<String> al=new ArrayList<String>();
		for(int i=0;i<=lastrow;i++) {
			String value =sh.getRow(i).getCell(cellNo).getStringCellValue();
			al.add(value);
		}
		return al;
}

	
}
