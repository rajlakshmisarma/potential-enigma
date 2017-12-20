package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import main.HomePage;

public class ShiftingContent {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
	 @BeforeClass
	  public void start()
		{
			driver = page.setup();
		}
  @Test
  public void shiftingcontent1() throws InterruptedException //capture shifting Menu item on page
  {
	  element = driver.findElement(By.linkText("Shifting Content"));
	  element.click(); 
	  driver.findElement(By.linkText("Example 1: Menu Element")).click();
	  WebElement tab = driver.findElement(By.className("shift"));
	  Point position = tab.getLocation();
	  int xpos = position.getX();
	  int ypos = position.getY();
	  System.out.println("Position of the tab 'Gallery' currently: "+ "X coordinate ---> " + xpos + ", " + "Y coordinate ---> " + ypos);
	  Thread.sleep(2000);
	  driver.navigate().refresh();
	  Thread.sleep(2000);
	  WebElement tab1 = driver.findElement(By.className("shift"));
	  Point newposition = tab1.getLocation();
	  int newx = newposition.getX();
	  int newy = newposition.getY();
	  System.out.println("Position of the tab 'Gallery' after refreshing the page: "+ "X coordinate ---> " + newx + ", " + "Y coordinate ---> " + newy);
	  driver.navigate().back();
  }
  @Test
  public void shiftingcontent2() throws InterruptedException //capture shifting image on page
  {
	  driver.findElement(By.linkText("Example 2: An image")).click();
	  WebElement img = driver.findElement(By.className("shift"));
	  Point position = img.getLocation();
	  int xpos = position.getX();
	  int ypos = position.getY();
	  System.out.println("Position of the image currently: "+ "X coordinate ---> " + xpos + ", " + "Y coordinate ---> " + ypos);
	  Thread.sleep(2000);
	  driver.navigate().refresh();
	  Thread.sleep(2000);
	  WebElement img1 = driver.findElement(By.className("shift"));
	  Point newposition = img1.getLocation();
	  int newx = newposition.getX();
	  int newy = newposition.getY();
	  System.out.println("Position of the image after refreshing the page: "+ "X coordinate ---> " + newx + ", " + "Y coordinate ---> " + newy);
	  driver.navigate().back();
  }
  @Test
  public void shiftingcontent3() throws InterruptedException //capture changing text on page
  {
	  driver.findElement(By.linkText("Example 3: List")).click();
	  WebElement text = driver.findElement(By.className("large-centered"));
	  System.out.println("Current text present: ");
	  System.out.println(text.getText().trim());
	  driver.navigate().refresh();
	  Thread.sleep(2000);
	  WebElement newtext = driver.findElement(By.className("large-centered"));
	  System.out.println("Text after refreshing the page: ");
	  System.out.println(newtext.getText().trim());
	  driver.navigate().back();
  }
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
