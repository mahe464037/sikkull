import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class WriteExcel {
	
	
	public void celldata(String file,String sheetnm,int rowno,int colno,String dataval) throws IOException
	{
		FileInputStream fis1=new FileInputStream(file);
		XSSFWorkbook wb1=new XSSFWorkbook(fis1);
		XSSFSheet sheet= wb1.getSheet(sheetnm);
		XSSFRow row=sheet.createRow(rowno);
		XSSFCell cell=row.createCell(colno);
		     cell.setCellValue(dataval);
		     
		FileOutputStream fileout=new FileOutputStream(file);
		wb1.write(fileout);
		
		
	}

}
