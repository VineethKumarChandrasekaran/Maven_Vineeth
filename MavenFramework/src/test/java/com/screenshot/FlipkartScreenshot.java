package com.screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartScreenshot {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		String[] a = {"//img[@alt='Grocery']","//img[@alt='Mobiles']","//img[@alt='Fashion']","//img[@alt='Electronics']","//img[@alt='Home & Furniture']","//img[@alt='Appliances']","//img[@alt='Flight Bookings']","//img[@alt='Beauty, Toys & More']","//img[@alt='Two Wheelers']"};
		// String Timestamp = LocalDateTime.now().toString().replace(":", "-");
		int count =1;
		for (String i : a) {
				File tempScreenShot = driver.findElement(By.xpath(i)).getScreenshotAs(OutputType.FILE);
				File logo = new File("./Screenshot/flipkart"+count+".png");
				FileUtils.copyFile(tempScreenShot, logo);
				count++;
		}
	}
}