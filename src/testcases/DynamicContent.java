package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.HomePage;

public class DynamicContent {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
  @BeforeClass
  public void start()
	{
		driver = page.setup();
	}
  @Test
  public void dynamicContent() //method to display the content of the page before and after refresh
  {
	  element = driver.findElement(By.linkText("Dynamic Content"));
		element.click();
		List<WebElement> content1 = driver.findElements(By.xpath("//*[@id='content']/div"));
		System.out.println("Currently displayed page content: ");
		System.out.println();
		for(WebElement ele : content1)
		{
			System.out.println("Image : " +  ele.findElement(By.tagName("img")).getAttribute("src").toString());
			System.out.println("Text present: " + ele.findElement(By.className("large-10")).getText());
		}
		System.out.println();
		
		List<WebElement> content2 = driver.findElements(By.xpath("//*[@id='content']/div"));
		System.out.println("Content displayed after refreshing the page: ");
		for(WebElement ele : content2)
		{
			System.out.println("Image : " +  ele.findElement(By.tagName("img")).getAttribute("src").toString());
			System.out.println("Text present: " + ele.findElement(By.className("large-10")).getText());
		}
  }
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
