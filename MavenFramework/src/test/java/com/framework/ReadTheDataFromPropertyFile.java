package com.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadTheDataFromPropertyFile {
static WebDriver driver;
	public static void main(String[] args) throws IOException {
	FileInputStream file = new FileInputStream("./src/test/resource/fbcommondata.properties");
	Properties pobj = new Properties();
    pobj.load(file);
    String browsername = pobj.getProperty("browser");
    if (browsername.equals("chrome")) {
		driver= new ChromeDriver();
	}else if (browsername.equals("firefox")) {
	  driver = new FirefoxDriver();	
	}else if (browsername.equals("edge")) {
		driver = new EdgeDriver();
	}
    driver.manage().window().maximize();
    driver.get(pobj.getProperty("url"));
    driver.findElement(By.id("email")).sendKeys(pobj.getProperty("email"));
    driver.findElement(By.id("pass")).sendKeys(pobj.getProperty("password"));
    driver.findElement(By.xpath("//button[text()='Log in']")).click();
    driver.manage().window().minimize();
    driver.quit();
	}

}
