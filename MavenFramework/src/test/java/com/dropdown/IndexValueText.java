package com.dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IndexValueText {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://services.ecourts.gov.in/ecourtindia_v6/?p=casestatus/index&app_token=166d9e86d2da6cab4a8243fc5976a58d7360d4b3a53603faf353999957f624a5");
    driver.findElement(By.xpath("//button[@class='btn-close']")).click();
    new Select(driver.findElement(By.xpath("//select[@id='sess_state_code']"))).selectByIndex(32);
    Thread.sleep(2000);
    new Select(driver.findElement(By.xpath("//select[@id='sess_dist_code']"))).selectByValue("24");
    Thread.sleep(2000);
    new Select(driver.findElement(By.xpath("//select[@id='court_complex_code']"))).selectByVisibleText("Combined Courts, Gobichettipalayam");
    Thread.sleep(2000);
    driver.manage().window().minimize();
    driver.quit();
	}

}
