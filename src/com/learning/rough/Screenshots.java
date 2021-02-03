package com.learning.rough;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();

		File f = new File("C:\\Users\\gowthaman\\git\\TestLeafSeleniumChallenge\\Output\\screenshot.jpg");

		if (f.exists()) {
			f.delete();
		}

		File e = new File("C:\\Users\\gowthaman\\git\\TestLeafSeleniumChallenge\\Output\\Fullscreenshot.jpg");

		if (e.exists()) {
			e.delete();
		}
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		/*
		 * FileUtils.copyFile(screenshot, new File(
		 * "C:\\Users\\gowthaman\\git\\TestLeafSeleniumChallenge\\Output\\screenshot.jpg"
		 * ));
		 */
		FileUtils.copyFile(screenshot,f);
	
	}

}
