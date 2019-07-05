package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Generated_ReportPOM {
	private WebDriver driver; 
		
	public Generated_ReportPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//a[@title='Reporting']")
	private WebElement reporting; 
	public void clickreporting() { 
		this.reporting.click();
		}
	
	@FindBy(xpath="//a[contains(text(),'Followed students')]")
	private WebElement followingstudent; 
	public void clickfollowingstudent() { 
		this.followingstudent.click();
		}
		
	@FindBy(xpath="//input[@id='search_user_keyword']")
	private WebElement text; 
	public void entersearch(String name) { 
		this.text.clear();
		this.text.sendKeys(name);
		}
	
	@FindBy(xpath="//button[@id='search_user_submit']")
	private WebElement search; 
	public void clicksearch() { 
		this.search.click();
		}
	
	@FindBy(xpath="//div[@class='table-responsive']//a[1]//img")
	private WebElement icon;
	public void clickicon() {
		this.icon.click(); 
		}
	
	@FindBy(xpath="//div[@class='table-responsive']//td[7]//img")
	private WebElement icon2;
	public void clickicon2() {
		this.icon2.click(); 
		}
	/////
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
