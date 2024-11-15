package com.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsEnabledMethod {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.naukri.com/registration/createAccount?othersrcp=23531&wExp=N&utm_source=google&utm_medium=cpc&utm_campaign=Brand&gad_source=1&gclid=EAIaIQobChMIhI-MkqG6iAMVSxuDAx2jZCPxEAAYASAAEgLZNvD_BwE&gclsrc=aw.ds");
    driver.findElement(By.id("name")).sendKeys("Vineeth Kumar");
    driver.findElement(By.id("email")).sendKeys("vineethkumar2797@gmail.com");
    driver.findElement(By.id("password")).sendKeys("Vineeth2797");
    driver.findElement(By.id("mobile")).sendKeys("9629945555");
    WebElement registerButton = driver.findElement(By.xpath("//button[text()='Register now']"));
    if (registerButton.isEnabled()) {
    	registerButton.click();
    	System.out.println("Register Button is Enabled");
	}else {
		driver.findElement(By.xpath("//h2[text()=\"I'm experienced\"]")).click();
		driver.findElement(By.xpath("//i[@class='ico resman-icon resman-icon-check-box']")).click();
		registerButton.click();
		System.out.println("Register Button is Disabled, After Clicking the T&C checkbox and Experience Level the Register button got Enabled ");
	}
    driver.manage().window().minimize();
    driver.quit();
	}

}
