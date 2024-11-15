package com.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrelloApplicationLogin {
	static WebDriver driver;

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream file = new FileInputStream("./src/test/resource/trellologindetails.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://trello.com/home");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		wait.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
		if (driver.getTitle().equals("Log in to continue - Log in with Atlassian account")) {
			driver.findElement(By.xpath("//input[@name='username']"))
					.sendKeys(workbook.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue());
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			driver.findElement(By.xpath("//input[@name='password']"))
					.sendKeys(workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue());
			driver.findElement(By.xpath("//span[text()='Log in']")).click();
		}
		wait.until(ExpectedConditions.titleIs("Boards | Trello"));
		if (driver.getTitle().equals("Boards | Trello")) {
			driver.findElement(By.xpath("//span[text()='Create new board']")).click();
			driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']"))
					.sendKeys(workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue());
			wait.until(ExpectedConditions
					.elementToBeClickable((driver.findElement(By.xpath("//button[text()='Create']")))));
			if ((driver.findElement(By.xpath("//button[text()='Create']"))).isEnabled()) {
				driver.findElement(By.xpath("//button[text()='Create']")).click();
			}
		}
		wait.until(ExpectedConditions
				.titleIs(workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue() + " | Trello"));
		if (driver.getTitle()
				.equals(workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue() + " | Trello")) {
			for (int r = 1; r <= 5; r++) {
				driver.findElement(By.xpath("//textarea[@class='qJv26NWQGVKzI9']"))
						.sendKeys(workbook.getSheet("Sheet1").getRow(r).getCell(3).getStringCellValue());
				driver.findElement(By.xpath("//textarea[@class='qJv26NWQGVKzI9']")).sendKeys(Keys.ENTER);
			}
			for (int r = 1; r <= 5; r++) {
				wait.until(
						ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath("//a[text()='Java']")))));
				if (driver.findElement(By.xpath("//a[text()='Java']")).getText()
						.equals(workbook.getSheet("Sheet1").getRow(r).getCell(3).getStringCellValue())) {
					driver.findElement(By.xpath("//a[text()='Java']")).click();
					driver.findElement(By.xpath("//span[text()='Checklist']")).click();
					driver.findElement(By.xpath("//input[@id='id-checklist']"))
							.sendKeys(workbook.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue());
					driver.findElement(By.xpath("//input[@id='id-checklist']")).sendKeys(Keys.ENTER);
					for (int r1 = 1; r1 <= 5; r1++) {
						driver.findElement(By.xpath("//textarea[@data-testid='check-item-name-input']"))
								.sendKeys(workbook.getSheet("Sheet1").getRow(r1).getCell(5).getStringCellValue());
						driver.findElement(By.xpath("//textarea[@data-testid='check-item-name-input']"))
								.sendKeys(Keys.ENTER);
					}
					driver.findElement(By.xpath("//span[@data-testid='CloseIcon']")).click();
				} else if (driver.findElement(By.xpath("//a[text()='Automation']")).getText()
						.equals(workbook.getSheet("Sheet1").getRow(r).getCell(3).getStringCellValue())) {
					driver.findElement(By.xpath("//a[text()='Automation']")).click();
					driver.findElement(By.xpath("//span[text()='Checklist']")).click();
					driver.findElement(By.xpath("//input[@id='id-checklist']"))
							.sendKeys(workbook.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue());
					driver.findElement(By.xpath("//input[@id='id-checklist']")).sendKeys(Keys.ENTER);
					for (int r1 = 1; r1 <= 5; r1++) {
						driver.findElement(By.xpath("//textarea[@data-testid='check-item-name-input']"))
								.sendKeys(workbook.getSheet("Sheet1").getRow(r1).getCell(6).getStringCellValue());
						driver.findElement(By.xpath("//textarea[@data-testid='check-item-name-input']"))
								.sendKeys(Keys.ENTER);
					}
					driver.findElement(By.xpath("//span[@data-testid='CloseIcon']")).click();
				} else if (driver.findElement(By.xpath("//a[text()='SQL']")).getText()
						.equals(workbook.getSheet("Sheet1").getRow(r).getCell(3).getStringCellValue())) {
					driver.findElement(By.xpath("//a[text()='SQL']")).click();
					driver.findElement(By.xpath("//span[text()='Checklist']")).click();
					driver.findElement(By.xpath("//input[@id='id-checklist']"))
							.sendKeys(workbook.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue());
					driver.findElement(By.xpath("//input[@id='id-checklist']")).sendKeys(Keys.ENTER);
					for (int r1 = 1; r1 <= 5; r1++) {
						driver.findElement(By.xpath("//textarea[@data-testid='check-item-name-input']"))
								.sendKeys(workbook.getSheet("Sheet1").getRow(r1).getCell(7).getStringCellValue());
						driver.findElement(By.xpath("//textarea[@data-testid='check-item-name-input']"))
								.sendKeys(Keys.ENTER);
					}
					driver.findElement(By.xpath("//span[@data-testid='CloseIcon']")).click();
				} else if (driver.findElement(By.xpath("//a[text()='Manual']")).getText()
						.equals(workbook.getSheet("Sheet1").getRow(r).getCell(3).getStringCellValue())) {
					driver.findElement(By.xpath("//a[text()='Manual']")).click();
					driver.findElement(By.xpath("//span[text()='Checklist']")).click();
					driver.findElement(By.xpath("//input[@id='id-checklist']"))
							.sendKeys(workbook.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue());
					driver.findElement(By.xpath("//input[@id='id-checklist']")).sendKeys(Keys.ENTER);
					for (int r1 = 1; r1 <= 5; r1++) {
						driver.findElement(By.xpath("//textarea[@data-testid='check-item-name-input']"))
								.sendKeys(workbook.getSheet("Sheet1").getRow(r1).getCell(8).getStringCellValue());
						driver.findElement(By.xpath("//textarea[@data-testid='check-item-name-input']"))
								.sendKeys(Keys.ENTER);
					}
					driver.findElement(By.xpath("//span[@data-testid='CloseIcon']")).click();
				} else if (driver.findElement(By.xpath("//a[text()='API']")).getText()
						.equals(workbook.getSheet("Sheet1").getRow(r).getCell(3).getStringCellValue())) {
					driver.findElement(By.xpath("//a[text()='API']")).click();
					driver.findElement(By.xpath("//span[text()='Checklist']")).click();
					driver.findElement(By.xpath("//input[@id='id-checklist']"))
							.sendKeys(workbook.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue());
					driver.findElement(By.xpath("//input[@id='id-checklist']")).sendKeys(Keys.ENTER);
					for (int r1 = 1; r1 <= 5; r1++) {
						driver.findElement(By.xpath("//textarea[@data-testid='check-item-name-input']"))
								.sendKeys(workbook.getSheet("Sheet1").getRow(r1).getCell(9).getStringCellValue());
						driver.findElement(By.xpath("//textarea[@data-testid='check-item-name-input']"))
								.sendKeys(Keys.ENTER);
					}
					driver.findElement(By.xpath("//span[@data-testid='CloseIcon']")).click();
				}
			}
			driver.findElement(By.xpath("//button[@aria-label='Show menu']")).click();
			driver.findElement(By.xpath("//div[text()='Close board']")).click();
			driver.findElement(By.xpath("//input[@data-testid='close-board-confirm-button']")).click();
			driver.findElement(By.xpath("//button[@data-testid='close-board-delete-board-button']")).click();
			driver.findElement(By.xpath("//button[@data-testid='close-board-delete-board-confirm-button']")).click();
		}
		driver.findElement(By.xpath("//a[@aria-label='Back to home']")).click();
		wait.until(ExpectedConditions.titleIs("Boards | Trello"));
		if (driver.getTitle().equals("Boards | Trello")) {
			driver.findElement(By.xpath("//span[@title='Vineeth Kumar C (vineethkumarc1)']")).click();
			driver.findElement(By.xpath("//button[@data-testid='account-menu-logout']/..//span[text()='Log out']"))
					.click();
		}
		wait.until(ExpectedConditions.titleIs("Log out of your Atlassian account - Log in with Atlassian account"));
		if (driver.getTitle().equals("Log out of your Atlassian account - Log in with Atlassian account")) {
			driver.findElement(By.xpath("//span[text()='Log out']")).click();
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
