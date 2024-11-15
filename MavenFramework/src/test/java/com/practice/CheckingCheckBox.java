package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckingCheckBox {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    List<WebElement> checkboxs = driver.findElements(By.xpath("//input[@type='checkbox']"));
    System.out.println("No.of Checkboxes in the WebPage is " + checkboxs.size());
    for (WebElement checkbox : checkboxs) {
		Assert.assertFalse(checkbox.isSelected());
		checkbox.click();
		Assert.assertTrue(checkbox.isSelected());
		checkbox.click();
		Assert.assertFalse(checkbox.isSelected());
	}
    driver.manage().window().minimize();
    driver.quit();
	}

}
