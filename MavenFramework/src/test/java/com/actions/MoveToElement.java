package com.actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MoveToElement {
	public static WebDriver driver;
    public static Actions actions;
	@BeforeMethod
	public void preCondition() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void moveToElementHorizontal() {
		driver.get("https://www.myntra.com/");
		actions = new Actions(driver);
		WebElement Men = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Men']"));
		WebElement Women = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Women']"));
		WebElement Kids = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Kids']"));
		WebElement HomeLiving = driver
				.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Home & Living']"));
		WebElement Beauty = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Beauty']"));
		WebElement Studio = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Studio']"));
		actions.moveToElement(Studio, 0, 0).pause(2000).moveToElement(Beauty, 42, 0).pause(2000)
				.moveToElement(HomeLiving, 107, 0).moveToElement(Kids, 94, 0).pause(2000).moveToElement(Women, 74, 0)
				.pause(2000).moveToElement(Men, 73, 0).pause(2000).perform();
	}

	@Test
	public void moveToElementVertical() {
		driver.get(
				"https://www.landrover.in/range-rover/range-rover/index.html?utm_source=gs&utm_medium=sem&utm_campaign=in_nv_rr_rr_all_suv_my24_en_gmc1000_thk_cpdxue_gs_ds_2404_dsa_ext_geo_nu_xpl_nu_sem_04274418_dg_nu_B-P-RR-NEWRR-1CAMPP1&utm_content=NewRR_P1_Exact_Always_On&gad_source=1&gclid=EAIaIQobChMIjYH_hvKdiQMVFatmAh2w3zcVEAAYASAAEgIFOvD_BwE&gclsrc=aw.ds");
		actions = new Actions(driver);
		driver.findElement(By.xpath("//span[text()='VEHICLES']")).click();
         WebElement EVOQUE = driver.findElement(By.xpath("//p[text()='RANGE ROVER EVOQUE']"));
         WebElement VELAR = driver.findElement(By.xpath("//p[text()='RANGE ROVER VELAR']"));
         WebElement SPORT = driver.findElement(By.xpath("//p[text()='RANGE ROVER SPORT']"));
         WebElement ROVER = driver.findElement(By.xpath("//p[text()='RANGE ROVER']"));
         WebElement OCTA = driver.findElement(By.xpath("//p[text()='DEFENDER OCTA']"));
         WebElement DEFENDER130 = driver.findElement(By.xpath("//p[text()='DEFENDER 130']"));
         WebElement DEFENDER110 = driver.findElement(By.xpath("//p[text()='DEFENDER 110']"));
         WebElement DEFENDER90 = driver.findElement(By.xpath("//p[text()='DEFENDER 90']"));
         WebElement DISCOVERYSPORT = driver.findElement(By.xpath("//p[text()='DISCOVERY SPORT']"));
         WebElement DISCOVERY = driver.findElement(By.xpath("//p[text()='DISCOVERY']"));
         actions.moveToElement(EVOQUE,0,0).pause(2000).moveToElement(VELAR,0,6).pause(2000).moveToElement(SPORT,0,6).pause(2000).moveToElement(ROVER,0,6).pause(2000).moveToElement(OCTA,0,6).pause(2000).moveToElement(DEFENDER130,0,6).pause(2000).moveToElement(DEFENDER110,0,6).pause(2000).moveToElement(DEFENDER90,0,6).pause(2000).moveToElement(DISCOVERYSPORT,0,6).pause(2000).moveToElement(DISCOVERY,0,6).pause(2000).perform();
	}

	@AfterMethod
	public void postCondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
}
