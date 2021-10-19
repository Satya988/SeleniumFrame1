package utils;

import java.io.IOException;

import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelUtildata {
	static ExcelUtils excel;
	static String path;
	static String Shname;
	
	@Test(dataProvider="test1data")
	public static void test1(String username,String password)
	{
		System.out.println(username+"	|	"+password);
	}
	
	@DataProvider(name="test1data")
	public static Object[][] getData() throws IOException {
		// TODO Auto-generated method stub
		path="C:\\Users\\shrik\\eclipse-workspace\\SeleniumFramework\\excel\\data.xlsx";
		Shname="Sheet1";
		Object data[][]=testdata(path,Shname);
		return data;

	}
	public static Object[][] testdata(String path,String Shname) throws IOException {
		// TODO Auto-generated method stub
		
		excel=new ExcelUtils(path,Shname);
		
		int k=excel.RowCount();
		int l=excel.ColCount();
		Object data[][]=new Object[k-1][l];
		//excel.StringData(1,0);
		//excel.NumberData(1, 1);
		//excel.AllData(a,b);
		
		
						
						
						for(int i=1;i<k;i++)
						{
							for(int j=0;j<l;j++)
							{
								String CellData=excel.StringData(i,j);
									
								//System.out.print(CellData+"		|	 ");
								data[i-1][j]=CellData;
							}
							System.out.println();
						}
						return data;
						
					}

				
				
			
			
		

	}


