package com.screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartHeaderScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		String Timestamp = LocalDateTime.now().toString().replace(":", "-");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_3sdu8W emupdz']/a//img"));
		List<WebElement> text = driver.findElements(By.xpath("//div[@class='_3sdu8W emupdz']/a//span/span"));
		for (int i=0; i<=elements.size()-1; i++) {
			    WebElement screenshot = elements.get(i);
			    String textelement = text.get(i).getText();
				File tempScreenShot =screenshot.getScreenshotAs(OutputType.FILE);
				File logo = new File("./Screenshot/"+textelement+Timestamp+".png");
				FileUtils.copyFile(tempScreenShot, logo);
		}
		
	}

}

