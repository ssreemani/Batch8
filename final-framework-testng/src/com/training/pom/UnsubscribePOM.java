package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UnsubscribePOM {
	private WebDriver driver; 
	
	public UnsubscribePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement mycourse; 
		public void clickmycours() {
		this.mycourse.click();
		}
	
	@FindBy(xpath="//div[@class='classic-courses']//div[@class='panel panel-default'][1]//h4/a")
	private WebElement coursename;
	public void clickcoursename() {
		this.coursename.click(); 
		}
	
	@FindBy(xpath="//a[contains(text(),'Users')]")
	private WebElement user; 
	public void clickuser() {
		JavascriptExecutor js = (JavascriptExecutor) driver;         
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.user.click();
		}
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkbox;
	public void clickcheckbox() {
		this.checkbox.click(); 
		}
	
	@FindBy(xpath="//a[contains(text(),'Unsubscribe')]")
	private WebElement unsubscribe; 
	public void clickunsubscribe() {
		this.unsubscribe.click(); 
	}
	
	public void handlealert() {
		Alert alert= this.driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept(); 
	}
	
	@FindBy (xpath="//div[contains(text(),'User is now unsubscribed')]")
	private WebElement message;
	public String getmessage() {
		return this.message.getText();
		}
	
}
