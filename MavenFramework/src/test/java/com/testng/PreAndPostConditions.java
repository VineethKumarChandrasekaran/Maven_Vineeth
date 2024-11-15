package com.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PreAndPostConditions {
public static WebDriver driver;
    @BeforeMethod
	public void preCondition() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
    @AfterMethod
	public void postCondition() {
    driver.manage().window().minimize();
    driver.quit();
	}
    @Test(priority = 0)
	public void facebook() {
	driver.get("https://www.facebook.com/");
    driver.switchTo().activeElement().sendKeys(Keys.chord("abc123@gmail.com"), Keys.TAB,Keys.chord("abc@123"),Keys.ENTER);
	}
    @Test(priority = 1)
	public void trello() {
	driver.get("https://trello.com/home");
	driver.findElement(By.xpath("//a[text()='Log in']")).click();
	if (driver.getTitle().equals("Log in to continue - Log in with Atlassian account")) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("vineethkumar2797@gmail.com");
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
	}
	}

}
