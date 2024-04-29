package com.crm.qa.testcases;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {


   LoginPage loginPage;                                                                                   
   	HomePage homePage;                                                                                    
   	TestUtil testUtil;                                                                                    
   	ContactsPage contactsPage;                                                                            
   	 String sheetName = "contacts";                                                                                                     
   	                                                                       
   	@BeforeMethod                                                                                         
   	public void setUp()  {                                                     
   		                                                                                                     
   			                                                                                                                                                                                               	           
   		                  readConfig();                                                                                                                                                                                                      
   		             	System.setProperty("webdriver.chrome.driver", "C:\\new project\\drivers new\\new chrome\\chromedriver-win64\\chromedriver.exe");                                                                                       
   		             	 driver = new ChromeDriver();                                                                                                                                                                                          
   		             	driver.manage().deleteAllCookies();                                                                                                                                                                                    
   		             	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));                                                                                                                                                     
   		                                                                                                                                                                                                                                      
   	  	driver.get(prop.getProperty("url"));                                                                                                                                                                                   
   	  	loginPage = new LoginPage(driver);                                                                                                                                                                                     
   	  	homePage = new HomePage(driver);                                                                                                                                                                                       
   	  //contactsPage=new ContactsPage(driver);
   	  	homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));			                                                                                                                       
   	
   	  	
   	  	testUtil= new TestUtil();                                                                                                                                                                                                  
   	 testUtil.switchToFrame(driver);                                                                                                                                                                                                                          
   contactsPage = homePage.clickOnContactsLink();
   	
}                                                                                                                                                                                                                          
   	
   	
   	                                                                                                    
   	                                                                                                      
   	@Test(priority=1)                                                                                     
   	public void verifyContactsPageLabel(){                                                                
   		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");      
   	}                                                                                                     
   	                                                                                                      
   	@Test(priority=2)                                                                                     
   	public void selectSingleContactsTest(){                                                               
   		contactsPage.selectContactsByName("test2 test2");                                                    
   	}                                                                                                     
   	                                                                                                      
   	@Test(priority=3)                                                                                     
   	public void selectMultipleContactsTest(){                                                             
   		contactsPage.selectContactsByName("test2 test2");                                                    
   		contactsPage.selectContactsByName("ui uiii");                                                        
                                                                                                          
   	}                                                                                                     
   	                                                                                                      
   	@DataProvider                                         
   	
   	public Object[][] getCRMTestData() throws Exception   {
   	Object data[][] = TestUtil.getTestData(sheetName);
   			return data;
   	
   	
   	
   	}
   	
   	
   	
   	@Test(priority=4,dataProvider="getCRMTestData")                                                            
   		public void validateCreateNewContact(String title, String firstName, String lastName, String company) throws InterruptedException{                                 
   			    
   		 //homePage = new HomePage(driver);
   
		try {
			homePage.clickOnNewContactLink();
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
		}
		try {
			contactsPage.createNewContact(title, firstName, lastName, company);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		}	
					
   	@AfterMethod                                                                                                         				
     public static void tearDown(ITestResult result){                                                                                             					
     	if(result.FAILURE==result.getStatus())
     	{
   		
   		TestUtil.screenShot(driver, result.getName());
   		
   		
   		
   		
     	}
   		
   		
   		driver.quit();                                                                                                   					
					   	 }                                                                                                                   
					   	                                                                                                                     
					
				
					
				
					
					
				
				
			
				
					
   	
                    
                      

   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	





   	                                                                                                      
   
   
   
   
   
   
   
   
   	                                                                                                      
                                                                            
                                                                            
                                                                               
                                                                            
   	                                                                                                      
   	                                                                                                      
   	                                                                                                      
   	                                                                                                      
   }                                                                                                      