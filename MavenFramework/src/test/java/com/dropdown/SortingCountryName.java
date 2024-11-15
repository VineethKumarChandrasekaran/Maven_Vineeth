package com.dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SortingCountryName {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://orangehrm.com/en/book-a-free-demo/");
	List<WebElement> country = new Select(driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"))).getOptions();
	for(int i=country.size();i>=0;i--) {
		
	}
	}

}
