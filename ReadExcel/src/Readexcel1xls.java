import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;


public class Readexcel1xls {
	
	public void rexcel(String file,String sheetname) throws IOException
	{
		FileInputStream fis= new FileInputStream(file);
		HSSFWorkbook wb= new HSSFWorkbook(fis);
		HSSFSheet sheet=wb.getSheet(sheetname);
		HSSFRow row=sheet.getRow(4);
		HSSFCell cell=row.getCell(1);
		HSSFRow row1=sheet.getRow(3);
		HSSFCell cell1=row.getCell(1);
        String val2=cell1.getStringCellValue();
        System.out.println(val2);
		String val=cell.getStringCellValue();
		System.out.println(val);;
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
				//System.out.println(sheet.getRow(i).getCell(j));		
				DataFormatter dataformat=new DataFormatter();
				System.out.println(dataformat.formatCellValue(sheet.getRow(i).getCell(j))+"\t\t");
			
			}
		}
				
		
	}

	public static void main(String[] args) throws IOException {
		Readexcel1xls re=new Readexcel1xls();
		re.rexcel("C:\\Users\\mahendra\\Desktop\\studentdetails1.xls", "Sheet1");
		

	}

}
