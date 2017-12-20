package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class FileDownloader {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
  @BeforeClass
  public void start()
	{
		driver = page.setup();
	}
  @Test
  public void filedownload()
  {
	  element = driver.findElement(By.linkText("File Download"));
		element.click();
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("Links for File download and the Text displayed: ");
		for(WebElement ele : list)
		{
			if(ele.getAttribute("href")!=null && (!ele.getText().equals("")))
			{
				System.out.println(ele.getAttribute("href") + "----> " + ele.getText().toString());
			}
		}
  }
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
