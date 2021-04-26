import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public dataDriven() {
		// TODO Auto-generated constructor stub
	}
	//scanning first row
//scanning first row
//scanning first row
	//then scan complete column with name
	public static ArrayList<String> getdata(String testcases) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("G:\\myone.xlsx");
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		ArrayList<String> ab=new ArrayList<String>();
		System.out.println("hello");
System.out.println("hello");
System.out.println("hello");
System.out.println("hello");
System.out.println("hello");
System.out.println("hello");
System.out.println("hello");
System.out.println("hello");
System.out.println("hello");

System.out.println("hello");
System.out.println("hello");
System.out.println("hello");
System.out.println("hello");
		int a=wb.getNumberOfSheets();
		for(int i=0;i<a;i++)
		{
			if(wb.getSheetName(i).equals("Sheet1"))
			{
				XSSFSheet sheet= wb.getSheetAt(i);
				//scanning first row
				
				Iterator<Row> rows= sheet.iterator();
				Row firstrow= rows.next();
				Iterator<Cell> ce= firstrow.cellIterator();
				int k=0;
				int column=-1;
				while(ce.hasNext())
				{
					Cell c= ce.next();
					String scv=c.getStringCellValue().toString();
					if(scv.equals("TestCase"))
					{
						column=k;
					}
					k++;
				}
				//System.out.print(column);
				Iterator<Row> rows1= sheet.iterator();
				while(rows1.hasNext())
				{
					//System.out.print(column);
					Row r=rows1.next();
					//System.out.println(r.getCell(column).getRichStringCellValue());
					if(r.getCell(column).getRichStringCellValue().toString().equals(testcases))
					{
						Iterator<Cell>cv= r.cellIterator();
						while(cv.hasNext())
						{
							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING)
							{
								ab.add(c.getStringCellValue().toString());
							}
							else
							{
								String nn=NumberToTextConverter.toText(c.getNumericCellValue());
								ab.add(String.valueOf(c.getNumericCellValue()));
							}
							
						}
					}
				}
				
			}
			
				
			
		}
		return ab;
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException
	{
		ArrayList<String> ab=dataDriven.getdata("purchase");
		System.out.println(ab.size());
		for(String a:ab)
		{
			System.out.println(a);		}
	}

}
