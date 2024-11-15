package com.javascriptexecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureHeightAndWidth {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://www.wikipedia.org/");
    driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys(Keys.chord("India"), Keys.ENTER);
    Thread.sleep(2000);
     JavascriptExecutor jse = (JavascriptExecutor) driver;
     System.out.println("Height Of the WebPage "+ jse.executeScript("return document.body.scrollHeight"));
     System.out.println("Width Of the WebPage "+ jse.executeScript("return document.body.scrollWidth"));
	}

}
