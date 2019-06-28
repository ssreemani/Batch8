package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoursedescriptionPOM {
	private WebDriver driver; 
	
	public CoursedescriptionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement mycourse; 
		public void clickmycours() {
		this.mycourse.click();
		}
	
	@FindBy(xpath="//div[@class='classic-courses']//div[@class='panel panel-default'][2]//h4/a")
	private WebElement coursename;
	public void clickcoursename() {
		this.coursename.click(); 
		}
	
	@FindBy(xpath="//a[contains(text(),'Course description')]")
	private WebElement coursedesc; 
	public void clickcoursedesc() {
		this.coursedesc.click(); 
	}
		
	@FindBy(xpath="//img[@title='Description']")
	private WebElement description; 
	public void clickdescription() {
		this.description.click(); 
	}
	
	@FindBy(xpath="//input[@id='course_description_title']")
	private WebElement dtitle; 
	public void entertitle(String title) {
		this.dtitle.clear();
		this.dtitle.sendKeys(title);
	}
	
	@FindBy(xpath="//textarea[@id='contentDescription']")
	private WebElement content; 
	public void entercontent(String contents) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementsByName('contentDescription')[0].setAttribute('style','text');");
		this.content.clear();
		this.content.sendKeys(contents);
	}
	
	@FindBy(xpath="//button[@id='course_description_submit']")
	private WebElement save; 
	public void clicksave() {
		this.save.click(); 
	}
	
	
	  @FindBy (xpath="//div[contains(text(),'The description has been updated')]") 
	  private WebElement message;
	 
	  public String getmessage() { 
		  return this.message.getText(); 
		  }
	 
	
}
