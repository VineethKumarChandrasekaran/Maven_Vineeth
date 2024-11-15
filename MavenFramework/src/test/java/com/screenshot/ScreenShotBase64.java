package com.screenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotBase64 {

	public static void main(String[] args) throws IOException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.facebook.com/");
    TakesScreenshot ts = (TakesScreenshot)driver;
    byte[] conref = Base64.getDecoder().decode(ts.getScreenshotAs(OutputType.BASE64));
    FileOutputStream fos = new FileOutputStream(new File("./Screenshot/fbloginpage.png"));
    fos.write(conref);
    fos.close();
	}

}
