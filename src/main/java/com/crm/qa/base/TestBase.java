package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//import com.crm.qa.util.TestUtil;
//import com.crm.qa.util.WebEventListener;


public class TestBase {
public LoginPage loginPage;
public HomePage homePage;
public static  WebDriver driver;
public  Properties prop;	
	
public void readConfig() {

        try {                                                                                                                                                                   
        			                                                                                                                                                                     
        	prop = new Properties();                                                                                                                                               
      			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");         
            prop.load(ip);                                                                                                                                                       
        		} catch (FileNotFoundException e) {                                                                                                                                   
        			e.printStackTrace();                                                                                                                                                 
        		} catch (IOException e) {                                                                                                                                             
        			e.printStackTrace();                                                                                                                                                 
        		}   
	}
	

	
	
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
}
