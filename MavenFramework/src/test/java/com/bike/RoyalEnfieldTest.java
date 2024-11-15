package com.bike;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RoyalEnfieldTest {
public static WebDriver driver;
	@Test(groups = "system")
	public void royalEnfield() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.royalenfield.com/in/en/home/");
		Reporter.log("The RoyalEnfield Website has been launched", true);
	}
}
