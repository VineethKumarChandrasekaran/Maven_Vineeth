package com.dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CountNoOfCourtComplexInEachDistrict {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.get("https://services.ecourts.gov.in/ecourtindia_v6/?p=casestatus/index&app_token=166d9e86d2da6cab4a8243fc5976a58d7360d4b3a53603faf353999957f624a5");
        driver.findElement(By.xpath("(//button[@class='btn-close'])[1]")).click();
            }
}
