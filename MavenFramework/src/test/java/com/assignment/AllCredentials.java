package com.assignment;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllCredentials {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.switchTo().activeElement().sendKeys(Keys.chord("abc123@gmail.com"), Keys.TAB,Keys.chord("abc@123"),Keys.ENTER);
		if (driver.getTitle().equals("Facebook")) {
			System.out.println("The given datas has been entered properly");
		} else {
			System.out.println("The given datas has been not entered properly");
		}
		driver.manage().window().minimize();
	    driver.quit();
	    //Repository Updated
	}

}
