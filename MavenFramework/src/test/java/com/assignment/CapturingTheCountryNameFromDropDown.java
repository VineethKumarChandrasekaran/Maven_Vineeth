package com.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CapturingTheCountryNameFromDropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.orangehrm.com/contact-sales");
        List<WebElement> countrynames = new Select(driver.findElement(By.xpath("//select[@name='Country']"))).getOptions();
        for (WebElement country : countrynames) {
			if (country.getText().startsWith("M")) {
			   System.out.println(country.getText());	
			}
		}
	}

}
