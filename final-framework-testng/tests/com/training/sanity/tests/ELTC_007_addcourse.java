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
import com.training.pom.addcoursePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_007_addcourse {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private addcoursePOM addcoursPOM1;
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
		addcoursPOM1 =new addcoursePOM(driver);
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
	public void addcourse() throws InterruptedException
	{
		loginPOM.sendUserName("manzoor");
		loginPOM.sendPassword("manzoor1");
		loginPOM.clickLoginBtn(); 
		
		addcoursPOM1.addcourse();
		addcoursPOM1.addcoursename("Selenium2");
		addcoursPOM1.advancesetting();
		addcoursPOM1.selectcategory("Projects (PROJ)");
		addcoursPOM1.addcoursecode("Sel2");
		addcoursPOM1.selectlanguage("English");
		addcoursPOM1.clickcourse();
		addcoursPOM1.clickintroduction();
		addcoursPOM1.addtext("This is an selenium course");
		addcoursPOM1.saveintrotext();
		String expected="Intro was updated";
		String actual="";
		try {
			actual=addcoursPOM1.getmessage();
			Assert.assertEquals(actual, expected);
			externreport.generatereport(actual,"ELTC_07");
			screenShot.captureScreenShot("ELTC_007");
		}
		catch(Exception e) {		
			Assert.assertFalse(actual.contains(expected));
			externreport.failreport(actual, expected, "ELTC_07");
			}
	}
}
