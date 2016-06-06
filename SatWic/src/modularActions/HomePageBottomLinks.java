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
 * @Date:		May 10, 2016 12:41:26 PM
 * @File name:	HomePageBottomLinks.java
 * @git_config:	
 */
public class HomePageBottomLinks {
	
	public static void clickParqueDisneyland(){
		try{
			Browser.driver.findElement(By.id("GlobalFooterDisneylandParkHyperlinkUIElement")).click();
			HTMLReport.testLog.log(LogStatus.PASS, "Click Parque Disneyland hotlink");
		}
		catch(NoSuchElementException noE){
			
		}
		
	}
	
	public static void clickHorariosPaquetes(){
		
		try{
			Browser.driver.findElement(By.id("GlobalFooterCalendarParkHoursHyperlinkUIElement")).click();
			HTMLReport.testLog.log(LogStatus.PASS, "Click Horario de Paquetes hotlink");
		}
		catch(NoSuchElementException noE){
			
		}

		
	}
	
	public static void clickCentroAyuda(){
		try{
			Browser.driver.findElement(By.id("GlobalFooterHelpCenterHyperlinkUIElement")).click();
			HTMLReport.testLog.log(LogStatus.PASS, "Click Centro de Ayuda hotlink");
		}
		catch(NoSuchElementException noE){
			
			
		}
	}
	
	public static void clicPeliculas(){
		try{
			Browser.driver.findElement(By.xpath("//*[@id='goc-desktop-global']/li[3]/a/u")).click();
			HTMLReport.testLog.log(LogStatus.PASS, "Click Peliculas");
		}
		catch(NoSuchElementException noE){
			System.out.println("The element was not found due to: " + noE.getMessage());
		}

	}

}
