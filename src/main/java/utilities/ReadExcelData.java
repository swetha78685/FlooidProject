
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Sheet;
import jxl.Workbook;

public class ReadExcelData {

	public static int numberOfRows(String path, String sheetName){
		int rows=0;
		try{
			File f = new File(path);
			FileInputStream ios = new FileInputStream(f);
			XSSFWorkbook workbook = new XSSFWorkbook(ios);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			rows=sheet.getLastRowNum();
			System.out.println(rows);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rows;
	}


	public static String columnDataByHeaderName(int i, String colHeader, String sheetName,  String path)
	{
		String cellData = null;

		try {
			File f = new File(path);
			FileInputStream ios = new FileInputStream(f);

			XSSFWorkbook workbook = new XSSFWorkbook(ios);

			//				HSSFWorkbook

			XSSFSheet sheet = workbook.getSheet(sheetName);

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String finalcell=""+cell;
					int colnum=cell.getColumnIndex();
					if(finalcell.equalsIgnoreCase(colHeader)){// To match column value

						cellData=sheet.getRow(i).getCell(colnum).toString();
						break;							
					}
				}
			}


			ios.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//returns the complete column data
		return cellData;		
	}


	public static String excelReading(String path, String sheetName,String headerVal, int iRow){
		String value=null;
		try{
			File f = new File(path);
			FileInputStream ios = new FileInputStream(f);
			Workbook workbook=Workbook.getWorkbook(f);
			Sheet sh=workbook.getSheet(sheetName);

			for (int i = 0; i < sh.getRows(); i++) {
				for (int j = 0; j < sh.getColumns(); j++) {
					String sHeaderValue=sh.getCell(j, i).getContents();
					if(sHeaderValue.equals(headerVal)){
						value=sh.getCell(j, i+iRow).getContents();
						System.out.println(value);
						break;
					}
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}

	public static int numberOfRowsJXL(String path, String sheetName){
		int rows=0;
		try{
			File f = new File(path);
			FileInputStream ios = new FileInputStream(f);
			Workbook workbook=Workbook.getWorkbook(f);
			Sheet sh=workbook.getSheet(sheetName);
			rows= sh.getRows();
		}catch(Exception e){
			e.printStackTrace();
		}
		return rows;
	}

	public static void main(String a[]){
		int rows=numberOfRowsJXL(System.getProperty("user.dir")+"/TestData/TestData.xls", "Flipkart1");
		for (int i = 1; i <= rows; i++) {
			excelReading(System.getProperty("user.dir")+"/TestData/TestData.xls", "Flipkart1", "browserName", i);
		}


		//			numberOfRows(System.getProperty("user.dir")+"/TestData/TestData.xlsx", "Flipkart1");
	}
}


