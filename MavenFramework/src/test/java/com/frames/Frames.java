package com.frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frames {
	public static WebDriver driver;
	
	@BeforeMethod
	public void preCondition() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void frames() {
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width_css");
		WebElement outerframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(outerframe);
		WebElement innerframe = driver.findElement(By.xpath("//body/iframe[@title='Iframe Example']"));
		driver.switchTo().frame(innerframe);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String innerframetext = (String) jse.executeScript("return document.body.innerText;");
		System.out.println("The Inner Iframe Text is : "+ innerframetext);
		driver.switchTo().parentFrame();
		String outerframetext = (String) jse.executeScript("return document.body.innerText;");
		System.out.println("The Outer Iframe Text is : "+ outerframetext);
		driver.switchTo().defaultContent();
		String webpagetext = (String) jse.executeScript("return document.body.innerText;");
		System.out.println("The Webpage Text is : "+ webpagetext);
	}
	
	@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}

}
