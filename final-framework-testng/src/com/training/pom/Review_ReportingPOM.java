package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Review_ReportingPOM {
	private WebDriver driver; 
		
	public Review_ReportingPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//a[@id='istooldesc_940']")
	private WebElement reporting; 
	public void clickreporting() { 
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.reporting.click();
		}
		
	@FindBy(xpath="//div[@class='table-responsive']//tr[2]//td[16]//img")
	private WebElement icon;
	public void clickicon() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.icon.click(); 
		}
	
	@FindBy(xpath="//div[@class='table-responsive']//td[5]//img")
	private WebElement test; 
	public void clicktest() {
		this.test.click(); 
	}
	
	@FindBy(xpath="//input[@name='send_notification']")
	private WebElement checkbox; 
	public void clickcheckbox() {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.checkbox.click(); 
	}
	
	
	@FindBy(xpath="//button[@id='form-email_submit']")
	private WebElement submit; 
	public void clicksubmit() {
		this.submit.click(); 
	}
	
	@FindBy (xpath="//div[@class='alert alert-info']")
	private WebElement message;
	public String getmessage() {
		return this.message.getText();
		}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[1]//img")
	private WebElement courselink; 
	public void clickcourselink() {
		this.courselink.click(); 
	}
	
}
