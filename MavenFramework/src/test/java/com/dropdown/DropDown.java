package com.dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    WebElement currency = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
    Select select = new Select(currency);
    	select.selectByIndex(3);
        System.out.println(select.getFirstSelectedOption().getText());
    	select.selectByValue("INR");
        System.out.println(select.getFirstSelectedOption().getText());
    	select.selectByVisibleText("AED");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for(int i=1; i<=4; i++) {
        	driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
        }
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
        driver.manage().window().minimize();
        driver.quit();
	}

}
