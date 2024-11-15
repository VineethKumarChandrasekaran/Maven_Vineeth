package com.testng;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TrelloAssertion {
public static WebDriver driver;
@Test
public void trello() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	driver.get("https://trello.com/home");
	driver.findElement(By.xpath("//a[text()='Log in']")).click();
	wait.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
	assertEquals(driver.getTitle(),"Log in to continue - Log in with Atlassian account");
		driver.findElement(By.xpath("//input[@name='username']"))
				.sendKeys("vineethkumar2797@gmail.com");
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		driver.findElement(By.xpath("//input[@name='password']"))
				.sendKeys("Vineeth2797");
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
	
	wait.until(ExpectedConditions.titleIs("Boards | Trello"));
	assertEquals(driver.getTitle(),"Boards | Trello");
		driver.findElement(By.xpath("//span[text()='Create new board']")).click();
		driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']"))
				.sendKeys("M10");
		wait.until(ExpectedConditions
				.elementToBeClickable((driver.findElement(By.xpath("//button[text()='Create']")))));
		if ((driver.findElement(By.xpath("//button[text()='Create']"))).isEnabled()) {
			driver.findElement(By.xpath("//button[text()='Create']")).click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@aria-label='Show menu']"))));
	driver.findElement(By.xpath("//button[@aria-label='Show menu']")).click();
	driver.findElement(By.xpath("//div[text()='Close board']")).click();
	driver.findElement(By.xpath("//input[@data-testid='close-board-confirm-button']")).click();
	driver.findElement(By.xpath("//button[@data-testid='close-board-delete-board-button']")).click();
	driver.findElement(By.xpath("//button[@data-testid='close-board-delete-board-confirm-button']")).click();
	driver.findElement(By.xpath("//a[@aria-label='Back to home']")).click();
	wait.until(ExpectedConditions.titleIs("Boards | Trello"));
	assertEquals(driver.getTitle(),"Boards | Trello");
		driver.findElement(By.xpath("//span[@title='Vineeth Kumar C (vineethkumarc1)']")).click();
		driver.findElement(By.xpath("//button[@data-testid='account-menu-logout']/..//span[text()='Log out']"))
				.click();
	wait.until(ExpectedConditions.titleIs("Log out of your Atlassian account - Log in with Atlassian account"));
	assertEquals(driver.getTitle(),"Log out of your Atlassian account - Log in with Atlassian account");
		driver.findElement(By.xpath("//span[text()='Log out']")).click();
	driver.manage().window().minimize();
	driver.quit();
}
}

