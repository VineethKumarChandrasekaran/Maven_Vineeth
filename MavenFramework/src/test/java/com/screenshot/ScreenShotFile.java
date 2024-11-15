package com.screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotFile {

	public static void main(String[] args) throws IOException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://www.facebook.com/");
    TakesScreenshot ts = (TakesScreenshot)driver;
    File temp = ts.getScreenshotAs(OutputType.FILE);
    File file = new File("./Screenshot/fbloginpage1.png");
    FileUtils.copyFile(temp, file);
	}

}
