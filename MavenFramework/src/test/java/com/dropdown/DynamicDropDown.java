package com.dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {
public static WebDriver driver;
	public static void main(String[] args) {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
    driver.findElement(By.xpath("//a[@value='BLR']")).click();
    driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
    driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
    driver.manage().window().minimize();
    driver.quit();
	}
}