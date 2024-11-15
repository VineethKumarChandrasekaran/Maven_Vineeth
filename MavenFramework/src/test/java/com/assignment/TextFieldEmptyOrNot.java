package com.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextFieldEmptyOrNot {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://in.bookmyshow.com/explore/home/bengaluru");
		driver.findElement(By.xpath("//div[text()='Sign in']")).click();
		String textfield = driver.findElement(By.xpath("//input[@id='mobileNo']")).getAttribute("value");
		if (textfield.isEmpty()) {
			System.out.println("The Textfield is Empty");
		} else {
			System.out.println("The Textfield is not Empty");
		}

		driver.manage().window().minimize();
	    driver.quit();
	}

}
