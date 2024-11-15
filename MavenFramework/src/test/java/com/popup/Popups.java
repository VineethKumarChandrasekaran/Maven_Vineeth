package com.popup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Popups {
	public static WebDriver driver;
    public static Actions actions;

	@BeforeMethod
	public void preCondition() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void hiddenDivisionPopupIgnore() {
		driver.get("https://indianvisaonline.gov.in/");
		actions = new Actions(driver);
		actions.click().perform();
	}
	
	@Test
	public void hiddenDivisionPopupInteract() {
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//input[@class='loginCont__input']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
	}

	@Test
	public void javascriptPopupAccept() throws InterruptedException {
		driver.get("https://pib.gov.in/indexd.aspx?reg=3&lang=1");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.body.scrollHeight");
		driver.findElement(By.xpath("//a[text()='Ministry of Home Affairs']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	@Test
	public void javascriptPopupDismiss() throws InterruptedException {
		driver.get("https://pib.gov.in/indexd.aspx?reg=3&lang=1");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.body.scrollHeight");
		driver.findElement(By.xpath("//a[text()='Ministry of Home Affairs']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
	}

	@Test
	public void javascriptPopupGetText() throws InterruptedException {
		driver.get("https://pib.gov.in/indexd.aspx?reg=3&lang=1");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.body.scrollHeight");
		driver.findElement(By.xpath("//a[text()='Ministry of Home Affairs']")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void notificationPopup() {
		driver.get("https://www.justdial.com/");
	}
	
	@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
}
