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
import com.training.pom.Review_TestPOM;
import com.training.pom.UnsubscribePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_036_review_test {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UnsubscribePOM unsubscribePOM;
	private Review_TestPOM reviewtestPOM;
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
		reviewtestPOM=new Review_TestPOM(driver);
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
	public void Review_Test() throws InterruptedException {
		loginPOM.sendUserName("manzoor");
		loginPOM.sendPassword("manzoor1");
		loginPOM.clickLoginBtn(); 
		
		unsubscribePOM.clickmycours();
		unsubscribePOM.clickcoursename();
				
		reviewtestPOM.clicktest();
		reviewtestPOM.clickresult();
		reviewtestPOM.clickgrade();
		reviewtestPOM.clickcheckbox();
		reviewtestPOM.clickcorrecttest();
		
		String expected= "Message Sent"; 
		String actual=reviewtestPOM.getmessage();
		screenShot.captureScreenShot("ELTC_036"); 
		Assert.assertEquals(actual,expected, "Test case Failed...");
		externreport.generatereport(actual, "ELTC_036");
		} 
	
}
