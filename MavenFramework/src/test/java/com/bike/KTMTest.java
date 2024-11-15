package com.bike;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class KTMTest {
public static WebDriver driver;
 	@Test(groups = "smoke")
	public void ktm() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ktmindia.com/");
		Reporter.log("The KTM Website has been launched", true);
	}
}
