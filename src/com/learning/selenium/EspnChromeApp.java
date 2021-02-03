package com.learning.selenium;

import java.io.File;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class EspnChromeApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\\\Drivers\\\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://espncricinfo.com/");
		
		driver.findElement(By.xpath("//span[text()='BBL']")).click();
		//driver.manage().window().maximize();
		
		
		  Screenshot screenshot=new
		  AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
		  takeScreenshot(driver); try { ImageIO.write(screenshot.getImage(),"JPG",new
		  File(
		  "C:\\Users\\gowthaman\\git\\TestLeafSeleniumChallenge\\Output\\screenshot1.jpg"
		  )); } catch(Exception e) { System.out.println("Exception occured");
		  
		  System.out.println(e.getMessage());
		  
		  }
		 
	}

}
