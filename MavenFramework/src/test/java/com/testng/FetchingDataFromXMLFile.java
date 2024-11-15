package com.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FetchingDataFromXMLFile {
public static WebDriver driver;
@Parameters({"browser","url","email","password"})
@Test
public void trello(@Optional("edge") String browser, String url, String email, String password) {
	if (browser.equals("chrome")) {
		driver = new ChromeDriver();
	}else if(browser.equals("firefox")) {
		driver = new FirefoxDriver();
	}else if(browser.equals("edge")) {
		driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	driver.get(url);
	driver.findElement(By.xpath("//a[text()='Log in']")).click();
	wait.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
	if (driver.getTitle().equals("Log in to continue - Log in with Atlassian account")) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(email);
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
	}
	driver.manage().window().minimize();
	driver.quit();
}	
}
