package com.extendreport;

import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class IntroTest {
	public static WebDriver driver;
	@Test
	public void test() {
		String timestamp = LocalDateTime.now().toString().replace(":", "-");
	 //Step 1: create an instance of (Object) ExtentSparkReporter
	  ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Report/extentreport_"+timestamp+".html");
	  
	  //Step 2: Create an instance of (Object) ExtentReport  
	  ExtentReports extreport = new ExtentReports();
	  
	  //Step 3: Attach an instance of  ExtentSparkReporter to ExtentReport
	  extreport.attachReporter(spark);
	  
	  //Step 4: Create an instance of (Object) ExtentTest
	  ExtentTest test = extreport.createTest("test");
	  
	  //Step 5: call log() to provide status and log message
	  test.log(Status.PASS, "Log Message added to Report");
	  
	  //Step 6: call flush() to write message into destination
	  extreport.flush();
	}

}
