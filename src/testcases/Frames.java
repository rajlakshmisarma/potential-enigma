package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class Frames {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
  @BeforeClass
  public void start()
	{
		driver = page.setup();
	}
  @Test
  public void frames1() throws InterruptedException //Nested Frames
  {
	  element = driver.findElement(By.linkText("Frames"));
	  element.click();
	  driver.findElement(By.linkText("Nested Frames")).click();
	 // int number = Integer.parseInt(((JavascriptExecutor)driver).executeScript("return window.length").toString());
	  List<WebElement>  frames = driver.findElements(By.tagName("frame")); //total 2 frames in the page (top and bottom)
	  int number = frames.size();
	  System.out.println("Total number of frames in the page: " + number);
	  driver.switchTo().frame(0); //switching to top frame
	  List<WebElement>  topframes = driver.findElements(By.tagName("frame")); //top frame again has multiple frames nested
	  System.out.println("Number of nested frames in the Top frame: " + topframes.size());
	  System.out.println("Nested frames present in the Top frame: ");
	  for(int i=0; i < topframes.size() ; i++) //iterating over each of the frames and printing their contents
	  {
		  driver.switchTo().frame(i);
		  System.out.println(driver.findElement(By.tagName("body")).getText().trim());
		  driver.switchTo().defaultContent();
		  driver.switchTo().frame(0);
	  }
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame(1); //switching to the bottom frame
	  System.out.println("Bottom frame: ");
	  System.out.println(driver.findElement(By.tagName("body")).getText().trim());
	  driver.switchTo().defaultContent(); //switch to parent window
	  Thread.sleep(2000);
	  driver.navigate().back();
  }
  @Test
  public void frames2() throws InterruptedException //IFrames - WYSIWYG Editor
  {
	  driver.findElement(By.linkText("iFrame")).click();
	  WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
	  driver.switchTo().frame(iframe);
	  driver.findElement(By.tagName("body")).clear();
	  ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '<h1>Sample Content</h1>Hello World!'", driver.findElement(By.tagName("body")));
	  Thread.sleep(3000);
	  driver.switchTo().defaultContent();
	  driver.navigate().back();
  }
 @AfterClass
 public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
