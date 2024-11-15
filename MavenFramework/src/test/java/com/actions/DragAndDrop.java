package com.actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDrop {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    public static Workbook workbook;

    @BeforeMethod
    public void preCondition() throws EncryptedDocumentException, IOException {
        // Load Excel file and initialize WebDriver
        FileInputStream file = new FileInputStream("./src/test/resource/trellologindetails.xlsx");
        workbook = WorkbookFactory.create(file);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://trello.com/home");
    }

    @Test
    public void dragAndDrop() {
        loginToTrello();
        createBoard();
        addCardsAndChecklists();
        closeAndDeleteBoard();
        logout();
    }

    // Login Method
    public void loginToTrello() {
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        wait.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
        
        driver.findElement(By.xpath("//input[@name='username']"))
              .sendKeys(workbook.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue());
        driver.findElement(By.xpath("//span[text()='Continue']")).click();
        
        driver.findElement(By.xpath("//input[@name='password']"))
              .sendKeys(workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue());
        driver.findElement(By.xpath("//span[text()='Log in']")).click();
        
        wait.until(ExpectedConditions.titleIs("Boards | Trello"));
    }

    // Create Board Method
    public void createBoard() {
        driver.findElement(By.xpath("//span[text()='Create new board']")).click();
        driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']"))
              .sendKeys(workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue());
        
        driver.findElement(By.xpath("//button[text()='Create']")).click();
        wait.until(ExpectedConditions.titleIs(workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue() + " | Trello"));
    }

    // Add Cards and Checklists
    public void addCardsAndChecklists() {
        for (int r = 1; r <= 5; r++) {
            // Add card names from Excel file
            driver.findElement(By.xpath("//textarea[@class='qJv26NWQGVKzI9']"))
                  .sendKeys(workbook.getSheet("Sheet1").getRow(r).getCell(3).getStringCellValue());
            driver.findElement(By.xpath("//textarea[@class='qJv26NWQGVKzI9']")).sendKeys(Keys.ENTER);
        }
        handleChecklistItems();
    }

    // Handle Checklist Items for Cards
    public void handleChecklistItems() {
        for (int r = 1; r <= 5; r++) {
            String cardTitle = workbook.getSheet("Sheet1").getRow(r).getCell(3).getStringCellValue();
            WebElement card = driver.findElement(By.xpath("//a[text()='" + cardTitle + "']"));
            card.click();
            driver.findElement(By.xpath("//span[text()='Checklist']")).click();
            
            // Add checklist
            driver.findElement(By.xpath("//input[@id='id-checklist']"))
                  .sendKeys(workbook.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue(), Keys.ENTER);

            for (int r1 = 1; r1 <= 5; r1++) {
                driver.findElement(By.xpath("//textarea[@data-testid='check-item-name-input']"))
                      .sendKeys(workbook.getSheet("Sheet1").getRow(r1).getCell(r + 5).getStringCellValue(), Keys.ENTER);
            }
            driver.findElement(By.xpath("//span[@data-testid='CloseIcon']")).click();
        }
    }

    // Close and Delete Board Method
    public void closeAndDeleteBoard() {
        driver.findElement(By.xpath("//button[@aria-label='Show menu']")).click();
        driver.findElement(By.xpath("//div[text()='Close board']")).click();
        driver.findElement(By.xpath("//input[@data-testid='close-board-confirm-button']")).click();
        driver.findElement(By.xpath("//button[@data-testid='close-board-delete-board-button']")).click();
        driver.findElement(By.xpath("//button[@data-testid='close-board-delete-board-confirm-button']")).click();
    }

    // Logout Method
    public void logout() {
        driver.findElement(By.xpath("//span[@title='Vineeth Kumar C (vineethkumarc1)']")).click();
        driver.findElement(By.xpath("//span[text()='Log out']")).click();
        wait.until(ExpectedConditions.titleIs("Log out of your Atlassian account - Log in with Atlassian account"));
        driver.findElement(By.xpath("//span[text()='Log out']")).click();
    }

    @AfterMethod
    public void postCondition() {
        driver.manage().window().minimize();
        driver.quit();
    }
}
