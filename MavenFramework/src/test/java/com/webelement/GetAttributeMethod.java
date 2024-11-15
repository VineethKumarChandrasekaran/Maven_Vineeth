package com.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeMethod {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	String groceryLogo = driver.findElement(By.xpath("//a[@aria-label='Grocery']//img")).getAttribute("alt");
	System.out.println("groceryLogo - "+groceryLogo);
	driver.manage().window().minimize();
	driver.quit();
	}

}
