package com.dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestScript {
public static WebDriver driver;
	@Test(dataProviderClass = DataProvider.class, dataProvider = "logindata")
	public void login(String[] cred) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(cred[0]);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(cred[1]);
		driver.manage().window().minimize();
		driver.quit();
	}
}
