/**
 * 
 */
package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.relevantcodes.extentreports.LogStatus;

import utilityPackage.Browser;
import utilityPackage.HTMLReport;

/**
 * @author:		Omar Reyes 
 * @User:		Administrator
 * @Date:		May 10, 2016 1:04:18 PM
 * @File name:	Hotels.java
 * @git_config:	
 */
public class Hotels {
	
	public static void Informate(){
		try{
			Browser.driver.findElement(By.linkText("Infórmate")).click();
			HTMLReport.testLog.log(LogStatus.PASS, "Click on Informate");
		}
		catch(NoSuchElementException noE){
			HTMLReport.testLog.log(LogStatus.FAIL, "Click on Informate", "Failure: " + noE.getMessage());	
			
			
		}
		
	}

}
