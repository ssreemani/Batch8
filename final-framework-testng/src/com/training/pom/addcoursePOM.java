package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addcoursePOM {
	private WebDriver driver; 
	
	public addcoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Create a course')]")
	private WebElement createcourse;
	public void addcourse() {
		this.createcourse.click();
	}
	@FindBy(id="title")
	private WebElement coursename;
	public void addcoursename(String coursename) {
		this.coursename.clear(); 
		this.coursename.sendKeys(coursename); 
	}
	@FindBy(id="advanced_params")
	private WebElement adsetting;
	public void advancesetting() {
		this.adsetting.click();
	}
	
	@FindBy(xpath="//select[@id='add_course_category_code']")
	private WebElement addcategory;
	public void selectcategory(String category) {
		Select obj = new Select(this.addcategory);
		obj.selectByVisibleText(category);
	}
	@FindBy(xpath="//input[@id='add_course_wanted_code']")
	private WebElement coursecode;
	public void addcoursecode(String coursecode) {
		this.coursecode.clear(); 
		this.coursecode.sendKeys(coursecode); 
	}
	@FindBy(xpath="//select[@id='add_course_course_language']")
	private WebElement language;
	public void selectlanguage(String language) {
		Select obj = new Select(this.language);
		obj.selectByVisibleText(language);
	}
	@FindBy(xpath="//button[contains(text(),'Create this course')]")
	private WebElement course;
	public void clickcourse() {
		this.course.click();
	}
	
	@FindBy(xpath="//em[@class='fa fa-file-text']")
	private WebElement introduction;
	public void clickintroduction() {
		this.introduction.click();
	}
	@FindBy(xpath="//textarea[@name='intro_content']")
	private WebElement textbox;
	public void addtext(String textbox) {
		//Unhidden the textbox
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementsByName('intro_content')[0].setAttribute('style','text');");
		this.textbox.clear(); 
		this.textbox.sendKeys(textbox); 
	}
	
		
	@FindBy(xpath="//button[@id='introduction_text_intro_cmdUpdate']")
	private WebElement saveintro;
	public void saveintrotext() {
		this.saveintro.click();
	}
	
	@FindBy(xpath="//div[contains(text(),'Intro was updated')]")
	private WebElement message;
	public String getmessage() {
		return this.message.getText();
		}
}
