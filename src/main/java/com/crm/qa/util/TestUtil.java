package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {



  public static long PAGE_LOAD_TIMEOUT = 20;
  	public static long IMPLICIT_WAIT = 20;  
                                           

public static String TESTDATA_SHEET_PATH = "C:\\Users\\user\\eclipse-workspace\\FREECRMPROJECT\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";
  				          
  	   static Workbook book;
     	static Sheet sheet; 




public void switchToFrame(WebDriver driver) {          
		driver.switchTo().frame("mainpanel");
	}                                     

   public static Object[][] getTestData(String sheetName) throws IOException   {                                
   		FileInputStream file = null;                                                          
   		try {                                                                                 
   			file = new FileInputStream(TESTDATA_SHEET_PATH);                                     
   		} catch (FileNotFoundException e) {                                                   
   			e.printStackTrace();                                                                 
   		}                                                                                     
   		try {                                                                                 
   			book = WorkbookFactory.create(file);                                                 
   		  } catch (IOException e) {                                                             
   			e.printStackTrace();                                                                 
   		  }                                                                                     
   		sheet = book.getSheet(sheetName);                                                     
   		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
   		// System.out.println(sheet.getLastRowNum() + "--------" +                            
   		// sheet.getRow(0).getLastCellNum());                                                 
   		for (int i = 0; i < sheet.getLastRowNum(); i++) {                                     
   			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {                         
   				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();                             
   							// System.out.println(data[i][k]);                                                 
                			}                                                                                                            
                		}                                  
                		return data;                       
                	} 

  public static void screenShot(WebDriver driver, String filename)  {                                         
  		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
	  File source = takesScreenshot.getScreenshotAs(OutputType.FILE);                              
  		//String currentDir = System.getProperty("user.dir");                                                       
  		try {
			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\ScreenShot\\"+filename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
  
  }                                                                                                          




}






