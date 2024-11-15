package com.thiveni;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MechDigitalApplication {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://mechdigital.thriveni.com/login");
    driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("cvi@thriveni.com");
    driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("Vineeth2797");
    driver.findElement(By.xpath("//button[text()='Login']")).click();
    
	}

}
