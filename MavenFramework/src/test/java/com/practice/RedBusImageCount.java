package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBusImageCount {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.redbus.in/");
	List<WebElement> img = driver.findElements(By.tagName("img"));
    int count = 0;
    for (WebElement image : img) {
		count++;
	}
    System.out.println("Total No.of Images present in Redbus HomePage is "+count);
    driver.manage().window().minimize();
    driver.quit();
	}
}