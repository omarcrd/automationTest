/**
 * 
 */
package utilityPackage;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author:		Omar Reyes 
 * @User:		Administrator
 * @Date:		May 10, 2016 11:43:56 AM
 * @File name:	HTMLReport.java
 * @git_config:	
 */
public class HTMLReport {
	
	
	public static ExtentReports htmlLog;
	public static ExtentTest testLog;
	
	public static void initializeReport(String htmlFilePath){
		htmlLog = new ExtentReports(htmlFilePath, true);
		htmlLog.addSystemInfo("Author", "Omar Reyes");
	}
	
	public static void runReport(String testName, String testDescription){
		testLog = htmlLog.startTest(testName, testDescription);	
	}

}
