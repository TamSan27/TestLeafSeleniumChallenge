package com.learning.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusSearch {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		Thread.sleep(1000);
	//	WebElement To = driver.findElement(By.xpath("//label[text()='TO']"));
	//	WebElement sendIssue =(WebElement)new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='TO']")));
	//	sendIssue.click();
	//	To.click();
		WebElement Destination = driver.findElement(By.xpath("//label[text()='TO']/preceding::input[contains(@data-message,'destination')]"));
		Destination.click();
		Destination.sendKeys("Bangalore");
	  //  WebElement search = driver.findElement(By.xpath("//label[text()='Date']"));
	   // search.click();
	//	To.sendKeys("Banglore");
		driver.findElement(By.xpath("//li[text()='Bangalore (All Locations)']")).click();
		Thread.sleep(1000);
	    Robot rb = new Robot();
	    rb.keyPress(KeyEvent.VK_SHIFT);
	    rb.keyPress(KeyEvent.VK_TAB);
	    rb.keyRelease(KeyEvent.VK_SHIFT);
	    rb.keyRelease(KeyEvent.VK_TAB);
	    
	    WebElement Source = driver.findElement(By.xpath("//label[text()='FROM']/preceding::input[contains(@data-message,'destination')]"));
		Source.click();
		Source.sendKeys("Chennai");
		driver.findElement(By.xpath("//li[text()='Chennai (All Locations)']")).click();
		
		
		
	}

}
