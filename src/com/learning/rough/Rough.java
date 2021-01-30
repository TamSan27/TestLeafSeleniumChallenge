package com.learning.rough;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rough {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver ;
		// TODO Auto-generated method stub
		
		String initialResultsCount,totalPagess;
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
		
		
		WebElement filteredNoOfItems = driver.findElement(By.xpath("//div[@class='filter-container']//div[@class='length']"));
		
		List<WebElement> list = new ArrayList<WebElement>();
		List<WebElement> list1 = new ArrayList<WebElement>();
		
		while(list.size()<501) {
			
			list1 = driver.findElements(By.xpath("//div[@class='name']"));
			list.addAll(list1);
			WebElement ele = list1.get(list1.size()-1);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		}
			
		
		System.out.println("Total size:"+list.size());
		
		for(WebElement e:list) {
			String text = e.getText();
			System.out.println("Print the dress name"+text);
		}
		
		
	}

}
