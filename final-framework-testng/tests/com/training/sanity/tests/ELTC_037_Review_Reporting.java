package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ExternReport;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.Review_ReportingPOM;
import com.training.pom.UnsubscribePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_037_Review_Reporting {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UnsubscribePOM unsubscribePOM;
	private Review_ReportingPOM reviewreportingPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ExternReport externreport;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		unsubscribePOM=new UnsubscribePOM(driver);
		reviewreportingPOM= new Review_ReportingPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		externreport = new ExternReport(driver);
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void ReviewReport() {
		loginPOM.sendUserName("manzoor");
		loginPOM.sendPassword("manzoor1");
		loginPOM.clickLoginBtn(); 
		
		unsubscribePOM.clickmycours();
		unsubscribePOM.clickcoursename();
				
		reviewreportingPOM.clickreporting();
		reviewreportingPOM.clickicon();
		reviewreportingPOM.clicktest();
		reviewreportingPOM.clickcheckbox();
		reviewreportingPOM.clicksubmit();
		
		String expected= "Message Sent"; 
		String actual=reviewreportingPOM.getmessage();
		screenShot.captureScreenShot("ELTC_037"); 
		Assert.assertEquals(actual,expected, "Test case Failed...");
		externreport.generatereport(actual, "ELTC_037");
		
		reviewreportingPOM.clickcourselink();
	} 
	
}
