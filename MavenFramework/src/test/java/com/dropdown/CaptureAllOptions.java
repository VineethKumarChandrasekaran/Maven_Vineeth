package com.dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.webelement.IsEnabledMethod;

public class CaptureAllOptions {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://bengaluru.dcourts.gov.in/case-status-search-by-case-number/");
    if(driver.findElement(By.xpath("//input[@value='courtComplex']")).isSelected()) {
     List<WebElement> dropdown = new Select(driver.findElement(By.xpath("//select[@id='est_code']"))).getOptions();
     for (WebElement option : dropdown) {
    	 System.out.println(option.getText()); 
	}
    }
    }
	}
