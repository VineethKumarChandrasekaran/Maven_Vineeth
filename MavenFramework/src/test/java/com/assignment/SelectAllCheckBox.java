package com.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectAllCheckBox {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com/");
    driver.findElement(By.xpath("//span[text()='Mobiles']")).click();
    driver.findElement(By.xpath("//input[@class='zDPmFV']")).sendKeys(Keys.chord("Mobile"),Keys.ENTER);
    driver.findElement(By.xpath("//div[@class='e+xvXX KvHRYS']")).click();
    List<WebElement> checkboxs = driver.findElements(By.xpath("//div[@class='lx8H6m']"));
    System.out.println("The No.of Checkboxes in the Brand tab is " + checkboxs.size());
    for (WebElement check : checkboxs) {
		check.click();
		System.out.println(check.getText());
	}
    driver.manage().window().minimize();
    driver.quit();
	}

}
