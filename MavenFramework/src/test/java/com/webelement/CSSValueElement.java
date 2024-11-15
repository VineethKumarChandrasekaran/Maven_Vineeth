package com.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class CSSValueElement {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver(); 
	//WebDriver driver = new FirefoxDriver(); 
	driver.manage().window().maximize();
	driver.get("https://shop-global.malaicha.com/login");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='username']")).click();
	Thread.sleep(2000);
    String emailBorderColor = driver.findElement(By.xpath("//input[@name='username']")).getCssValue("border-bottom-color");
	System.out.println("emailBorderColor - "+emailBorderColor);
	System.out.println("EmailBorderColor - "+Color.fromString(emailBorderColor).asHex());//rgba(253, 137, 1, 1),#fd8901
	String RegisterButton = driver.findElement(By.xpath("//button[text()='Register']")).getCssValue("background-color");
	System.out.println("RegisterButtonColor - "+RegisterButton);
	System.out.println("RegisterButtonColor - "+Color.fromString(RegisterButton).asHex());//rgba(253, 137, 1, 1),#fd8901
	String RegisterButtonText = driver.findElement(By.xpath("//button[text()='Register']")).getCssValue("color");
	System.out.println("RegisterButtonTextColor - "+RegisterButtonText);
	System.out.println("RegisterButtonTextColor - "+Color.fromString(RegisterButtonText).asHex());//rgba(255, 255, 255, 1),ffffff
	}

}
