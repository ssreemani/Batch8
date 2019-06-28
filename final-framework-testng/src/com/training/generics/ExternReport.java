package com.training.generics;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExternReport {

private WebDriver driver; 
	
	// the driver information will be given by selenium test case 
	public ExternReport(WebDriver driver){
		this.driver = driver; 
	}
	static Logger log= Logger.getLogger(ExternReport.class.getName());
	
	public void generatereport(String actual, String file) {
		ExtentReports extent;
		ExtentTest test;
		extent = new ExtentReports("C:\\Users\\IBM_ADMIN\\Desktop\\eclipse-jee-2019-03-R-win32-x86_64\\Output\\testresult"+file+".html", true);
		test = extent.startTest("test1");
		test.log(LogStatus.PASS, "Test Case sucessuffly Passed...-ExtentReport : " +actual);
		extent.endTest(test);       
		extent.flush();
		extent.close();
		///log4j
		log.info("Test Case sucessuffly Passed...-LOG4j" + actual);
	}
	public void failreport(String actual, String expected,String file) {
		ExtentReports extent;
		ExtentTest test;
		extent = new ExtentReports("C:\\Users\\IBM_ADMIN\\Desktop\\eclipse-jee-2019-03-R-win32-x86_64\\Output\\testresult"+file+".html", true);
		test = extent.startTest("test1");
		test.log(LogStatus.FAIL, "Test Case Failed....") ;
		test.log(LogStatus.INFO, "Actual Result is: " + actual +"Expected Result is: " +expected);
		extent.endTest(test);       
		extent.flush();
		extent.close();
		
		///log4j
		log.error("Test Case Failed....-LOG4j");
		log.warn("Actual Result is: " + actual +"Expected Result is: " +expected);
		}

}
