package com.Mercuryts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MercuryTest {
	
	public WebDriver driver;
  @Test(dataProvider = "getdata")
  public void loginwithvalidds(String username, String password) {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  @BeforeMethod
  public void getallcookies() {
	  Set<Cookie> cookies=driver.manage().getCookies();
	  for(Cookie c:cookies)
	  {
		  System.out.println("Cookie name:-"+c.getName());
	  }
  }

  @AfterMethod
  public void capturescreenshot() throws IOException {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyToDirectory(src, new File("D:\\EclipseWorkSpace\\ReadExcel\\screenshot\\"));
  }


  @DataProvider
  public Object[][] getdata() throws IOException {
	  ReadExcelconfig config= new ReadExcelconfig();
	  config.exceldata("D:\\EclipseWorkSpace\\ReadExcel\\userdetails.xlsx");
	  
	  int rows=config.getrowcount("Sheet1");
	  int columns=config.getcolumncount("Sheet1");
	  Object [][] userdetails=new Object[rows][columns];
	  for(int i=0;i<rows;i++)
	  {
		  
	  for(int j=0;j<columns;j++)
	  {
			  userdetails[i][j]=config.getdata("Sheet1", i, j);
	  
	  }}
	return userdetails;   }
  
  @BeforeClass
  public void maximizebrowser() {
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void deleteCookies() {
	  driver.manage().deleteAllCookies();
  }

  @BeforeTest
  public void enterurl() {
	  driver.get("http://newtours.demoaut.com/");
  }

  @AfterTest
  public void dbconnection() {
	  System.out.println("dbconnection closed");
  }

  @BeforeSuite
  public void openbrowser() {
	  System.setProperty("webdriver.chrome.driver","F:\\selenium software\\chromedriver_win32\\chromedriver.exe");
	  driver= new ChromeDriver();
  }

  @AfterSuite
  public void closedbrowser() {
	  driver.close();
  }

}
