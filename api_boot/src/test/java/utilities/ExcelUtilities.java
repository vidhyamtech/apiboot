package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtilities {

	public static int totalRow;

	public List<Map<String, String>> getData(String excelFilePath, String sheetName, String operation)
			throws InvalidFormatException, IOException {
System.out.println(excelFilePath);
		Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
//Workbook workbook = WorkbookFactory.create(new File("src/test/resources/Testdata.xlsx"));
		Sheet sheet = workbook.getSheet(sheetName);
		workbook.close();
		return readSheet(sheet,operation);
	}

	private List<Map<String, String>> readSheet(Sheet sheet,String operation) {


		Row row;
		Cell cell;

		totalRow = sheet.getLastRowNum();

		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();

		for (int currentRow = 1; currentRow <= totalRow; currentRow++) {

			row = sheet.getRow(currentRow);

			int totalColumn = row.getLastCellNum();

			LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
			boolean isOperation=false;

			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {

				cell = row.getCell(currentColumn);
				//cell=CellUtil.getCell(row,currentColumn);

				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();

				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
				columnMapdata.put(columnHeaderName, value);
				//System.out.println(value + operation);
				if(value.equalsIgnoreCase(operation))
				{
					isOperation=true;
				}
			}

			if(isOperation)
			{
				excelRows.add(columnMapdata);
				System.out.println(excelRows);
			}
			
		}

		return excelRows;
	}

	public int countRow() {

		return totalRow;
	}

}






























/*public String getCellData(String fileName, int rowNum, int colNum) {
		FileInputStream fis = null;
		Workbook workbook = null;

		try {
			// Open the Excel file

			fis = new FileInputStream(new File(fileName));
			workbook = new XSSFWorkbook(fis);  // For .xlsx files
System.out.println(workbook);
			// Get the first sheet (index 0)
			Sheet sheet = workbook.getSheet("sheet1");
			//Sheet sheet = workbook.getSheetAt(0);

			// Get the row and cell
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(colNum);

			// Return the cell's value as a String
			return cell.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null) {
					workbook.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


}

 */