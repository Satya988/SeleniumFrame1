package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	public ExcelUtils(String propath,String sheetname) throws IOException
	{
		workbook=new XSSFWorkbook(propath);
		sheet=workbook.getSheet(sheetname);
		
	}
	public static int RowCount() {
		// TODO Auto-generated method stub
		int Rcount=sheet.getPhysicalNumberOfRows(); 
		return Rcount;
		 

	}
	
	public static int ColCount() {
		// TODO Auto-generated method stub
		
		int Ccount=sheet.getRow(0).getPhysicalNumberOfCells(); 
		return Ccount;

	}
	
	public static void NumberData(int i,int j) {
		// TODO Auto-generated method stub
		System.out.println(sheet.getRow(i).getCell(j).getNumericCellValue()); 

	}
	
	public static String StringData(int i,int j) {
		// TODO Auto-generated method stub
		String CellData=sheet.getRow(i).getCell(j).getStringCellValue(); 
		return CellData;

	}
	



}
