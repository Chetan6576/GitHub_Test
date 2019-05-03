package com.carwell.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ReadWriteExcel implements Constants {
	public static  HSSFWorkbook workbook;
	public static  HSSFSheet sheet;
	public static HSSFRow rows;
	
//to write the data into excel sheet
	public static void writeData(String path,String sheetname,int rowNum,int columnNum,String value ) 
	 {
		try {
		FileInputStream file = new FileInputStream(new File(XL_PATH));
		workbook = new HSSFWorkbook(file);
		sheet = workbook.getSheet(sheetname);
		sheet.getRow(rowNum).createCell(columnNum).setCellValue(value);
		 FileOutputStream fileout;
		
			fileout = new FileOutputStream(path);
			workbook.write(fileout);
			workbook.close();
		} catch ( IOException e) {
			
			e.printStackTrace();
		}	 
				
	 }

//to read the data into excel sheet
	public static  String readData(String path,String sheetname,int rowNum,int columnNum) 
	{
		String data="";
		FileInputStream file;
		try {
			file = new FileInputStream(path);
			workbook = new HSSFWorkbook(file);
			  sheet = workbook.getSheet(sheetname);
			  DataFormatter formatter = new DataFormatter();
			formatter.formatCellValue(sheet.getRow(rowNum).getCell(columnNum)); //getStringCellValue());
			data=sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
			workbook.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//workbook.close();
		return data;

	}
	
	
	public static int getRowCount(String sheetname) 
	{
		int rowcount =0;
		FileInputStream file;
		try {
			file = new FileInputStream(XL_PATH);
			workbook = new HSSFWorkbook(file);
			sheet = workbook.getSheet(sheetname);
			rowcount=sheet.getLastRowNum();
		} catch ( IOException e) {
			
			e.printStackTrace();
		}
		  
		 
		  return rowcount;
	}
	
}