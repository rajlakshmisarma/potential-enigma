package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import main.HomePage;

public class MultipleWindows {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	 @BeforeClass
	  public void start()
		{
			driver = page.setup();
		}
  @Test
  public void multiplewindows() throws InterruptedException //method to handle multiple windows
  {
	  element = driver.findElement(By.linkText("Multiple Windows"));
	  element.click();
	  String parentwindow = driver.getWindowHandle();
	  String parentwindowname = driver.findElement(By.tagName("h3")).getText();
	  System.out.println(parentwindowname);
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Click Here")).click();
	  Thread.sleep(2000);
	  for(String winhandle : driver.getWindowHandles())
	  {
		  driver.switchTo().window(winhandle);
	  }
	 String newwindowname = driver.findElement(By.tagName("h3")).getText();
	 System.out.println(newwindowname);
	 Assert.assertEquals(newwindowname, "New Window");
	 driver.close();
	 Thread.sleep(2000);
	 driver.switchTo().window(parentwindow);
	Assert.assertEquals(parentwindowname, "Opening a new window");
  }
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
