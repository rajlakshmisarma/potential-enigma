package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class JSAlerts {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	 @BeforeClass
	  public void start()
		{
			driver = page.setup();
		}
  @Test
  public void jsalerts1() throws InterruptedException
  {
	  element = driver.findElement(By.linkText("JavaScript Alerts"));
	  element.click();
	  
	  driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button")).click(); //javascript alert
	 String alert =  driver.switchTo().alert().getText();
	 System.out.println(alert);
	 Assert.assertEquals(alert, "I am a JS Alert");
	 Thread.sleep(2000);
	 driver.switchTo().alert().accept();
	 System.out.println(driver.findElement(By.id("result")).getText());
	 Thread.sleep(2000);
  }
  @Test
  public void jsalerts2() throws InterruptedException
  {
	  
	 driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();  //javascript confirm
	 String confirm = driver.switchTo().alert().getText();
	 System.out.println(confirm);
	 Thread.sleep(2000);
	 Assert.assertEquals(confirm, "I am a JS Confirm");
	 driver.switchTo().alert().dismiss();
	 Thread.sleep(2000);
	 System.out.println(driver.findElement(By.id("result")).getText());
  }
  @Test
  public void jsalerts3() throws InterruptedException
  {
	 driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click(); //javascript prompt
	 String prompt = driver.switchTo().alert().getText();
	 System.out.println(prompt);
	 Assert.assertEquals(prompt, "I am a JS prompt");
	 driver.switchTo().alert().sendKeys("Hello World !!");
	 Thread.sleep(2000);
	 driver.switchTo().alert().accept();
	 Thread.sleep(2000);
	 System.out.println(driver.findElement(By.id("result")).getText());
  }
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
