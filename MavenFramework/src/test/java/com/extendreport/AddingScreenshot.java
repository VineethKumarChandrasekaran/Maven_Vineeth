package com.extendreport;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AddingScreenshot {
	public static WebDriver driver;
	@Test
	public void test() {
	  String timestamp = LocalDateTime.now().toString().replace(":", "-");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.flipkart.com/");
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  String photo = ts.getScreenshotAs(OutputType.BASE64);
	  ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Report/extentreportscreenshot_"+timestamp+".html");
	  // To change the theme of the report
	  spark.config().setTheme(Theme.DARK);
	  // To change the Page Title of the Report
	  spark.config().setDocumentTitle("Project Report");
	  ExtentReports extreport = new ExtentReports();
	  extreport.attachReporter(spark);
	  ExtentTest test = extreport.createTest("test");
	  test.log(Status.PASS, "Screenshot added to Report");
	  test.addScreenCaptureFromBase64String(photo);
	  extreport.flush();
	}
}
