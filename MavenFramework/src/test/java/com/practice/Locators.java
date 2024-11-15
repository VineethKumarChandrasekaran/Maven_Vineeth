package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {
public static WebDriver driver;
	public static void main(String[] args) {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.switchTo().activeElement().sendKeys(Keys.chord("contact@rahulshettyacadamey.com"),Keys.TAB,Keys.chord("rahulshettyacademy"));
    driver.findElement(By.xpath("//input[@value='rmbrUsername']")).click();
    driver.findElement(By.xpath("//input[@value='agreeTerms']")).click();
    driver.findElement(By.xpath("//button[text()='Sign In']")).click();
    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText(), "You are successfully logged in.");
    driver.findElement(By.xpath("//button[text()='Log Out']")).click();
    driver.manage().window().minimize();
    driver.quit();
	}

}
