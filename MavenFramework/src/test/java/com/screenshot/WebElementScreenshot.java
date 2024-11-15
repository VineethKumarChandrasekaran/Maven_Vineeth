package com.screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementScreenshot {

	public static void main(String[] args) throws IOException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.chennaisuperkings.com/");
    File tempScreenShot = driver.findElement(By.xpath("//img[@class='cskHeaderIcon']")).getScreenshotAs(OutputType.FILE);
    File logo = new File("./Screenshot/csklogo.png");
    FileUtils.copyFile(tempScreenShot, logo);
	}

}
