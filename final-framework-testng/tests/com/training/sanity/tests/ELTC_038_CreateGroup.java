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
import com.training.pom.CreateGroupPOM;
import com.training.pom.LoginPOM;
import com.training.pom.UnsubscribePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_038_CreateGroup {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UnsubscribePOM unsubscribePOM;
	private CreateGroupPOM creategroupPOM;
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
		creategroupPOM=new CreateGroupPOM(driver);
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
	public void Create_Group() throws InterruptedException {
		loginPOM.sendUserName("manzoor");
		loginPOM.sendPassword("manzoor1");
		loginPOM.clickLoginBtn(); 
		
		unsubscribePOM.clickmycours();
		unsubscribePOM.clickcoursename();
				
		creategroupPOM.clickgroup();
		creategroupPOM.clickcreategroup();
		creategroupPOM.enternumbergroup("1");
		creategroupPOM.clickporceed();
		creategroupPOM.enternamegroup("Rock");
		creategroupPOM.clickcreategroups();
		
		String expected1= "group(s) has (have) been added"; 
		String actual1=creategroupPOM.getmessage1();
		screenShot.captureScreenShot("ELTC_038_1"); 
		Assert.assertEquals(actual1,expected1, "Test Case Failed : Group not added...");
		externreport.generatereport(actual1, "ELTC_038_1");
			
				
		creategroupPOM.clickgroupicon();
		creategroupPOM.selectstudentname("student1 teststudent (student1) - STUDENT1");
		creategroupPOM.clickaddstudent();
		creategroupPOM.clicksavebutton();
		creategroupPOM.clickeditgroup();
		creategroupPOM.clickcheckbox1();
		creategroupPOM.clickcheckbox2();
		creategroupPOM.clicksavegroup();
		
		String expected2= "Group settings modified"; 
		String actual2=creategroupPOM.getmessage2();
		screenShot.captureScreenShot("ELTC_038_2"); 
		Assert.assertEquals(actual2,expected2, "Test Case Failed : Group not modified...");
		externreport.generatereport(actual2, "ELTC_038_2");
		} 
	
}
