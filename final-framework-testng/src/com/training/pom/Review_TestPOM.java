package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Review_TestPOM {
	private WebDriver driver; 
	
	public Review_TestPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Tests')]")
	private WebElement test; 
		public void clicktest() {
		this.test.click();
		}
	
	@FindBy(xpath="//img[@title='Results and feedback']")
	private WebElement result;
	public void clickresult() {
		this.result.click(); 
		}
			
	@FindBy(xpath="//table[@id='results']//tr[7]//a[1]//img")
	private WebElement grade;
	public void clickgrade() {
		this.grade.click(); 
		}
	
	@FindBy(xpath="//input[@name='send_notification']")
	private WebElement checkbox;
	public void clickcheckbox() {
		JavascriptExecutor js = (JavascriptExecutor) driver;         
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.checkbox.click(); 
		}
		
	@FindBy(xpath="//button[@id='form-email_submit']")
	private WebElement correcttest;
	public void clickcorrecttest() {
		this.correcttest.click(); 
		}
	
	@FindBy (xpath="//div[@class='alert alert-info']")
	private WebElement message;
	public String getmessage() {
		return this.message.getText();
		}
	
}
