package com.popup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarPopups {
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
	public void calender() throws InterruptedException {
		driver.get("https://www.goibibo.com/");
		actions = new Actions(driver);
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[text()='Round-trip']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(@class,'sc-12foipm-22')]")))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.chord("BLR"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(@class,'sc-12foipm-24')]")))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.chord("MAA"), Keys.ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Departure']")))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[text()='6 Nov'24']")).click();
		Thread.sleep(2000);
	}
	@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
}
