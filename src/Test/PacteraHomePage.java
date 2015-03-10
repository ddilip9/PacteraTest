package Test;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class PacteraHomePage {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try
		{
		
		String expTitle = "Global IT Consulting, Solution, and Outsourcing Services from Pactera";
		String searchString = "test automation";
		
		WebDriver WebDriver = new FirefoxDriver();
		WebDriver.manage().window().maximize();
		WebDriver.get("http://www.pactera.com");

		
		if(expTitle.equals(WebDriver.getTitle()))
			System.out.println("Home Page Test Case : Title Expected [" + expTitle + "] Actual ["+ WebDriver.getTitle() + "]  ---> PASS" );
		else
			System.out.println("Home Page Test Case : Title Expected [" + expTitle + "] Actual ["+ WebDriver.getTitle() + "]  ---> FAIL" );

		WebDriver.findElement(By.id("s")).sendKeys(searchString);
		WebDriver.findElement(By.id("searchsubmit")).click();
		
		
		
		WebElement element = WebDriver.findElement(By.xpath("//*[@id='content']"));
		
		int tCount  = element.findElements(By.tagName("p")).size();
		int anchorCount  = element.findElements(By.tagName("a")).size();
		int resCount = (tCount-1)/2;
		
		String dispStr = WebDriver.findElement(By.xpath("//*[@id='content']/p[1]/em/strong")).getText();
		
		
		if(searchString.equals(dispStr))
			System.out.println("Search Results Page  Test Step-1 : input Search String [" + searchString + "] Results Displayed for  ["+ dispStr + "]  ---> PASS" );
		else
			System.out.println("Search Results Page  Test Step-1 : input Search String [" + searchString + "] Results Displayed for  ["+ dispStr + "]  ---> FAIL" );

		System.out.println("Search Results Page  Test Step-2 : input Search String [" + searchString + "] Results Returned =   ["+ resCount + "]  ---> PASS" );
				
		WebDriver.close();
		
		
		
		}catch(Exception e){
			System.out.println("Error in Executing the Test Case ... Find the Stack Trace Below .... ");
			e.printStackTrace();
		}
		
		
		
	}

}
