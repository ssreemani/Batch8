package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProjectPOM {
	private WebDriver driver; 
	
	public AddProjectPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Projects')]")
	private WebElement project; 
	public void clickproject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;         
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		this.project.click();
		}
	
	@FindBy(xpath="//img[@title='Create a new project']")
	private WebElement newproject;
	public void clicknewproject() {
		this.newproject.click(); 
		}
	
	@FindBy(xpath="//input[@id='add_blog_blog_name']")
	private WebElement title; 
	public void entertitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
	}
	
	@FindBy(xpath="//textarea[@id='add_blog_blog_subtitle']")
	private WebElement subtitle; 
	public void entersubtitle(String subtitle) {
		this.subtitle.clear();
		this.subtitle.sendKeys(subtitle);
	}
	
	@FindBy(xpath="//button[@id='add_blog_submit']")
	private WebElement saveblog;
	public void clicksaveblog() {
		this.saveblog.click(); 
		}
	
	@FindBy(xpath="//a[contains(text(),'Project1')]")
	private WebElement projectlink;
	public void clickprojectlink() {
		this.projectlink.click(); 
		}
	
	@FindBy(xpath="//img[@title='New task']")
	private WebElement newtask;
	public void clicknewtask() {
		this.newtask.click(); 
		}
	
	@FindBy(xpath="//input[@id='add_post_title']")
	private WebElement tasktitle; 
	public void entertasktitle(String titletask) {
		this.tasktitle.clear();
		this.tasktitle.sendKeys(titletask);
	}
	
	@FindBy(xpath="//button[@id='add_post_save']")
	private WebElement save;
	public void clicksave() {
		this.save.click(); 
		}
		
	  @FindBy (xpath="//div[contains(text(),'The article has been added.')]") 
	  private WebElement message1; 
	  public String getmessage1() { 
		  return this.message1.getText(); 
		  }
	 
	 @FindBy(xpath="//img[@title='Roles management']")
		private WebElement newrole;
		public void clicknewrole() {
			this.newrole.click(); 
			}
	
	@FindBy(xpath="//img[@title='Add a new role']")
		private WebElement addnewrole;
		public void clickaddnewrole() {
			this.addnewrole.click(); 
			}
		
	@FindBy(xpath="//input[@name='task_name']")
		private WebElement roletitle; 
		public void enterroletitle(String titlerole) {
			this.roletitle.clear();
			this.roletitle.sendKeys(titlerole);
		}
	
	@FindBy(xpath="//button[@name='Submit']")
		private WebElement submitrole;
		public void clicksubmitrole() {
			this.submitrole.click(); 
			}
		
	@FindBy (xpath="//div[contains(text(),'The task has been created')]") 
		  private WebElement message2; 
		  public String getmessage2() { 
			  return this.message2.getText(); 
			  }
		  
	@FindBy(xpath="//img[@title='Assign roles']")
			private WebElement assignrole;
			public void clickassignrole() {
				this.assignrole.click(); 
				}
			
	@FindBy(xpath="//select[@id='assign_task_task_user_id']")
	private WebElement assignuser;
	public void selectassignuser(String username) {
		Select user = new Select (this.assignuser);
		user.selectByVisibleText(username);
	}
	
	@FindBy(xpath="//button[@id='assign_task_submit']")
	private WebElement validate;
	public void clickvalidate() {
		this.validate.click(); 
		}
	
	@FindBy (xpath="//div[contains(text(),'The task has been assigned.')]") 
	  private WebElement message3; 
	  public String getmessage3() { 
		  return this.message3.getText(); 
		  }
	  
	  @FindBy(xpath="//img[@title='Users management']")
		private WebElement usermanage;
		public void clickusermanage() {
			this.usermanage.click(); 
			}
	@FindBy(xpath="//input[@type='checkbox']")
			private WebElement checkboxuser;
			public void clickcheckboxuser() {
				this.checkboxuser.click(); 
				}
	@FindBy(xpath="//a[contains(text(),'Register')]")
			private WebElement register;
			public void clickregister() {
				this.register.click(); 
				}
	@FindBy (xpath="//div[contains(text(),'The user has been registered')]") 
			  private WebElement message4; 
			  public String getmessage4() { 
				  return this.message4.getText(); 
				  }
}
