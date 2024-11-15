package com.extendreport;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DemoApp {
	public static WebDriver driver;

	@Test
	public void demo() {
		String timestamp = LocalDateTime.now().toString().replace(":", "-");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("vineethkumar2797@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Vineeth2797");
		driver.findElement(By.xpath("//input[@id='RememberMe']")).click();
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
		TakesScreenshot ts = (TakesScreenshot)driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Report/extentreportscreenshot_"+timestamp+".html");
		ExtentReports extreport = new ExtentReports();
		extreport.attachReporter(spark);
		ExtentTest test = extreport.createTest("demo");
		test.log(Status.PASS, "Screenshot added to Report");
		test.addScreenCaptureFromBase64String(screenshot);
		extreport.flush();
		driver.manage().window().minimize();
		driver.quit();
	}
}
