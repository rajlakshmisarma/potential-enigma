package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class Slider {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	 @BeforeClass
	  public void start()
		{
			driver = page.setup();
		}
  @Test
  public void slider() throws InterruptedException //move horizontal slider to right
  {
	  element = driver.findElement(By.linkText("Horizontal Slider"));
	  element.click();
	 WebElement element = driver.findElement(By.tagName("input"));
	 Actions action = new Actions(driver);
	 action.dragAndDropBy(element, 5, 0).perform();
	 System.out.println("Slider has been moved by: " + driver.findElement(By.id("range")).getText() + " value to right");
	 Thread.sleep(2000);
	 action.dragAndDropBy(element,-3, 0).perform();
	 System.out.println("Slider has been moved by: " + driver.findElement(By.id("range")).getText() + " value to left");
  }
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
