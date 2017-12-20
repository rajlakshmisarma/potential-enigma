package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class Geolocation {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
  @BeforeClass
  public void start()
	{
		driver = page.setup();
	}
  @Test
  public void geolocation1() throws InterruptedException, IOException //find latitude and longitude of the current location
  {
	  element = driver.findElement(By.linkText("Geolocation"));
		element.click();
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(2000);
		System.out.println("Latitude: --> " + driver.findElement(By.id("lat-value")).getText());
		System.out.println("Longitude: --> " + driver.findElement(By.id("long-value")).getText());
		Thread.sleep(2000);
		driver.findElement(By.linkText("See it on Google")).click();
		Thread.sleep(3000);
		File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination1 = new File("D:\\screenshots\\test1.jpg");
		FileUtils.copyFile(screenshot1, destination1);
  }
  @Test
  public void geolocation2() throws InterruptedException, IOException //find nearby places in the map from the current location
  {
	  String xpath = "//*[@id='pane']/div/div[2]/div/div/div[2]/div[1]/button[1]/div[2]";
	  driver.findElement(By.xpath(xpath)).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("searchboxinput")).sendKeys("Hotels");
	  driver.findElement(By.id("searchbox-searchbutton")).click();
	  Thread.sleep(5000);
	  File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File destination2 = new File("D:\\screenshots\\test2.jpg");
	  FileUtils.copyFile(screenshot2, destination2);
  }
  @AfterClass
  public void end()
  {
	  driver.get(page.getURL());
	  page.teardown();
  }
}
