package com.bike;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DucatiTest {
public static WebDriver driver;
 	@Test(groups = "smoke")
	public void ducati() {
 		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ducati.com/in/en/home");
		Reporter.log("The Ducati Website has been launched", true);
	}
}
