package com.webelement;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsSelectedMethod {

	public static void main(String[] args) {
   WebDriver driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.get("https://services.ecourts.gov.in/ecourtindia_v6/?p=casestatus/index&app_token=f7cf112a0aa19b160d93ea8df58ae038cd6dcff2106817cf2b979a742af48668");
   String xpaths[]= {"//label[text()='Pending']/..//input[@id='radP']","//label[text()='Disposed']/..//input[@id='radD']","//label[text()='Both']/..//input[@id='radB']"};
	for(String xpath : xpaths) {
		WebElement RadioButton = driver.findElement(By.xpath(xpath));
		if (RadioButton.isSelected()) {
			System.out.println("The Radio Button is Selected");
		}else {
			System.out.println("The Radio Button is Not Selected");
		}
	}
	driver.manage().window().minimize();
	driver.quit();
	}

}
