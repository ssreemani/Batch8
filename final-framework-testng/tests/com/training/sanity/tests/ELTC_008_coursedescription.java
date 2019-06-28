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
import com.training.pom.CoursedescriptionPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_008_coursedescription {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CoursedescriptionPOM coursedescriptionPOM;
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
		coursedescriptionPOM= new CoursedescriptionPOM(driver);
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
	public void addcoursedescription() {
		loginPOM.sendUserName("manzoor");
		loginPOM.sendPassword("manzoor1");
		loginPOM.clickLoginBtn(); 
		
		coursedescriptionPOM.clickmycours();
		coursedescriptionPOM.clickcoursename();
		coursedescriptionPOM.clickcoursedesc();
		coursedescriptionPOM.clickdescription();
		coursedescriptionPOM.entertitle("Selenium course for beginners1111");
		coursedescriptionPOM.entercontent("Selenium course for beginners222222");
		coursedescriptionPOM.clicksave();
		
		String expected= "The description has been updated";
		String actual="";
		try {
			actual= coursedescriptionPOM.getmessage();
			Assert.assertEquals(actual,expected);
			screenShot.captureScreenShot("ELTC_008");
			externreport.generatereport(actual,"ELTC_08");
		}
		catch(Exception e) {		
			Assert.assertFalse(actual.contains(expected));
			externreport.failreport(actual, expected,"ELTC_08");
			}
		
	} 
	
}
