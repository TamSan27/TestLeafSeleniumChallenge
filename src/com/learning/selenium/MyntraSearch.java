package com.learning.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class MyntraSearch {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		WebElement closeButton, moreBrand, searchBox, button, firstProduct;
		String totalNoOfPages, total, firstProductName;
		int number, totalNoOfSimlrProducts, size;
		boolean nextButAvailable;
		List<WebElement> Similarglasses, MenRectangleglasses;

		Robot rb = new Robot();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		// capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		Dimension initial_size = driver.manage().window().getSize();
		int height = initial_size.getHeight();
		int width = initial_size.getWidth();
		System.out.println("Browser dimension are:");
		System.out.println("Height is:" + height);
		System.out.println("width is:" + width);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		searchBox = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		searchBox.click();
		searchBox.sendKeys("Sunglasses");
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		rb.keyPress(KeyEvent.VK_PAGE_DOWN);

		moreBrand = driver.findElement(By.xpath("//div[@class='brand-more']"));
		moreBrand.click();
		driver.findElement(By.xpath("//label[text()='Polaroid']//div")).click();
		driver.findElement(By.xpath("//span[contains(@class,'FilterDirectory-close')]")).click();

		totalNoOfPages = driver.findElement(By.xpath("//div[@class='results-showMoreContainer']/ul/li[1]")).getText();
		total = totalNoOfPages.substring(10);
		number = Integer.parseInt(total);
		button = driver.findElement(By.xpath("//li[@class='pagination-next']"));
		nextButAvailable = button.isDisplayed();
		System.out.println("Men Rectangle Glasses:");
		for (int i = 1; i <= number; i++) {
			if (i > 1) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", moreBrand);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[text()='" + i + "']")).click();
			}
			System.out.println("Page " + i + " glass products size are:");
			Thread.sleep(3000);
			MenRectangleglasses = driver.findElements(By.xpath(
					"//h4[text()='Men Rectangle Sunglasses']/following-sibling::h4/span[@class='product-sizeNoInventoryPresent']"));
			size = MenRectangleglasses.size();
			if (size != 0) {
				for (WebElement e : MenRectangleglasses) {
					String s = e.getAttribute("innerHTML");
					System.out.println("Size is:" + s);
				}
			} else {
				System.out.println("No Men Rectangle glasses available in this page.");
			}

			// if (nextButAvailable) {
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);", moreBrand);
			// Thread.sleep(1000);
			// button.click();
			// } after clicking second page, it is not going to the third page. Moving to the last page. Not sure why

		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", moreBrand);
		driver.findElement(By.xpath("//a[text()='1']")).click();
		Thread.sleep(2000);

		firstProduct = driver.findElement(By.xpath("//ul[@class='results-base']/li[1]//h4[@class='product-product']"));
		Actions action = new Actions(driver);
		action.moveToElement(firstProduct).perform();

		driver.findElement(By.xpath("//ul[@class='results-base']/li[1]//span[text()='VIEW SIMILAR']/parent::div"))
				.click();
		Thread.sleep(2000);
		Similarglasses = driver.findElements(By.xpath("//div[@class='results-similarItemContainer']/ul/li"));
		totalNoOfSimlrProducts = Similarglasses.size();
		System.out.println("Totally " + totalNoOfSimlrProducts + " similar products are available");

	}

}
