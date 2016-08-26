/**
 * 
 */
package utilityPackage;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @author:		Omar Reyes 
 * @User:		Administrator
 * @Date:		May 10, 2016 11:40:12 AM
 * @File name:	ReadDataFile.java
 * @git_config:	
 */
public class ReadDataFile {
	
	//this variable stores the test data file path location
	public static File data_file_path;
	public static int testIndex = 1;
	
	private static String setSheetName;
	private static Workbook wb;
	
	
	
	public static void setTestDataFileName(String fileName){
		data_file_path = new File(Constants.test_data_file_path, fileName);
		//data_file_path = new File(test_data_file_path, test_data_file_name);//commented line to make updates
	}
	
	
	//This method extract the cell data from a file. it is searched by column label and the test case name
	public static String readDataByTestCase(String columnLabel, String testCaseName) throws BiffException, IOException{
		
		//Load the workbook from where test data is read
		wb = Workbook.getWorkbook(data_file_path);
		//get the column number given the sheet name and cell label 
		Cell findCell = wb.getSheet(setSheetName).findLabelCell(columnLabel);
		int columnNum = findCell.getColumn();
		//int columnNum = wb.getSheet(sheetName).findLabelCell(columnLabel).getColumn();
		//get the row number given the test case name
		int rowNum = wb.getSheet(setSheetName).findLabelCell(testCaseName).getRow();
		//get the content of cell for the specified column and row number
		String cellData = wb.getSheet(setSheetName).getCell(columnNum, rowNum).getContents();
		//return cell data.
		return cellData;
	}
	
	/* Test Index start at 1 and read the second row on the test data spreadsheet.
	 * 0 = first row on excel, 1= second row on excel, 2 third row on excel etc.
	 * iteration variable store the number of existing test in the test data file
	 */
	public static void getTestIterations() throws BiffException, IOException{
		//Load the workbook from where test data is read
		wb = Workbook.getWorkbook(data_file_path);
		// get the number of rows of the given sheet
		int iterations = wb.getSheet(setSheetName).getRows();
		
		System.out.println("Reading "+ (iterations-1) + " test iterations.");	
		
	}
	
	public static String getTestCaseName(String columnLabel, int testIndex) throws BiffException, IOException{
		//Load the workbook from where test data is read
		wb = Workbook.getWorkbook(data_file_path);
		//get the column number given the sheet name and cell label 
		int columnNum = wb.getSheet(setSheetName).findLabelCell(columnLabel).getColumn();
		//get the content of cell for the specified column and row number
		String testCaseName = wb.getSheet(setSheetName).getCell(columnNum, testIndex).getContents();
		//return test case name from give cell.
		return testCaseName;
	}
	
	//it increase the test index plus one to read the next test case contained in the sheet
	public static void increaseTestIndex(){
		testIndex++;
	}
	
	public static void setSheetName(String sheet){
		setSheetName = sheet;
		//this is another change I have to do in the readdatafile java
	}

}
