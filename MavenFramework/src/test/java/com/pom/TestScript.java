package com.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestScript {
	public static WebDriver driver;
	@Test
	public static void welcomePage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://trello.com/");
		WelcomePage welcomepage = new WelcomePage(driver);
		welcomepage.getLoginbutton().click();
		driver.manage().window().minimize();
		driver.quit();
	}

}
