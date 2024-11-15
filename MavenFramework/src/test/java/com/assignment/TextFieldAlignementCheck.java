package com.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextFieldAlignementCheck {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		Point textfieldlocation = driver.findElement(By.xpath("//input[@id='email']")).getLocation();
		Dimension textfieldsize = driver.findElement(By.xpath("//input[@id='email']")).getSize();
		System.out.println("Left Alignement : "+textfieldlocation.getX());
		System.out.println("Right Alignement : "+(textfieldsize.getWidth()+textfieldlocation.getX()));
		System.out.println("Top Alignment : "+textfieldlocation.getY());
		System.out.println("Bottom Alignment : "+(textfieldsize.getHeight()+textfieldlocation.getY()));
		driver.manage().window().minimize();
	    driver.quit();
	}

}
