package com.assignment;

import java.awt.Color;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BorderColourCapture {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://shop-global.malaicha.com/login");
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Keys.ENTER,Keys.TAB);
	Thread.sleep(5000);
    String textfieldbordercolor = driver.findElement(By.xpath("//input[@name='username']")).getCssValue("border-color");
    System.out.println("The Colour of the Text Field Border is " + org.openqa.selenium.support.Color.fromString(textfieldbordercolor).asHex());
    driver.manage().window().minimize();
    driver.quit();
	}

}
