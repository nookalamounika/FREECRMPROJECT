package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;
                                             
                                             

public class ContactsPage extends TestBase {


@FindBy(xpath="//td[contains(text(),'Contacts')]")
WebElement contactsLabel;
  
      @FindBy(id="first_name")                                                          
      	WebElement firstName;                                            
 	                                                                                                                 
 	@FindBy(id="surname")                                                                    
 	WebElement lastName;                                                                     
 	                                                                                         
 	@FindBy(name="client_lookup")                                                            
 	WebElement company;                                                                      
 	                                                                                         
 	@FindBy(xpath = "//input[@type='submit' and @value='Save']")                             
 	WebElement saveBtn;                                          	                                                                                          
 	                                                             	                                                                                          
  public ContactsPage(WebDriver driver) {                                                                   
  		this.driver = driver;
  		PageFactory.initElements(driver, this);                                                  
  	}                                                                                         
  	                                                                                          
  	                                                                                          
  	public boolean verifyContactsLabel(){                                                     
  		return contactsLabel.isDisplayed();                                                      
  	}                                                                                         
  	                                                                                          
  	                                                                                          
  	public void selectContactsByName(String name){                                            
  		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"   
  				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
  	}                                                                                         
  	                                                                                          
     public void createNewContact(String title, String ftName, String ltName, String comp){                                            
     	
			
				Select select = new Select(driver.findElement(By.name("title")));
		        select.selectByVisibleText(title);                                                  
     		                                                                                    
     		firstName.sendKeys(ftName);                                                         
     		lastName.sendKeys(ltName);                                                                      
     		company.sendKeys(comp);                                                             
     		saveBtn.click();                                                                    
     		                                                                                    
     	}                                                                                    
     	                                                                                     
     	                                                                                     
     	                                                                                     
                                                                                           
     }                                                                                     
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
             
 
 
 
 
 
               
 
 
 
 
                   
 
 





                                                                                      
 

  
 
  
  
  
                                
                             










                                                                                        
  	                                                                                          
  	                                                                                          
  	                                                                                          
                                                                                             
                                                                                           