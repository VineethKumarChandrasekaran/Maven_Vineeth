package com.qsp.competition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CountryName {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.get("https://www.orangehrm.com/en/book-a-free-demo");
	   List<WebElement> countryname = new Select(driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"))).getOptions();
	   System.out.println("The Total No.of Countries are "+ countryname.size());
	   String count[]= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	   int cont = 1;
       for (WebElement country : countryname) {
    	   for(int i=0; i<=count.length-1;i++) {
		if(country.getText().startsWith(count[i])) {
			System.out.println("The Countries with the Letter "+count[i]+" is");
			System.out.println(country.getText());
		}
	}
	}
    driver.manage().window().minimize();
   	driver.quit();
	}
}
