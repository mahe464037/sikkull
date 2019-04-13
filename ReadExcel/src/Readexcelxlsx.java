import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexcelxlsx {
	
	public void rexcel(String file,String sheetname) throws IOException
	{ 
		int rownum=0;
		int colnum=0;
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheetname);
		XSSFRow row=sheet.getRow(3);
		XSSFCell cell=row.getCell(2);
		String val=cell.getStringCellValue();
		System.out.println(val);
		//Rows
		int rows=sheet.getLastRowNum();
		System.out.println(rows);
		int rowcount=rows+1;
		System.out.println("The number of rows: "+rowcount);
		//column
		int columns=sheet.getRow(rows).getLastCellNum();
		System.out.println("The number of column: "+columns);
		int arrayexceldata[][]=new int[rowcount][columns];
		for(int i=0;i<rowcount;i++)
		{
			
			for(int j=0;j<columns;j++)
			{
				
				 
			
				DataFormatter dataformat=new DataFormatter();
		      String dataval=	dataformat.formatCellValue(sheet.getRow(i).getCell(j));
		     System.out.println(dataval);
			    WriteExcel ob=new WriteExcel();
			    ob.celldata("D:\\EclipseWorkSpace\\ReadExcel\\studentdata.xlsx", "Sheet1", rownum++, colnum, dataval);
			}
		}
				
		
	}

	public static void main(String[] args) throws IOException {
		Readexcelxlsx re=new Readexcelxlsx();
		re.rexcel("C:\\Users\\mahendra\\Desktop\\studentdetails.xlsx","Sheet1");
		

	}

}
