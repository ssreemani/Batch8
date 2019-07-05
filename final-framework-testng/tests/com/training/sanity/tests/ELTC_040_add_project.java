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
import com.training.pom.AddProjectPOM;
import com.training.pom.LoginPOM;
import com.training.pom.UnsubscribePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_040_add_project {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UnsubscribePOM unsubscribePOM;
	private AddProjectPOM addprojectPOM;
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
		addprojectPOM=new AddProjectPOM(driver);
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
	public void AddProject() throws InterruptedException {
		loginPOM.sendUserName("manzoor");
		loginPOM.sendPassword("manzoor1");
		loginPOM.clickLoginBtn(); 
		
		unsubscribePOM.clickmycours();
		unsubscribePOM.clickcoursename();
				
		addprojectPOM.clickproject();
		addprojectPOM.clicknewproject();
		addprojectPOM.entertitle("Project1");
		addprojectPOM.entersubtitle("Test Project1");
		addprojectPOM.clicksaveblog();
		addprojectPOM.clickprojectlink();
		addprojectPOM.clicknewtask();
		addprojectPOM.entertasktitle("Task Title Design");
		addprojectPOM.clicksave();
		
		String expected1= "The article has been added."; 
		String actual1=addprojectPOM.getmessage1();
		screenShot.captureScreenShot("ELTC_040_1"); 
		Assert.assertEquals(actual1,expected1,"Test Case Failed : Article not added...");
		externreport.generatereport(actual1, "ELTC_40_1");
							
		addprojectPOM.clicknewrole();
		addprojectPOM.clickaddnewrole();
		addprojectPOM.enterroletitle("Role Title Developer");
		addprojectPOM.clicksubmitrole();
		String expected2= "The task has been created"; 
		String actual2=addprojectPOM.getmessage2();
		screenShot.captureScreenShot("ELTC_040_2"); 
		Assert.assertEquals(actual2,expected2,"Test Case Failed : Task not Created...");
		externreport.generatereport(actual2, "ELTC_40_2");
			
				
		addprojectPOM.clickassignrole();
		addprojectPOM.selectassignuser("manzoor mehadi");
		addprojectPOM.clickvalidate();
		String expected3= "The task has been assigned."; 
		String actual3=addprojectPOM.getmessage3();
		screenShot.captureScreenShot("ELTC_040_3");
		Assert.assertEquals(actual3,expected3, "Test Case Failed : Task not Assigned...");
		externreport.generatereport(actual3, "ELTC_40_3");
			
				
		addprojectPOM.clickusermanage();
		addprojectPOM.clickcheckboxuser();
		addprojectPOM.clickregister();
		String expected4= "The user has been registered"; 
		String actual4=addprojectPOM.getmessage4();
		screenShot.captureScreenShot("ELTC_040_4"); 
		Assert.assertEquals(actual4,expected4, "Test Case Failed : User not Registered...");
		externreport.generatereport(actual4, "ELTC_40_4");
		} 
	
}
