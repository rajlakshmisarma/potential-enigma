package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import main.HomePage;

public class Redirection {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
	 @BeforeClass
	  public void start()
		{
			driver = page.setup();
		}
  @Test
  public void redirect1() throws InterruptedException //Redirection page
  {
	  element = driver.findElement(By.linkText("Redirect Link"));
	  element.click(); 
	  String homepage = driver.findElement(By.tagName("h3")).getText();
	  System.out.println(homepage);
	  Assert.assertEquals(homepage, "Redirection");
	  driver.findElement(By.linkText("here")).click();
	  Thread.sleep(2000);
	  String statuscodepage = driver.findElement(By.tagName("h3")).getText();
	  System.out.println(statuscodepage);
	  Assert.assertEquals(statuscodepage, "Status Codes");
  }
  @Test
  public void redirect2() throws InterruptedException //Registry page
  {
	  driver.findElement(By.linkText("here")).click();
	  Thread.sleep(2000);
	  String codepagetitle = driver.getTitle();
	  System.out.println("Title of the Registry page: --> " + codepagetitle);
	  Thread.sleep(2000);
	  driver.navigate().back();
	  Thread.sleep(2000);
  }
  @Test
  public void redirect3() throws Exception //Status Codes page
  {  
	  List<WebElement> list = driver.findElements(By.tagName("li")); //capturing individual status codes pages
	  int size = list.size();	
	  for( int i=0; i < size; i++)
	  {
		  List<WebElement> newlist = driver.findElements(By.tagName("li")); //capturing the DOM elements again to handle StaleElementReference Exception
		 System.out.println("Status Code: --> " + newlist.get(i).getText());
		newlist.get(i).findElement(By.tagName("a")).click();
		 Thread.sleep(2000);
		 String text = driver.findElement(By.tagName("p")).getText().trim().substring(0, 37);
		 System.out.println(text);
		driver.navigate().back();
		driver.navigate().refresh();
	  }
  }
  @AfterClass
  public void end()
  {
	 driver.get(page.getURL());
	  page.teardown();
  }
}
