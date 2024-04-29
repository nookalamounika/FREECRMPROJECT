package com.crm.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
//import com.crm.qa.base.TestBase;
//import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;







public class HomePageTest extends TestBase {
LoginPage loginPage;
HomePage homePage;
ContactsPage contactsPage;
TestUtil testUtil;
	
@BeforeMethod
	
	public void setup() {		
                                                                                                                                                                                                                                                                                                                                             
	  		readConfig();                                                                                                                                                                    
	  	System.setProperty("webdriver.chrome.driver", "C:\\new project\\drivers new\\new chrome\\chromedriver-win64\\chromedriver.exe");                                                     
	  	 driver = new ChromeDriver();                                                                                                                                                        
	  	driver.manage().deleteAllCookies();                                                                                                                                                  
	  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));                                                                                                                   
	                                                                                                                                                                                           
	  	driver.get(prop.getProperty("url"));                                                                                                                                                 
	  	loginPage = new LoginPage(driver);                                                                                                                                                   
	  	homePage = new HomePage(driver);                                                                                                                                                     
	  homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));			
  testUtil= new TestUtil();

	}
  		@Test(priority=2)                                                                       
        public void verifyHomePageTitleTest(){                                                  
  		
  			String homePageTitle = homePage.verifyHomePageTitle();                                 
  		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");            
  	//return new HomePage(driver);
  	}                                                                                       
  	                                                                                        
  	@Test(priority=3)                                                                       
  	public void verifyUserNameTest() {                                 
 testUtil=new TestUtil();
  		testUtil.switchToFrame(driver);
  	 	                                                                                                  
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  		Assert.assertTrue(homePage.verifyCorrectUserName());                                  
  	
  	}                                                                                       
  	                                                                                        
  	@Test(priority=4)                                                                       
  	public void verifyContactsLinkTest(){                         
  		testUtil= new TestUtil();	               
  		testUtil.switchToFrame(driver);
  			
  		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  			contactsPage = homePage.clickOnContactsLink();                                       
  	 
  	
  	}                                                                                       
  	                                                                                        
  	                                                                                        
  	                                                                                        
  	@AfterMethod                                                                            
  	public void tearDown(){                                                                 
  		driver.quit();                                                                         
  	}                                                                                      
  	                                                                                        
  	                                                                                        
                                                                                           
  }                                                                                        