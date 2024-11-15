package com.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickSubmitClearSendKeys {

	public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.facebook.com/");
    Thread.sleep(2000);
    driver.findElement(By.id("email")).sendKeys(Keys.chord("abc@gmail.com"));
    driver.findElement(By.id("pass")).sendKeys("Vineeth2797");
    driver.findElement(By.xpath("//button[@type='submit']")).sendKeys(Keys.ENTER);
	}

}
