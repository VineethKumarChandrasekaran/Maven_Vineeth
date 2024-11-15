package com.bike;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class YamahaTest {
public static WebDriver driver;
 	@Test(groups = "functionality")
	public void yamaha() {
 		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.yamaha-motor-india.com/");
		Reporter.log("The Yamaha Website has been launched", true);
	}
}
