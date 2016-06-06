package testNGSuites;

import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import modularActions.HomePageBottomLinks;
import modularActions.MiddleMenu;
import pageObjectModel.Hotels;
import utilityPackage.Browser;
import utilityPackage.Constants;
import utilityPackage.HTMLReport;
import utilityPackage.ReadDataFile;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class TestSuiteOne {
	
	private String testCaseName = null;
	public String testDescription;
	
  @Test
  public void test1() {
	  System.out.println("Execution of " + testCaseName + " for iteration " + ReadDataFile.testIndex);
	  HomePageBottomLinks.clickParqueDisneyland();
	  Browser.driver.navigate().back();
	  HomePageBottomLinks.clickHorariosPaquetes();
	  Browser.driver.navigate().back();
	  HomePageBottomLinks.clickCentroAyuda();
	  
  }
  @Test
  public void test2(){
	  System.out.println("Execution of " + testCaseName + " for iteration " + ReadDataFile.testIndex);
	  MiddleMenu.clickDondeHospedarse();
	  HomePageBottomLinks.clickHorariosPaquetes();
	  HomePageBottomLinks.clicPeliculas();

  }
  @Test
  public void test3(){
	  System.out.println("Execution of " + testCaseName + " for iteration " + ReadDataFile.testIndex);
	  MiddleMenu.clickDondeHospedarse();
	  Hotels.Informate();
  }
  
  @BeforeMethod
  public void beforeMethod() throws BiffException, IOException {
	  //this method will read the testCaseName from the test data spreadsheet and executes before each test annotated method
	  testCaseName = ReadDataFile.getTestCaseName(Constants.test_item, ReadDataFile.testIndex);
	  testDescription = ReadDataFile.readDataByTestCase(Constants.test_description, testCaseName);
	  //Initialize the HTML Reporter. 
	  HTMLReport.runReport(testCaseName, testDescription);
	  //bring the browser up based on testCaseName read from test data pool file
	  Browser.seUpBrowser(testCaseName);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  //this method will run after each test method 
	  //tear down method will close the browser session.
	  Browser.tearDown();
	  //Increase in one the test Index to read the next test in the spreadsheet.
	  ReadDataFile.increaseTestIndex();
	  //testIndex++;
	  HTMLReport.htmlLog.endTest(HTMLReport.testLog);
	  HTMLReport.htmlLog.flush();
	  
  }

  @BeforeTest
  public void beforeTest() throws BiffException, IOException {
	  HTMLReport.initializeReport(Constants.test_report_path+Constants.test_report_name);
	  //Set the test data file to use for this test suite. 
	  ReadDataFile.setTestDataFileName(Constants.test_data_file_epadmTest);	 
	  //Set up the sheet name to read from the test data file.
	  ReadDataFile.setSheetName(Constants.sheet_one);
	  //Read the number of test iterations in the test data file and set it up on TestIt variable.
	  ReadDataFile.getTestIterations();
  }

}
