package com.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetSizeAndGetLocation {

	public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.facebook.com/");
    int emailtextboxheight = driver.findElement(By.id("email")).getRect().getHeight();
    int emailtextboxwidth = driver.findElement(By.id("email")).getRect().getWidth();
    int passwordtextboxX = driver.findElement(By.id("pass")).getRect().getX();
    int passwordtextboxY = driver.findElement(By.id("pass")).getRect().getY();
    System.out.println("emailtextboxheight - "+emailtextboxheight);
    System.out.println("emailtextboxwidth - "+emailtextboxwidth);
    System.out.println("passwordtextboxX - "+passwordtextboxX);
    System.out.println("passwordtextboxY - "+passwordtextboxY);
	}

}
