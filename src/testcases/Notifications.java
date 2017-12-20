package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class Notifications {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	 @BeforeClass
	  public void start()
		{
			driver = page.setup();
		}
  @Test
  public void notifications() throws InterruptedException //capturing the notifications messages
  {
	  element = driver.findElement(By.linkText("Notification Messages"));
	  element.click();
	  Thread.sleep(2000);
	  String text = driver.findElement(By.id("flash")).getText().trim();
	  System.out.println(text);
	  driver.findElement(By.linkText("Click here")).click();
	  Thread.sleep(2000);
	  String text2 = driver.findElement(By.id("flash")).getText().trim();
	  System.out.println(text2);
  }
  @AfterClass
  public void end()
  {
	  driver.get(page.getURL());
	  	page.teardown();
  }
}
