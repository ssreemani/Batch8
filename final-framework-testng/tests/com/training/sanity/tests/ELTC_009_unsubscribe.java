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
import com.training.pom.UnsubscribePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_009_unsubscribe {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UnsubscribePOM unsubscribePOM;
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
	public void Unsubscribe() throws InterruptedException {
		loginPOM.sendUserName("manzoor");
		loginPOM.sendPassword("manzoor1");
		loginPOM.clickLoginBtn(); 
		
		unsubscribePOM.clickmycours();
		unsubscribePOM.clickcoursename();
				
		unsubscribePOM.clickuser();
		unsubscribePOM.clickcheckbox();
		unsubscribePOM.clickunsubscribe();
		unsubscribePOM.handlealert();
		
		String expected= "User is now unsubscribed"; 
		String actual="";
		try {
			actual= unsubscribePOM.getmessage();
			Assert.assertEquals(actual,expected);
			externreport.generatereport(actual, "ELTC_09");
			screenShot.captureScreenShot("ELTC_009"); 
		}
		catch(Exception e) {		
			Assert.assertFalse(actual.contains(expected));
			externreport.failreport(actual, expected, "ELTC_09");
			}
	} 
	
}
