package com.learning.selenium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ChromeAjioSearch {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = null;
	//	try {

		
		WebDriverWait wait ;
		int count,lwrcaseCount=0;
		int discountItemsCount =0;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebElement mostLowerCaseBrandItem = null;
		driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		
		WebElement women = driver.findElement(By.xpath("//a[text()='WOMEN']"));
		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(women));
	
		action.moveToElement(women).build().perform();
		
		Thread.sleep(1000);
		
		WebElement collections = driver.findElement(By.xpath("//span[text()='NEW IN: COLLECTIONS']"));
		action.moveToElement(collections).build().perform();
		Thread.sleep(1000);
		WebElement brands = driver.findElement(By.xpath("//a[text()='BRANDS']"));
		action.moveToElement(brands).build().perform();
		
		Thread.sleep(2000);
		List<WebElement> brandItems = new ArrayList<WebElement>();
		brandItems = driver.findElements(By.xpath("//a[text()='WOMEN']/parent::li//a[text()='BRANDS']/parent::li//div[@class='items']/span/a"));
		
		Thread.sleep(3000);
		for(WebElement brandItem:brandItems) {
			count =0;
			String itemText = brandItem.getText();
			System.out.println("item text:"+itemText);
			
		//	char[] ch = new char[itemText.length()];
			
			for(int i=0;i<itemText.length();i++) {
				if(itemText.charAt(i) >= 97 && itemText.charAt(i) <=122)
					count++;
							}
			
			
			if(lwrcaseCount<count) {
				lwrcaseCount = count;
				mostLowerCaseBrandItem = brandItem;
			}
		}
		
		mostLowerCaseBrandItem.click();
		Thread.sleep(4000);
		WebElement initialNoOfItems = driver.findElement(By.xpath("//div[@class='filter-container']//div[@class='length']"));
		wait.until(ExpectedConditions.visibilityOf(initialNoOfItems));
		String initialNoOfItemsCountText = initialNoOfItems.getText();
		int intialNoOfItemsCount = getItemsCount(initialNoOfItemsCountText);
		
		
		/*
		 * Robot rb = new Robot(); rb.keyPress(KeyEvent.VK_DOWN);
		 * rb.keyRelease(KeyEvent.VK_DOWN); rb.keyPress(KeyEvent.VK_DOWN);
		 * rb.keyRelease(KeyEvent.VK_DOWN);
		 */
		WebElement cateogry = driver.findElement(By.xpath("//span[text()='category']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cateogry);
		
		driver.findElement(By.xpath("//span[text()='size & fit']")).click();
		driver.findElement(By.xpath("//span[text()='size & fit']/parent::div/following-sibling::div//input[@value='S']/parent::div/label")).click();
		Thread.sleep(1000);
		WebElement filteredNoOfItems = driver.findElement(By.xpath("//div[@class='filter-container']//div[@class='length']"));
		wait.until(ExpectedConditions.visibilityOf(filteredNoOfItems));
		String filteredNoOfItemsCountText = filteredNoOfItems.getText();
		int filteredNoOfItemsCount = getItemsCount(filteredNoOfItemsCountText);
		
		if(intialNoOfItemsCount>filteredNoOfItemsCount) {
			System.out.println("Items has been reduced after filter with S size");
		}else {
			System.out.println("Items has not been reduced after filter with S size");
		}
		
		WebElement ele = driver.findElement(By.xpath("//select"));
		Select se = new Select(ele);
		se.selectByValue("discount-desc");
		// check the collection objects to store 511 elements .. that is incomplete
		/*
		 * List<WebElement> discountElement = new ArrayList<WebElement>();
		 * //List<WebElement> discountEle = new ArrayList<WebElement>(); Set<WebElement>
		 * discountEle = new HashSet<WebElement>();
		 * while(discountElement.size()<=filteredNoOfItemsCount) {
		 * 
		 * discountEle = driver.findElements(By.xpath("//span[@class='discount']"));
		 * System.out.println("Size of an discousnted items"+discountElement.size());
		 * discountElement.addAll(discountEle); WebElement ele1 =
		 * discountElement.get(discountElement.size()-1); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", ele1); }
		 */
		
	    
	 //   int firstDiscount =60;
	//    discountElement.add
		/*
		 * for(WebElement e:discountElement) {
		 * 
		 * String discountText = e.getText();
		 * System.out.println("discount text is:"+discountText); int discountCount =
		 * getDiscountNumber(discountText);
		 * System.out.println("Discount no"+discountCount);
		 * if(firstDiscount>discountCount) { firstDiscount = discountCount; }else
		 * if(firstDiscount==discountCount) {
		 * 
		 * } else { System.out.println("Items are not in order"); }
		 * 
		 * }
		 * 
		 * discountItemsCount = discountItemsCount + discountElement.size();
		 * System.out.println("total items"+discountItemsCount);
		 */
		
	//	WebElement lastElement = discountElement.get(discountElement.size()-1);
	//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastElement);
//	}
		
		
	//	}
		/*catch(Exception e) {
			System.out.println("Exception occured"+e.getMessage());
	//		driver.close();
		}*/
	}
	
 private static int getItemsCount(String itemsCountText) {
	 int cut=0;
	 String NoOfItemsCountText = itemsCountText;
		for(int i=0;i<NoOfItemsCountText.length();i++) {
			if(NoOfItemsCountText.charAt(i)== ' ') {
				
				cut = i;
				break;
			}
		}
		String temp = NoOfItemsCountText.substring(0, cut);
		int  noOfItemsCount = Integer.parseInt(temp);
		System.out.println("Total count is:"+noOfItemsCount);
		
		return noOfItemsCount;
	 
 }
 private static int getDiscountNumber(String itemsCountText) {
	 int cut=0;
	 String NoOfItemsCountText = itemsCountText;
		for(int i=0;i<NoOfItemsCountText.length();i++) {
			if(NoOfItemsCountText.charAt(i)== '%') {
				
				cut = i;
				break;
			}
		}
		String temp = NoOfItemsCountText.substring(1, cut);
		int  noOfItemsCount = Integer.parseInt(temp);
		System.out.println("Total count is:"+noOfItemsCount);
		
		return noOfItemsCount;
	 
 }
 
}
