package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ListofCoursePOM {
	private WebDriver driver; 
	
	public ListofCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Course catalog')]")
	private WebElement coursecatalog; 
	public void clickcoursecatalog() {
		JavascriptExecutor js = (JavascriptExecutor) driver;         
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.coursecatalog.click();
		}
	
	@FindBy(xpath="//input[@name='search_term']")
	private WebElement searchtext;
	public void entertext(String text) {
		this.searchtext.clear(); 
		this.searchtext.sendKeys(text); 
	}
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	private WebElement searchbutton; 
	public void clicksearchbutton() {
		this.searchbutton.click(); 
	}
	
	@FindBy (xpath="//strong[contains(text(),'Search')]")
	private WebElement message;
	
	public String getmessage() {
		return this.message.getText();
		}
	
}
