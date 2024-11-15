package com.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisplayedMethod {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.naukri.com/registration/createAccount?othersrcp=23531&wExp=N&utm_source=google&utm_medium=cpc&utm_campaign=Brand&gad_source=1&gclid=EAIaIQobChMIhI-MkqG6iAMVSxuDAx2jZCPxEAAYASAAEgLZNvD_BwE&gclsrc=aw.ds");
	driver.findElement(By.xpath("//h2[text()=\"I'm experienced\"]")).click();
	WebElement uploadlink = driver.findElement(By.xpath("//button[text()='Upload Resume']"));
	if (uploadlink.isDisplayed()) {
		System.out.println("Passed");
	}else {
		System.out.println("Failed");
	}
	driver.manage().window().minimize();
	driver.quit();
	}

}
