/**
 * 
 */
package modularActions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.relevantcodes.extentreports.LogStatus;

import utilityPackage.Browser;
import utilityPackage.HTMLReport;

/**
 * @author:		Omar Reyes 
 * @User:		Administrator
 * @Date:		May 10, 2016 12:57:54 PM
 * @File name:	MiddleMenu.java
 * @git_config:	
 */
public class MiddleMenu {
	
	public static void clickDondeHospedarse(){
		
		try{
			Browser.driver.findElement(By.id("placesToStayESButtonAction")).click();
			HTMLReport.testLog.log(LogStatus.PASS, "Click Donde Hospedarse Menu bar");
		}
		catch(NoSuchElementException noE){
			noE.getCause();
		}

		
	}

}
