package com.popup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileuploadPopup {
	public static WebDriver driver;
    public static Actions actions;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	@BeforeMethod
	public void preCondition() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void fileUploadPopup() {
		driver.get("https://demo.guru99.com/test/upload/");
		driver.findElement(By.xpath("//input[@id='uploadfile_0']")).sendKeys("C:\\Users\\MSI\\Downloads\\Experience Documents\\Vineeth Kumar C - SDET.pdf");
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//button[@id='submitbutton']")).click();
		System.out.println(driver.findElement(By.xpath("//h3[@id='res']/center")).getText());
	}
	
	@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
}
