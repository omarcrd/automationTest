/**
 * 
 */
package utilityPackage;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

/**
 * @author:		Omar Reyes 
 * @User:		Administrator
 * @Date:		May 10, 2016 11:25:51 AM
 * @File name:	Browser.java
 * @git_config:	
 */
public class Browser {
	
	public static WebDriver driver = null;
	
	//this method creates the object driver and start the browser session.
		public static void seUpBrowser(String testCaseName) throws BiffException, IOException{
			
				
			String browser = ReadDataFile.readDataByTestCase(Constants.browser, testCaseName);
			String test_url = ReadDataFile.readDataByTestCase(Constants.test_url, testCaseName);
			
			String matchBrowser = browser;
			String setURL = test_url;
			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			/*
			 * Following piece of code is to instantiate the Firefox browser
			 */
			if(matchBrowser.equalsIgnoreCase("Firefox")){
				FirefoxProfile profile = new FirefoxProfile();
				//profile.setPreference("security.tls.version.fallback-limit", 1);
				driver = new FirefoxDriver(profile);
				driver.manage().window().maximize();
				
				try{
					driver.get(setURL);
					HTMLReport.testLog.log(LogStatus.INFO, "Launch Browser", "Initialize Firefox Browser to start testing");
					
				}
				catch(Exception e_url){
					HTMLReport.testLog.log(LogStatus.FAIL, "Launch Browser", "URL could not be passed to the Browser: " + e_url.getCause());
				}
						
				
			}else if(matchBrowser.equalsIgnoreCase("ie")){
				
				//This portion of code will open the Internet Explorer Driver and pass the Test URL to the browser	
				System.setProperty("webdriver.ie.driver", "C:\\Users\\Administrator\\git\\automationTest\\Satwic\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				try{
					driver.get(setURL);
					HTMLReport.testLog.log(LogStatus.INFO, "Launch Browser", "Initialize Internet Explorer Browser to start testing");
				}
				catch(Exception e_url){
					HTMLReport.testLog.log(LogStatus.FAIL, "Launch Browser", "URL could not be passed to the Browser: " + e_url.getCause());
				}

				//following statement may not be needed unless a security certificate problem
				//driver.findElement(By.id("overridelink")).click();
				//Continue the security certificate.
				
			}else if(matchBrowser.equalsIgnoreCase("googleChrome")){
				//This portion of code will open Google Chrome Driver and pass the Test URL to the browser	
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\git\\automationTest\\Satwic\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				try{
					driver.get(setURL);	
					HTMLReport.testLog.log(LogStatus.INFO, "Launch Browser", "Initialize Google Chrome Browser to start testing");
				}
				catch(Exception e_url){
					HTMLReport.testLog.log(LogStatus.INFO, "Launch Browser", "URL could not be passed to the Browser: " + e_url.getCause());
				}
				
			}else{
				System.out.println("Browser is not valid please use firefox, ie or googlechrome");
			}		
			
		}
		
		/*
		 * This method close the driver object and browser session 
		 */
		public static void tearDown() throws InterruptedException{
			//wait for around 2 seconds before close the browser session
			Thread.sleep(2000);// This sleep is just for the user to see the test case is running before the browser is close. 
			//In a real test this line can be removed
			HTMLReport.testLog.log(LogStatus.INFO, "Close Browser", "Shut down the webdriver instance and close the browser window");
			//shutdown the web driver instance and close all browser windows
			driver.quit();
			
		}

		

}
