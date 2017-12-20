package testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import main.HomePage;

public class DisappearingElements {
	WebDriver driver;
	WebElement element;
	HomePage page = new HomePage(driver);
	
  @BeforeClass
  public void start()
	{
		driver = page.setup();
	}
  @Test
  public void checkdisappearingelements() throws InterruptedException //method to check the elements present in the web page before and after refresh
  {
	  element = driver.findElement(By.linkText("Disappearing Elements"));
	  element.click();
	  List<WebElement> list1 = driver.findElements(By.tagName("li"));
	 for(WebElement element : list1)
	 {
		System.out.println(element.findElement(By.tagName("a")).getText());
	 }
	 System.out.println("Number of tabs present on the page:  " + list1.size());
	 driver.navigate().refresh();
	 Thread.sleep(3000);
	 System.out.println();
	 List<WebElement> list2 = driver.findElements(By.tagName("li"));
	 for(WebElement element : list2)
	 {
		System.out.println(element.findElement(By.tagName("a")).getText());
	 }
	 System.out.println("Number of tabs present after refreshing the page:  " + list2.size());
  }
  
  @AfterClass
  public void end()
  {
	  page.goToHomepage();
	  page.teardown();
  }
}
