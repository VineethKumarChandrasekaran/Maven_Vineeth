package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkboxes {
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
	public void checkbox() throws RuntimeException, InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for (int i=1; i<=checkbox.size()-1;i++) {
			checkbox.get(i).click();
			Thread.sleep(2000);
			if (checkbox.get(i).isSelected()) {
				System.out.println("Checkbox got Selected");
			} else {
				System.out.println("Checkbox got Not Selected");
			}
		}
	}
	
	@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
}
