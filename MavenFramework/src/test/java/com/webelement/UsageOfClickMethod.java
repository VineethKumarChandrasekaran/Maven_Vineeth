package com.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfClickMethod {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.get("https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only%20Goibibo&utm_term=!SEM!DF!G!Brand!RSA!108599293!6504095653!617695092667!e!goibibo!c!&gad_source=1&gclid=EAIaIQobChMI-9uN_cKeiAMVymBIAB3cTQIeEAAYASAAEgI0a_D_BwE");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
    Thread.sleep(2000);
    System.out.println("Close Button Clicking Successful");
    driver.findElement(By.xpath("//p[text()='Round-trip']")).click();
    Thread.sleep(2000);
    System.out.println("RoundTrip Radio Button Clicking Successful");
    driver.findElement(By.xpath("//div[@class='sc-12foipm-91 biWUTl']")).click();
    Thread.sleep(2000);
    System.out.println("Student Checkbox Selecting Successful");
    driver.manage().window().minimize();
    driver.quit();
	}

}
