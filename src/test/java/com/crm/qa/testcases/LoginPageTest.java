package com.crm.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;


	
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
	
	}
	
	
	@Test(priority=1)
public void loginPageTitleTest() {
loginPage = new LoginPage(driver);
	String title = loginPage.validateLoginPageTest();
Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
}

@Test(priority=2)
public void crmLogoImageTest() {
loginPage = new LoginPage(driver);
	boolean flag = loginPage.validateCRMImage();
Assert.assertTrue(flag);
}

@Test(priority=3)
public HomePage loginTest() {
loginPage = new LoginPage(driver);
	homePage= new HomePage(driver);
homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
return new HomePage(driver);

}
@AfterMethod
public void tearDown() {
driver.quit();

}
}
