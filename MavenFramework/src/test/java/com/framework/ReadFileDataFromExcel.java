package com.framework;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadFileDataFromExcel {
static WebDriver driver;
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream file = new FileInputStream("./src/test/resource/facebooklogindata.xlsx.xlsx");
    Workbook workbook = WorkbookFactory.create(file);
    String emailValue = workbook.getSheet("logindetails").getRow(1).getCell(0).getStringCellValue();
    String passValue = workbook.getSheet("logindetails").getRow(1).getCell(1).getStringCellValue();
    String url = workbook.getSheet("logindetails").getRow(1).getCell(2).getStringCellValue();
    System.out.println(emailValue);
    System.out.println(passValue);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(url);
    driver.findElement(By.id("email")).sendKeys(emailValue);
    driver.findElement(By.id("pass")).sendKeys(passValue);
    driver.findElement(By.xpath("//button[text()='Log in']")).click();
    System.out.println("The above given Credentials has been used for Login");
    for(int i=2;i<=5;i++) {
    		String emailValue1 = workbook.getSheet("logindetails").getRow(i).getCell(0).getStringCellValue();
    	    String passValue1 = workbook.getSheet("logindetails").getRow(i).getCell(1).getStringCellValue();
    	    System.out.println(emailValue1);
    	    System.out.println(passValue1);
    	    driver.switchTo().newWindow(WindowType.WINDOW);
    	    driver.manage().window().maximize();
    	    driver.get(url);
    	    driver.findElement(By.id("email")).sendKeys(emailValue1);
    	    driver.findElement(By.id("pass")).sendKeys(passValue1);
    	    driver.findElement(By.xpath("//button[text()='Log in']")).click();
    	    System.out.println("The above given Credentials has been used for Login");
    }
    driver.quit();
    }

}
