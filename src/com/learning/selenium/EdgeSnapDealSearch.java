package com.learning.selenium;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class EdgeSnapDealSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();

		driver.get("https://www.snapdeal.com/");
		WebElement AllOffers = driver.findElement(By.xpath("//span[text()='All Offers']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(AllOffers));
		Actions action = new Actions(driver);
		action.moveToElement(AllOffers).build().perform();
		WebElement Watches = driver.findElement(By.xpath("//span[@class='linkTest' and text()='Watches']"));
		wait.until(ExpectedConditions.elementToBeClickable(Watches));
		Watches.click();

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		try {
			ImageIO.write(screenshot.getImage(), "JPG",
					new File("C:\\Users\\gowthaman\\git\\TestLeafSeleniumChallenge\\Output\\screenshot1.jpg"));
		} catch (Exception e) {
			System.out.println("Exception occured");

			System.out.println(e.getMessage());
			
			driver.quit();

		}

		driver.quit();

	}

}
