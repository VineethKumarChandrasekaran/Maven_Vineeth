package com.maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MavenParameterTest {
	public static WebDriver driver;
	@Test
	public void parameter() {
		 String url = System.getProperty("url");
		 String email = System.getProperty("email");
		 String password = System.getProperty("password");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		Reporter.log("The Website has been launched", true);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		System.out.println(email);
		System.out.println(password);
		driver.findElement(By.xpath("//button[]text()='Log In'")).click();
		driver.manage().window().minimize();
		driver.quit(); 
	}

}

