package com.car;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RollsRoyceTest {
public static WebDriver driver;
	@Test
	public void rollsRoyce() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.rolls-roycemotorcars.com/en_GB/home.html");
		Reporter.log("The RollsRoyce Website has been launched", true);
	}
}
