package com.learning.selenium;

import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = null;
		// TODO Auto-generated method stub
		
		String initialResultsCount,totalPages;
		WebElement searchBar,priceFilter,pageCount,nextButton,firstProduct;
		int totalPageCount;
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe");
		//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//capabilities.setCapability("marionette",true);
		driver = new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		
		
	}

}
