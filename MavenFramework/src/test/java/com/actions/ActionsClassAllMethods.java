package com.actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassAllMethods {
    public static WebDriver driver;

    @BeforeMethod
    public void preCondition() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void clickTest() {
        driver.get("https://www.facebook.com/");
        Actions actions = new Actions(driver);
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        actions.click(loginButton).perform();
        Assert.assertTrue(driver.getTitle().contains("Log"), "Login action failed or page title is incorrect.");
    }

    @Test
    public void contextClickTest() {
        driver.get("https://www.facebook.com/");
        Actions actions = new Actions(driver);
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        actions.contextClick(loginButton).perform();
        Assert.assertTrue(loginButton.isDisplayed(), "Right click action failed on login button.");
    }

    @Test
    public void sendKeysTest() {
        driver.get("https://www.facebook.com/");
        Actions actions = new Actions(driver);
        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='email']"));
        actions.sendKeys(emailTextBox,"abc@gamil.com").perform();
    }
    
    @Test
    public void moveToElementTest() {
        driver.get("https://www.myntra.com/");
        Actions actions = new Actions(driver);
        List<WebElement> headerElements = driver.findElements(By.xpath("//div[@class='desktop-navLink']/a"));
        for (WebElement webElement : headerElements) {
			actions.moveToElement(webElement).pause(2000).perform();
		}
    }
    
    @AfterMethod
    public void postCondition() {
        driver.manage().window().minimize();
        driver.quit();
    }
}
