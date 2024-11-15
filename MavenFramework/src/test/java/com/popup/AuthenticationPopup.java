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

public class AuthenticationPopup {
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
	public void authenticationPopup() throws InterruptedException {
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		Thread.sleep(2000);
		System.out.println("Page Title : "+driver.getTitle());
		System.out.println("After Handling the Authentication : "+driver.findElement(By.tagName("p")).getText());
	}
	
	@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
}
