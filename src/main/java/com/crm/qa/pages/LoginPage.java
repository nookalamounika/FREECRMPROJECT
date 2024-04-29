package com.crm.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
//import com.crm.qa.testcases.HomePageTest;
//import com.crm.qa.testcases.HomePageTest;

public class LoginPage extends TestBase {
public WebDriver driver;
public HomePage homePage;
public LoginPage loginPage;
//page factory
//username
@FindBy(name="username")
WebElement username;
//password
@FindBy(name="password")
   WebElement password;
//login page
@FindBy(xpath="//input[@type='submit']")
WebElement loginBtn;


@FindBy(xpath="//a[contains(text(),'Sign Up')]")
WebElement signUpBtn;

@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
WebElement crmLogo;


public LoginPage(WebDriver driver) {
this.driver = driver;
	PageFactory.initElements(driver, this);
}
public String validateLoginPageTest() {

return driver.getTitle();
}

public boolean validateCRMImage() {

return crmLogo.isDisplayed();
}

public HomePage login(String un,String pwd) {
username.sendKeys(un);
password.sendKeys(pwd);
loginBtn.click();

return new HomePage(driver);



}




}
