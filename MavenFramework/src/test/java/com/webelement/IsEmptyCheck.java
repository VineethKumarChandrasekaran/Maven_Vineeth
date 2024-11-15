package com.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsEmptyCheck {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://shop-global.malaicha.com/login");
    String emailinput = driver.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
    String passwordinput = driver.findElement(By.xpath("//input[@name='pin']")).getAttribute("value");
    if (emailinput.isEmpty()&&passwordinput.isEmpty()) {
    	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("abc@gmail.com");
    	driver.findElement(By.xpath("//input[@name='pin']")).sendKeys("12345");
	}
    else {
    	driver.findElement(By.xpath("//input[@name='username']")).clear();
    	driver.findElement(By.xpath("//input[@name='pin']")).clear();
    	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("abc@gmail.com");
    	driver.findElement(By.xpath("//input[@name='pin']")).sendKeys("12345");
	}
    driver.manage().window().minimize();
    driver.quit();
	}

}
