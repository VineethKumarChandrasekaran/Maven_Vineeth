package com.car;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FerrariTest {
public static WebDriver driver;
	@Test
	public void ferrari() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ferrari.com/en-IN");
		Reporter.log("The Ferrari Website has been launched", true);
	}
}
