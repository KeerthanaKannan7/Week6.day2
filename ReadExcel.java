package week6.day2;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData(String fileName) throws IOException {
		
		// Step1: Setup the path for the workbook
		XSSFWorkbook openExcel = new XSSFWorkbook("./data/" + fileName + ".xlsx");
		
		// Step2: Get into the respective sheet
		XSSFSheet sheet = openExcel.getSheet("Sheet1");
		
		//get number of rows
		int rowCount = sheet.getLastRowNum();
		
		//get number of cell
		int cellCount = sheet.getRow(0).getLastCellNum();
		
		//fetching data from excel
		String[] [] data = new String [rowCount] [cellCount];
		for(int i = 1; i<=rowCount; i++)
			for(int j = 0; j < cellCount; j++)
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data);
		
		// Step6: Close the workbook
		openExcel.close();
		
		return data;

	}

}
