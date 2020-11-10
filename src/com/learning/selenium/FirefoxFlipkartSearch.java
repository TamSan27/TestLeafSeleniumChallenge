package com.learning.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxFlipkartSearch {
     
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = null;
		try {
		//	Adding two products for compare and its verification is pending		Check line 113 
		String initialResultsCount,totalPages;
		WebElement searchBar,priceFilter,pageCount,nextButton,firstProduct,nextPage;
		int totalPageCount;
		Robot rb = new Robot();
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();

		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);
		searchBar = driver.findElement(By.xpath("//input[contains(@title,'Search for products')]"));
		searchBar.sendKeys("Home Theaters");
		searchBar.submit();
	
	    WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Showing')]")));
	    initialResultsCount = driver.findElement(By.xpath("//span[contains(text(),'Showing')]")).getText(); 
	    
		int initialResultCount = getCount(initialResultsCount);
	    	rb.keyPress(KeyEvent.VK_PAGE_DOWN);
	    		rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
	    		driver.findElement(By.xpath("//div[text()='4★ & above']/preceding-sibling::div")).click();
	    		Thread.sleep(2000);
	    		    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Showing')]")));
	    		initialResultsCount = driver.findElement(By.xpath("//span[contains(text(),'Showing')]")).getAttribute("innerHTML");
	    		 
	    		int ResultCount =	getCount(initialResultsCount); 
	        if(ResultCount < initialResultCount) {
	        	System.out.println("Confirmed the selection results");
	        }
	        priceFilter = driver.findElement(By.xpath("//div[text()='Price -- High to Low']"));
	        String attr = priceFilter.getAttribute("class");
	        System.out.println(attr);
	        priceFilter.click();
	        Thread.sleep(1000);
	        String attr1 = priceFilter.getAttribute("class");
	        System.out.println(attr1);
	        if(attr.equalsIgnoreCase(attr1)) {
	        	System.out.println("It is not clicked");
	        }else {
	        	System.out.println("It is clicked");
	        }
            pageCount = driver.findElement(By.xpath("//span[contains(text(),'Page')]"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pageCount);
	        
	        totalPages = pageCount.getText();
	        System.out.println("Total pages:"+totalPages);
	        String[] arrOfStr = totalPages.split(" ", 4); 
	        totalPageCount = Integer.parseInt(arrOfStr[3]);
	        firstProduct = driver.findElement(By.xpath("//div[@id='container']/div/div[3]/div[2]/div/div[2]/div/div/div[1]/div/a[3]/div/div[1]"));
	        String frstPrdocutText= firstProduct.getText();
	        int c = getAmount(frstPrdocutText);
	        for(int i=1;i<=totalPageCount;i++)
	        {
	        	System.out.println(i+" page clicked");
	        	if(i>1)
	        	{
	        		nextPage = driver.findElement(By.xpath("//a[text()='"+i+"']"));
	        		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pageCount);
	        		Actions action = new Actions(driver);
	        		action.moveToElement(nextPage).build().perform();
	        		nextPage.click();
	        	}
	        	  Thread.sleep(3000);   
	        	List<WebElement> allProducts = new ArrayList<WebElement>();
	        	allProducts = driver.findElements(By.xpath("//div[@id='container']/div/div[3]/div[2]/div/div[2]/div/div/div/div/a[3]/div/div[1]"));
	        	for(WebElement productPrice:allProducts) {
	        		String s = productPrice.getText();
	        		System.out.println(s);
	        		int b = getAmount(s);
			        System.out.println("After changing the value to Integer:"+b);
			        
			        if(c>b) {
			        	c=b;
			        }
			        else if(c<b)
			        {
			        	c=b;
			        	System.out.println("Amount is not sorted by High to low");
			        }
			        
	        }
			
		}
		
	/*	Adding two products for compare and its verification is pending
	        List<WebElement> compareList = new ArrayList<WebElement>();
	        compareList = driver.findElements(By.xpath("//div[@id='container']/div/div[3]/div[2]/div/div[2]/div/div/div[1]/div/a[2]"));
	        int compare =0;
	        for(WebElement e:compareList) {
	        	
	        	Actions action = new Actions(driver);
	        	action.moveToElement(e).build().perform();
	        	Thread.sleep(1000);
	        	String m = e.getText();
	        	System.out.println("Name of d home theater:"+m);
	        	WebElement addToCmpare= driver.findElement(By.xpath("//span[text()='Add to Compare']/parent::label/parent::div//input[@type='checkbox']/following-sibling::div"));
	        	addToCmpare.click();
	        	compare++;
	        	if(compare==2)
	        		break;
	        }
	        driver.findElement(By.xpath("//span[text()='COMPARE']")).click(); */
		}
		/*
		 * catch(Exception e) { driver.close(); }
		 */
		finally{
			driver.close();
		}
	
	}

	private static int getCount(String r) {
		// TODO Auto-generated method stub
		String initialResultsCount = r;
		 String[] arrOfStr = initialResultsCount.split(" ", 8); 
		  
		    //    for (String a : arrOfStr) 
		      //      System.out.println(a); 
		        
		        System.out.println(arrOfStr[5]);
		        String s = arrOfStr[5];
				
				  int count=0;
				  
				  for(int i=0;i<s.length();i++) {
					  if(s.charAt(i)==',') {
						  count++;
					  }
						  }
				  char[] a= new char[s.length()-count];
				  int j=0;
				  for(int i=0;i<s.length();i++) {
					  if(s.charAt(i)!=',') {
						  a[j]=s.charAt(i);
						  j++;
					  }
				  }
				  String str = new String(a); 
		        int b = Integer.parseInt(str);
		        System.out.println(b);
		       return b;
	}
	
	private static int getAmount(String value) {
		int count =0  ; 
		String s = value;
		for(int j=0;j<s.length();j++) {
			  if(s.charAt(j)==','||s.charAt(j)=='₹' ) {
				  count++;
			  }
	}
		char[] a= new char[s.length()-count];
		  int j=0;
		  for(int k=0;k<s.length();k++) {
			  if(s.charAt(k)!=','&& s.charAt(k)!='₹') {
				  a[j]=s.charAt(k);
				  j++;
			  }
		  }
		  String str = new String(a); 
        int b = Integer.parseInt(str);
		return b;
	}
}




