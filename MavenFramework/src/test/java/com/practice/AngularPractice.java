package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AngularPractice {
	public static WebDriver driver;

	@BeforeMethod
	public void preCondition() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	}

	@Test
	public void angularPractice() throws InterruptedException {
    driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']")).sendKeys("Vineeth Kumar");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@name='email']")).sendKeys("vineethkumar2797@gmail.com");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("Vineeth2797");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
    Thread.sleep(2000);
    Select select = new Select(driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")));
    select.selectByVisibleText("Male");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@id='inlineRadio2']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("02071997");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    Thread.sleep(2000);
    System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
    Thread.sleep(2000);
	}
	
	@AfterMethod
	public void postCondition() {
	driver.manage().window().minimize();
	driver.quit();
	}
}
