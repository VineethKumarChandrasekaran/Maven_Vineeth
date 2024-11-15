package com.tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingTheTable {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://money.rediff.com/gainers");
    List<WebElement> columns = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
    List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
    for (WebElement col : columns) {
		System.out.printf("%-25s",col.getText());
    }
    System.out.println();
    for (WebElement row : rows) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        for (WebElement cell : cells) {
            System.out.printf("%-25s", cell.getText()); 
        }
        System.out.println();
    }
    System.out.println("The Current Price of the 599th Position Company in the List: " + driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[599]/td[4]")).getText());

	}

}
