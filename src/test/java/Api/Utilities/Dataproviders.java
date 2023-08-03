package Api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	String path="./src/test/java/Api/Testdata/RestAssured-TestData.xlsx";
	
	String sheetname="userdata";
	
	@DataProvider(name="data")
	public String[][] getalldata() throws IOException
	{
		
		Xls_Reader xl=new Xls_Reader(path);
		 int rownum=xl.getRowCount(sheetname);
		 int colcount=xl.getCellCount(sheetname,1);
		 
		 
		 String apidata[][]=new String[rownum][colcount];
		 for(int i=1;i<=rownum;i++)
		 {
			 
			 for(int j=0;j<colcount;j++)
			 {
				 apidata[i-1][j]=xl.getCellData(sheetname,i,j);
				 
			 }
		 }
		
		return apidata;
		
	}
	
	@DataProvider(name="username")
	public String[] getusername() throws IOException
	{		
		Xls_Reader xl=new Xls_Reader(path);
		 int rownum=xl.getRowCount(sheetname);
		
		 
		 String apidata[]=new String[rownum];
		 for(int i=1;i<=rownum;i++)
		 {
			 apidata[i-1]=xl.getCellData(sheetname, i, 1);
		 }
		
		return apidata;
		
	}

	
	
	
	

}
