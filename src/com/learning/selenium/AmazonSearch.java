package com.learning.selenium;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearch<List> {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = null;
		// TODO Auto-generated method stub
		
		String initialResultsCount,totalPages;
		WebElement searchBar,priceFilter,pageCount,nextButton,firstProduct;
		int totalPageCount;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ajio.com/s/rangmanch-by-pantaloons-4042-53541?query=%3Arelevance&curated=true&curatedid=rangmanch-by-pantaloons-4042-53541&gridColumns=3");
		
		driver.manage().window().maximize();
		WebElement cateogry = driver.findElement(By.xpath("//span[text()='category']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cateogry);
		
		driver.findElement(By.xpath("//span[text()='size & fit']")).click();
	//	driver.findElement(By.xpath("//span[text()='size & fit']/parent::div/following-sibling::div/div[text()='MORE']")).click();
		
		driver.findElement(By.xpath("//span[text()='size & fit']/parent::div/following-sibling::div//input[@value='S']/parent::div/label")).click();
		
		
		/*
		 * WebElement clickable = driver.findElement(By.
		 * xpath("//div[contains(text(),'Choose ')]/parent::div/following-sibling::div//label/input[@value='S']"
		 * )); WebDriverWait wait = new WebDriverWait(driver,50);
		 * wait.until(ExpectedConditions.elementToBeClickable(clickable));
		 * clickable.click();
		 */	}

//	HashMap<String, String> capitalCities = new HashMap<String, String>();
	
	//List discountElement = new ArrayList<>();
	//discountElement = driver.findElements(By.xpath("//span[@class='discount']"));
		
	
}
