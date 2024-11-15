package com.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDefaultSuggestions {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.google.co.in/");
    driver.switchTo().activeElement().click();
    List<WebElement> defaultsuggestions = driver.findElements(By.xpath("//div[@class='wM6W7d']/span"));
    System.out.println("The No.of Default Suggestions are " + defaultsuggestions.size());
    for (WebElement suggestion : defaultsuggestions) {
		System.out.println(suggestion.getText());
	}
    driver.manage().window().minimize();
    driver.quit();
	}

}
