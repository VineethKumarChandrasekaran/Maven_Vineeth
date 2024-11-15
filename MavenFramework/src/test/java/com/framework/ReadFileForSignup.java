package com.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadFileForSignup {
static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
	 FileInputStream file = new FileInputStream("./src/test/resource/fbsignupcommondata.properties");
	  Properties pobj = new Properties();
	  pobj.load(file);
      String webbrowser = pobj.getProperty("browser");
      switch (webbrowser) {
	case "chrome":
		driver = new ChromeDriver();
		break;
	case "firefox":
		driver = new FirefoxDriver();
		break;
	case "edge":
		driver = new EdgeDriver();
		break;	
	}
      driver.manage().window().maximize();
      driver.get(pobj.getProperty("url"));
      Thread.sleep(2000);
      driver.findElement(By.xpath("//a[text()='Create new account']")).click();
      Thread.sleep(2000);
       String signupPageTitle = driver.getTitle();
      if (signupPageTitle.equals("Facebook – log in or sign up")) {
    	  driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(pobj.getProperty("firstname"));
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(pobj.getProperty("lastname"));
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(pobj.getProperty("mobile"));
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(pobj.getProperty("password"));
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(pobj.getProperty("password"));
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//select[@id='day']/..//option[text()='2']")).click();
    	  driver.findElement(By.xpath("//select[@id='month']/..//option[text()='Jul']")).click();
    	  driver.findElement(By.xpath("//select[@id='year']/..//option[text()='1997']")).click();
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//input[@value='2']")).click();
    	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//button[@name='websubmit']")).click();
    	  Thread.sleep(2000);
	}else {
		driver.get(pobj.getProperty("url"));
		System.out.println("The SignUp Page has not Displayed");
	}
      driver.manage().window().minimize();
      driver.quit();
	}
}
