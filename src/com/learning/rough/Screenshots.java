package com.learning.rough;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.ajio.com/");
	//	driver.manage().window().maximize();

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
		FileUtils.copyFile(screenshot, f);

		// String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new
		// Date());
		// timestamp concept

		Screenshot fullScreenshot1 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		try {
			ImageIO.write(fullScreenshot1.getImage(),"JPG",
					new File("C:\\Users\\gowthaman\\git\\TestLeafSeleniumChallenge\\Output\\Fullscreenshot.jpg"));
		} catch (Exception exp) {
			System.out.println("Exception occured");
			driver.quit();
		}

		driver.quit();
	}

}
