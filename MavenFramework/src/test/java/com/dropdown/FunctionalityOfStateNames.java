package com.dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FunctionalityOfStateNames {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://services.ecourts.gov.in/ecourtindia_v6/?p=casestatus/index&app_token=166d9e86d2da6cab4a8243fc5976a58d7360d4b3a53603faf353999957f624a5");
	    driver.findElement(By.xpath("//button[@class='btn-close']")).click();
	    List<WebElement> state = new Select(driver.findElement(By.xpath("//select[@id='sess_state_code']"))).getOptions();
	    for (WebElement options : state) {
			System.out.println(options.getText());
			new Select(driver.findElement(By.xpath("//select[@id='sess_state_code']"))).selectByVisibleText(options.getText());
			if (options.isSelected()) {
				System.out.println("Pass");
			} else {
               System.out.println("Fail");
			}
		}
	}

}
