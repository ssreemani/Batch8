package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateGroupPOM {
	private WebDriver driver; 
	
	public CreateGroupPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Groups')]")
	private WebElement group; 
	public void clickgroup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;         
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.group.click();
		}
	
	@FindBy(xpath="//img[@title='Create new group(s)']")
	private WebElement creategroup;
	public void clickcreategroup() {
		this.creategroup.click(); 
		}
	
	@FindBy(xpath="//input[@id='create_groups_number_of_groups']")
	private WebElement numbergroup;
	public void enternumbergroup(String number) {
		this.numbergroup.clear();
		this.numbergroup.sendKeys(number);
		}
	
	@FindBy(xpath="//button[@id='create_groups_submit']")
	private WebElement porceed;
	public void clickporceed() {
		this.porceed.click(); 
		}
	
	@FindBy(xpath="//input[@name='group_0_name']")
	private WebElement namegroup;
	public void enternamegroup(String name) {
		this.namegroup.clear();
		this.namegroup.sendKeys(name);
		}
	
	@FindBy(xpath="//button[@id='create_groups_step2_submit']")
	private WebElement creategroups;
	public void clickcreategroups() {
		this.creategroups.click(); 
		}
	@FindBy (xpath="//div[contains(text(),'group(s) has (have) been added')]")
	private WebElement message1;
	public String getmessage1() {
		return this.message1.getText();
		}
	
	
	@FindBy(xpath="//img[@title='Group members']")
	private WebElement groupicon;
	public void clickgroupicon() {
		this.groupicon.click(); 
		}
	
	@FindBy(xpath="//select[@id='group_members']")
	private WebElement student;
	public void selectstudentname(String studentname) {
		Select user = new Select (this.student);
		user.selectByVisibleText(studentname);
	}
	
	@FindBy(xpath="//button[@id='group_members_rightSelected']")
	private WebElement addstudent;
	public void clickaddstudent() {
		this.addstudent.click(); 
		}
	@FindBy(xpath="//button[@id='group_edit_submit']")
	private WebElement savebutton;
	public void clicksavebutton() {
		this.savebutton.click(); 
		}
	
	@FindBy(xpath="//img[@title='Edit this group']")
	private WebElement editgroup;
	public void clickeditgroup() {
		this.editgroup.click(); 
		}
	@FindBy(xpath="//input[@name='self_registration_allowed']")
	private WebElement checkbox1;
	public void clickcheckbox1() {
		this.checkbox1.click(); 
		}
	@FindBy(xpath="//input[@name='self_unregistration_allowed']")
	private WebElement checkbox2;
	public void clickcheckbox2() {
		this.checkbox2.click(); 
		}
	@FindBy(xpath="//button[@id='group_edit_submit']")
	private WebElement savegroup; 
	public void clicksavegroup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;         
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.savegroup.click();
		}
	
	@FindBy (xpath="//div[contains(text(),'Group settings modified')]")
	private WebElement message2;
	public String getmessage2() {
		return this.message2.getText();
		}
}
