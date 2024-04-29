package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 import org.openqa.selenium.interactions.Actions;
import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
ContactsPage contactsPage;
TasksPage tasksPage; 
	@FindBy(xpath = "//td[contains(text(),'User: Mounika Nookala')]")
 	 @CacheLookup                                            
 	private WebElement userNameLabel;                                
                             
	
	
 	@FindBy(xpath = "//a[contains(text(),'Contacts')]")      
 	@CacheLookup
 	private WebElement contactsLink;                                 
 	                                                         
 	@FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[4]/ul/li[1]/a")   
 	WebElement newContactLink;                               
 	                                                         
                                                           
 	@FindBy(xpath = "//a[contains(text(),'Deals')]")         
 	WebElement dealsLink;                                    
                                                           
 	@FindBy(xpath = "//a[contains(text(),'Tasks')]")         
 	WebElement tasksLink;                                    
                                                           
 	// Initializing the Page Objects:                        
 	public HomePage(WebDriver driver) {                                      
 		this .driver=driver;
 		PageFactory.initElements(driver, this);                 
 	}                                                        
 	                                                         
 	public String verifyHomePageTitle(){                     
 		return driver.getTitle();                               
 	}                                                        
 	                                                         
 	                                                         
 	public boolean verifyCorrectUserName(){                  
 		return userNameLabel.isDisplayed();                     
 	}                                                        
 	                                                         
 	public ContactsPage clickOnContactsLink(){               
 		contactsLink.click();                                   
 		return new ContactsPage(driver);                              
 	}                                                        
 	                                                         
 	public DealsPage clickOnDealsLink(){                     
 		dealsLink.click();                                      
 		return new DealsPage();                                 
 	}                                                        
 	                                                         
 	public TasksPage clickOnTasksLink(){                     
 		tasksLink.click();                                      
 		return new TasksPage();                                 
 	}                                                        
 	                                                         
 	public void clickOnNewContactLink() throws InterruptedException{                     
 		try {
			Actions action = new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			newContactLink.click();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}                                 
 		                                                        
 	}                                                        
 	                                                         
 	                                                         
 	                                                         
 	                                                         
 	                                                         
 	                                                         
 	                                                         
                                                           
 }                                                         